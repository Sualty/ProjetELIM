package blou.elim;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.sql.SQLData;

public class MainActivity extends Activity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView textView;
    private PowerManager powerManager;

    private Tracker mTracker;
    private String name_activity="Main";

    private SQLiteDatabase database;
    private FeedReaderDbHelper feedReaderDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*example of how to send infos to google analytics*/
        //TODO see how to stock infos when not connected to internet?
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        Log.i("BLOUBLOUBLOU", "ONCREATE: " + name_activity);
        mTracker.setScreenName("ONCREATE" + name_activity);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        //testing how to collect info from proximity sensor
        textView = (TextView)findViewById(R.id.textview_proximity_test);

        /*initializing proximity sensor*/
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        /*initialize power manager for knowing if phone is in standby or not*/
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);

        /*initialize database and feedreaderhelper*/
        feedReaderDbHelper = new FeedReaderDbHelper(this);
        database = feedReaderDbHelper.getWritableDatabase();
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
