package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private SensorManager mSensormanager;
    private TextView sensor_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensormanager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sesnsorList=mSensormanager.getSensorList(Sensor.TYPE_ALL);
        sensor_list=findViewById(R.id.sensor_list);
        StringBuilder sensortext=new StringBuilder();


        for(Sensor currenSensor:sesnsorList){
            sensortext.append(currenSensor.getName()).append(System.getProperty("line.separator"));

        }

        sensor_list.setText(""+sensortext);
    }

    public void navigasi(View view) {

        Intent intent=new Intent(MainActivity.this,Second.class);
        startActivity(intent);
    }
}