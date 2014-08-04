/*
 * Copyright (c) 2013 by CDAC Chennai 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @File        SensorController1
 * @Created:    19.11.2013
 * @author:     Prasenjit
 * Last Change: 20.11.2013 by Prasenjit
 */
 
package com.contextawareframework.controller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;


import com.contextawareframework.backgroundservices.AccelerometerDataListener;
import com.contextawareframework.backgroundservices.GPSTracker;
import com.contextawareframework.backgroundservices.LightDataListener;
import com.contextawareframework.backgroundservices.ProximityDataListener;


import com.contextawareframework.exceptions.AccelerometerSensorException;

import com.contextawareframework.exceptions.GPSSensorException;
import com.contextawareframework.exceptions.LightSensorException;
import com.contextawareframework.exceptions.ProximitySensorException;
import com.contextawareframework.globalvariable.GlobalVariable;


/**
 * This class is the controller part. User can register / unregister the sensor 
 * listener using the specific methods. To use this class, create an object of
 * the class, pass the localcontext, assign the specific sensor global variable 
 * true, call the method written here
 */
public class SensorController1 {

	public Context SensorControllerclasscontext;
	private SensorManager sensorManager;
	private GPSTracker gps;
	private AccelerometerDataListener accel;
	private ProximityDataListener proximity;
	private LightDataListener light;
	private SensorEventListener accelListener, proximityListener, lightListener;
	public SensorController1(Context context)
	{
		SensorControllerclasscontext = context;
	}
	/**
	 * To register the Accelerometer Service 
	 */
	public final void registerAccelerometerService(SensorEventListener listenerfromMainApp) throws AccelerometerSensorException // 1st Sensor
	{
		accelListener = listenerfromMainApp;
		if(GlobalVariable.isSENSOR_ACCELEROMETER())
		{
			// Create an object of specific service class to  
			accel = AccelerometerDataListener.getInstance(SensorControllerclasscontext);
			try{
				Log.d("Debug","inside registerAccelerometerListner");
				accel.enableAccelerometerListener(accelListener, SensorManager.SENSOR_DELAY_NORMAL);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Else part
			accel.disableAccelerometerListener(accelListener);

		}
	}
	/**
	 * To register the Proximity Service
	 */
	public final void registerProximityService(SensorEventListener listenerfromMainApp) throws ProximitySensorException
	{
		proximityListener = listenerfromMainApp;
		if(GlobalVariable.isSENSOR_PROXIMITY())
		{
			// Create an object of specific service class to  
			proximity = ProximityDataListener.getInstance(SensorControllerclasscontext);
			try{
				Log.d("Debug","inside registerProximityListener");
				proximity.enableProximitySensor(proximityListener);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Else part
			Log.d("Debug","Sensor may not be available");
			proximity.disableProximitySensor(proximityListener);
		}
	}

	/**
	 * To register the Light Service
	 */
	public final void registerLightService(SensorEventListener listenerfromMainApp) throws LightSensorException
	{	
		lightListener = listenerfromMainApp;
		if(GlobalVariable.isSENSOR_LIGHT())
		{
			// Create an object of specific service class to  
			light = LightDataListener.getInstance(SensorControllerclasscontext);
			try{
				Log.d("Debug","inside registerProximityListener");
				light.enableLightSensor(lightListener);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			//Else part
			Log.d("Debug","Sensor may not be available");
			light.disableLightSensor(lightListener);

		}
	}

	/**
	 * To un-register the Accelerometer 
	 */
	public final void unregisterAccelerometerService(SensorEventListener listenerfromMainApp) throws AccelerometerSensorException
	{
		//sensorManager.unregisterListener(lightSensorEventListener); // Change the Listener
		accel.disableAccelerometerListener(listenerfromMainApp);
		GlobalVariable.setSENSOR_ACCELEROMETER(false);
		Log.d("Debug","Unregister Accelerometer Sensor");
	}
	/**
	 * To un-register the Proximity Service
	 */
	public final void unregisterProximityService(SensorEventListener listenerfromMainApp) throws ProximitySensorException
	{
		proximity.disableProximitySensor(listenerfromMainApp);
		GlobalVariable.setSENSOR_PROXIMITY(false);
		Log.d("Debug","Unregister Proximity Sensor");
	}
	/**
	 * To un-register the Light sensor Service
	 */
	public final void unregisterLightService(SensorEventListener listenerfromMainApp) throws LightSensorException
	{
		light.disableLightSensor(listenerfromMainApp);
		GlobalVariable.setSENSOR_LIGHT(false);
		Log.d("Debug","Unregister Light Sensor");
	}
	/**
	 * To un-register the Battery Service
	 */
	public final void unregisterBatteryService() 
	{
		
	}
	/**
	 * To un-register the Location Service
	 */
	public final void unregisterLocationService() throws GPSSensorException
	{
		//gps.stopUsingGPS(); // Change the Listener 
		GlobalVariable.setSENSOR_LOCATION(false);
		
		Log.d("Debug","Unregister Location Service");
	}
}
