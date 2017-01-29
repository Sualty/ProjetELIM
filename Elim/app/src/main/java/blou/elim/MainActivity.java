package blou.elim;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.provider.Settings;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.security.AccessController.getContext;

public class MainActivity extends Activity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView proximitySensorValue;
    private PowerManager powerManager;

    private WebClient webClient;

    private Tracker mTracker;
    private String name_activity="Main";

    private SQLiteDatabase database;
    private FeedReaderDbHelper feedReaderDbHelper;

    private String androidId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        androidId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webClient = new WebClient();
        webClient.execute();

        /*example of how to send infos to google analytics*/
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        Log.i("BLOUBLOUBLOU", "ONCREATE: " + name_activity);
        mTracker.setScreenName("ONCREATE" + name_activity);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        /*initializing proximity sensor*/
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        /*initialize power manager for knowing if phone is in standby or not*/
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);

        /*initialize database and feedreaderhelper*/
        feedReaderDbHelper = new FeedReaderDbHelper(this);
        database = feedReaderDbHelper.getWritableDatabase();

        Button sendDatasButton = (Button)findViewById(R.id.send_datas);
        sendDatasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webClient.sendData(getDatasJson());
                database.delete("datas", null, null);
            }
        });
    }

    private String getDatasJson(){
        Cursor cursor = database.rawQuery("select * from datas",null);
        JSONArray datasJson = new JSONArray();
        if (cursor.moveToFirst()) {
            do {
                String[] allNames = cursor.getColumnNames();
                JSONObject item = new JSONObject();
                for (String column : allNames) {
                    String value = cursor.getString(cursor.getColumnIndex(column));
                    try {
                        item.put(column, value);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d("VALUE", "Column : " + column + " Value : " + value);
                }
                datasJson.put(item);
            } while (cursor.moveToNext());
        }
        JSONObject datasToSend = new JSONObject();
        try {
            //putting date of today
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
            Date date = new Date();
            String datestr = sdf.format(date);
            datasToSend.put("dateToday",datestr);
            //putting id of phone
            datasToSend.put("id", androidId);
            //putting datas
            datasToSend.put("value", datasJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return datasToSend.toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BLOUBLOUBLOU", "ONCREATE" + name_activity);
        mTracker.setScreenName("ONCREATE" + name_activity);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        mSensorManager.registerListener(this, mSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    //cheking and saving/sending to server state of phone.
    //the server will then compute the total time spent in each state
    //TODO send data to server when 3G is here ; otherwise store in database like now
    @Override
    public void onSensorChanged(SensorEvent event) {
        proximitySensorValue = (TextView) findViewById(R.id.proximity_sensor_value);
        proximitySensorValue.setText(String.valueOf(event.values[0]));

        boolean isStandby = !powerManager.isInteractive();
        float nearFarWhereEverYouAre = event.values[0];
        // standby+near = not in use (in the pocket)
        if(isStandby && nearFarWhereEverYouAre == 0) {
            Log.d("STATE", "NOT IN USE (POCKET)");
            feedReaderDbHelper.addData("NIU_POCKET",database);
        }

        // !standby+near = in use (calling)
        if(!isStandby && nearFarWhereEverYouAre == 0) {
            Log.d("STATE", "IN USE (PROBABLY CALLING)");
            feedReaderDbHelper.addData("IU_CALLING",database);
        }

        // standby+far = not in use
        if(isStandby && nearFarWhereEverYouAre !=0) {
            Log.d("STATE", "NOT IN USE");
            feedReaderDbHelper.addData("NIU",database);
        }

        // !standby+far = in use
        if(!isStandby && nearFarWhereEverYouAre !=0) {
            Log.d("STATE", "IN USE");
            feedReaderDbHelper.addData("IU",database);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
