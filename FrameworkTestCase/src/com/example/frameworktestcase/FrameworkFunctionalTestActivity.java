package com.example.frameworktestcase;

import com.contextawareframework.contextawarefunctions.ContextAwareFunction;
import com.contextawareframework.controller.SensorController1;
import com.contextawareframework.dbmanager.AccelerometerDbHelper;
import com.contextawareframework.dbmanager.ContextAwareSQLiteHelper;
import com.contextawareframework.dbmanager.LightDbHelper;
import com.contextawareframework.dbmanager.ProximityDbHelper;
import com.contextawareframework.exceptions.AccelerometerSensorException;
import com.contextawareframework.exceptions.LightSensorException;
import com.contextawareframework.exceptions.ProximitySensorException;
import com.contextawareframework.globalvariable.CAFConfig;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class FrameworkFunctionalTestActivity extends Activity {
	AccelerometerDbHelper  accelDbHelper;
	LightDbHelper lightDbHelper;
	ProximityDbHelper proximityDbHelper;
	long timestamp;
	ContextAwareSQLiteHelper dbHelper;

	private CheckBox chkAccel, chkProximity, chkLight, chkGPS;
	SensorController1 controller;
	ContextAwareFunction caFunction;
	SensorEventListener accelSensorListener, proximitySensorListener, lightSensorListener;
	private static final String TAG = "FrameworkFunctionalityTestCase";
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_framework_functional_test);
		chkAccel = (CheckBox) findViewById(R.id.chkBoxAccelerometer);
		chkProximity = (CheckBox) findViewById(R.id.chkBoxProximity);
		chkLight = (CheckBox) findViewById(R.id.chkBoxLight);
		controller = new SensorController1(this);
		CAFConfig.setTableAccelerometer(true);
		CAFConfig.setTableProximity(true);
		CAFConfig.setTableLight(true);
		dbHelper=  new ContextAwareSQLiteHelper(this);

		// Using Singleton Pattern for creating the DbHelper Object
		accelDbHelper =   AccelerometerDbHelper.getInstance(this);
		
		lightDbHelper =  LightDbHelper.getInstance(this);
		proximityDbHelper = ProximityDbHelper.getInstance(this);

		accelDbHelper.open();
		proximityDbHelper.open();
		lightDbHelper.open();

		// Proximity SensorEventListener
		proximitySensorListener  = new  SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Log.d(TAG,"proximity");
				proximityDbHelper.createProximiytRowData(timestamp, event.values[0], event.values[1]);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub

			}
		};

		// Accelerometer SensorEventListener
		accelSensorListener  = new  SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Log.d(TAG,"Accelerometer");	
				timestamp = System.currentTimeMillis();
				accelDbHelper.createAccelRowData(timestamp, event.values[0], event.values[1], event.values[2]);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {

			}
		};

		// Light SensorEventListener
		lightSensorListener  = new  SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent event) {
				Log.d(TAG,"light");
				lightDbHelper.createLightRowData(timestamp, event.values[0]);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {

			}
		};

		chkProximity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkProximity.isChecked())
				{ Log.d(TAG,"Test proximity");

				try
				{
					if(controller==null){
						Log.d("Debug", "Controller is null");
					}
					else
					{
						CAFConfig.setSensorProximity(true);
						Log.d("Debug", " Registering  proximity sensor");
						controller.registerProximityService(proximitySensorListener,SensorController1.NORMAL);

					}
				} 
				catch (ProximitySensorException e) 
				{
					e.printStackTrace();
				}	
				}
				else
				{

					Log.d(TAG, " Un-Registering  proximity sensor");
					try{
						if(proximitySensorListener!=null)
						{
							controller.unregisterProximityService(proximitySensorListener);
							CAFConfig.setSensorProximity(false);
						}
					}
					catch(ProximitySensorException e)
					{
						e.printStackTrace();
					}

				}

			}
		});
		chkLight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkLight.isChecked())
				{
					Log.d(TAG,"Test light");
					try
					{	
						CAFConfig.setSensorLight(true);
						controller.registerLightService(lightSensorListener,SensorController1.NORMAL);
					} 
					catch (LightSensorException e) 
					{
						e.printStackTrace();
					}
				}
				else
				{

					Log.d(TAG, " Un-Registering  Light sensor");
					try{
						if(lightSensorListener!=null)
						{
							controller.unregisterLightService(lightSensorListener);
							CAFConfig.setSensorLight(false);
						}
					}
					catch(LightSensorException e)
					{
						e.printStackTrace();
					}

				}

			}
		});
		chkAccel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(chkAccel.isChecked())
				{	Log.d(TAG,"Test Accelerometer");
				try
				{
					CAFConfig.setSensorAccelerometer(true);
					controller.registerAccelerometerService(accelSensorListener,SensorController1.NORMAL);
				} 
				catch (AccelerometerSensorException e) 
				{
					e.printStackTrace();
				}
				}
				else
				{

					Log.d(TAG, " Un-Registering  Accelerometer sensor");
					try{
						if(accelSensorListener!=null)
						{
							
							controller.unregisterAccelerometerService(accelSensorListener);
							CAFConfig.setSensorAccelerometer(false);
						}
					}
					catch(AccelerometerSensorException e)
					{
						e.printStackTrace();
					}

				}

			}
		});

	}
	@Override
	protected void onResume()
	{
		super.onResume();

	}
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		try{
			if(controller!=null)
			{
				if(accelSensorListener!=null)
					controller.unregisterAccelerometerService(accelSensorListener);
				if(proximitySensorListener!=null)
					controller.unregisterProximityService(proximitySensorListener);
				if(lightSensorListener!=null)
					controller.unregisterLightService(lightSensorListener);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
