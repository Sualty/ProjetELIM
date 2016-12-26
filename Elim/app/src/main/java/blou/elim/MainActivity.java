package blou.elim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    private Tracker mTracker;
    private String name_activity="Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        Log.i("BLOUBLOUBLOU", "ONCREATE: " + name_activity);
        mTracker.setScreenName("ONCREATE" + name_activity);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BLOUBLOUBLOU", "ONCREATE" + name_activity);
        mTracker.setScreenName("ONCREATE" + name_activity);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());


    }
}
