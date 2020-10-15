package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Second extends AppCompatActivity implements SensorEventListener {


    private SensorManager mSensorManager;
    private Sensor sensor_light;
    private Sensor sensor_proximity;
    private TextView txtlight,txtproximity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mSensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_light=mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensor_proximity=mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        txtlight=findViewById(R.id.txlight);
        txtproximity=findViewById(R.id.txproximity);

        String nosensor=getResources().getString(R.string.no_sensor);


        if(sensor_light==null){
            txtlight.setText(""+nosensor);
        }

        if(sensor_proximity==null){
            txtproximity.setText(""+nosensor);
        }

    }


    @Override
    protected void onStart() {
        super.onStart();

        if(sensor_light!=null){
            mSensorManager.registerListener(this,sensor_light,SensorManager.SENSOR_DELAY_NORMAL);

        }


        if(sensor_proximity!=null){
            mSensorManager.registerListener(this,sensor_proximity,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();

        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensortype= event.sensor.getType();
        float currentvalue=event.values[0];
        switch (sensortype){
            case Sensor.TYPE_LIGHT:
                txtlight.setText(getResources().getString(R.string.label_light,currentvalue));
                break;
            case Sensor.TYPE_PROXIMITY:
                txtproximity.setText(getResources().getString(R.string.label_proxity,currentvalue));
                break;

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}