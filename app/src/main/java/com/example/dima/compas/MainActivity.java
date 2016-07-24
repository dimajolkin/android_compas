package com.example.dima.compas;

import android.content.pm.ActivityInfo;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected  Compass compass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        compass = new Compass((SensorManager) getSystemService(SENSOR_SERVICE));
        compass.setImage((ImageView)findViewById(R.id.imageViewCompass));
        compass.setText((TextView)findViewById(R.id.tvHeading));
        compass.onSensorChanged(new Runnable() {
            @Override
            public void run() {
                Log.d("Main", String.valueOf(compass.getAngle()));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        compass.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        compass.onResume();
    }
}
