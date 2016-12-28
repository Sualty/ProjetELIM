package blou.elim;

import android.app.Activity;
import android.content.Context;
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

public class MainActivity extends Activity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView textView;
    private PowerManager powerManager;

    private Tracker mTracker;
    private String name_activity="Main";
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

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BLOUBLOUBLOU", "ONCREATE" + name_activity);
        mTracker.setScreenName("ONCREATE" + name_activity);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        mSensorManager.registerListener(this, mSensor,SensorManager.SENSOR_DELAY_NORMAL);


    }

    //checking the state of the phone
    //TODO store data
    @Override
    public void onSensorChanged(SensorEvent event) {
        boolean isStandby = !powerManager.isInteractive();
        float nearFarWhereEverYouAre = event.values[0];
        // standby+near = not in use (in the pocket)
        if(isStandby && nearFarWhereEverYouAre == 0)
            Log.d("STATE","NOT IN USE (POCKET)");

        // !standby+near = in use (calling)
        if(!isStandby && nearFarWhereEverYouAre == 0)
            Log.d("STATE", "IN USE (PROBABLY CALLING)");

        // standby+far = not in use
        if(isStandby && nearFarWhereEverYouAre !=0)
            Log.d("STATE","NOT IN USE");

        // !standby+far = in use
        if(!isStandby && nearFarWhereEverYouAre !=0)
            Log.d("STATE","IN USE");
    }

    //0 : not in use (in the pocket)
    //1 : not in use
    //2 : in use (calling)
    //3 : in use (not calling)
    //format : [DATE]:[STATE]
    //TODOd
    public void stockData(int state) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
