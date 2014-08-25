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
 * Last Change: 12.08.2014 by Prasenjit
 */

package com.contextawareframework.controller;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.contextawareframework.backgroundservices.AccelerometerDataListener;
import com.contextawareframework.backgroundservices.GPSTracker;
import com.contextawareframework.backgroundservices.LightDataListener;
import com.contextawareframework.backgroundservices.ProximityDataListener;
import com.contextawareframework.exceptions.AccelerometerSensorException;
import com.contextawareframework.exceptions.GPSSensorException;
import com.contextawareframework.exceptions.LightSensorException;
import com.contextawareframework.exceptions.ProximitySensorException;
import com.contextawareframework.globalvariable.CAFConfig;


/**
 * Register / unregister the sensor listener using the specific methods. To use 
 * this class, create an object of the class, pass the localcontext, assign the 
 * specific sensor global variable true, call the method written here
 * 
 * Sample Code : 
 * ---------------------------------------------------------------------------------
 * SensorController1 controller = SensorController1.getInstance(getApplicationContext);
 * 
 * CAFConfig.setSensor[Name of Sensor](true);
 * 																			Delay
 * controller.register[SensorName]Service(sensorListener,SensorController1.NORMAL);
 * ----------------------------------------------------------------------------------
 */
public class SensorController {

	private Context contextFromActivity;
	
	/* GPSTracker Class reference variable */
	private GPSTracker gps;
	
	/* AccelerometerDataListener Class reference variable */
	private AccelerometerDataListener accel;
	
	/* ProximityDataListener Class reference variable */
	private ProximityDataListener proximity;
	
	/* LightDataListerner Class reference variable*/
	private LightDataListener light;
	
	/* SensorEventListener Class reference variable*/
	private SensorEventListener accelListener, proximityListener, lightListener;
	
	/* Tag for debugging information*/
	private static final String TAG = "SENSORCONTROLLER1";


	/**
	 * Set sensor delay to SENSOR_DELAY_FASTEST
	 */
	public static final int FASTEST = SensorManager.SENSOR_DELAY_FASTEST;

	/**
	 * Set sensor delay to SENSOR_DELAY_GAME
	 */
	public static final int GAME = SensorManager.SENSOR_DELAY_GAME;

	/**
	 * Set sensor delay to SENSOR_DELAY_NORMAL
	 */
	public static final int NORMAL = SensorManager.SENSOR_DELAY_NORMAL;

	/**
	 * Set sensor delay to SENSOR_DELAY_UI
	 */
	public static final int UI = SensorManager.SENSOR_DELAY_UI;

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging(); 

	/* Class reference variable */
	private static SensorController controller;

	/**
	 * Method to enable debugging
	 * @param boolean
	 */
	public void setEnableDebugging(boolean value)
	{
		enableDebugging = value;
	}

	/**
	 * Method to get the present value of enableDebugging
	 * @return boolean
	 */
	public boolean getEnableDebugging()
	{
		return enableDebugging;
	}

	/**
	 * Description : Private constructor. Singleton Pattern to create the class object
	 * @param context Calling Activity context
	 */
	private SensorController(Context context)
	{
		contextFromActivity = context;
	}

	/**
	 * Description : Method to create an instance of AccelerometerDataListener Class.
	 * @param context Calling Activity context
	 * @return AccelerometerDataListener Class instance
	 */
	public static synchronized SensorController getInstance(Context context)
	{
		if (controller == null)
			controller = new SensorController(context);

		return controller;
	}

	/**
	 * To register the Accelerometer Service 
	 */
	public final void registerAccelerometerService(SensorEventListener listenerfromMainApp, int sampleRate) throws AccelerometerSensorException // 1st Sensor
	{
		accelListener = listenerfromMainApp;

		// Create an object of specific service class to  
		accel = AccelerometerDataListener.getInstance(contextFromActivity);

		if(CAFConfig.isSensorAccelerometer())
		{
			try
			{	
				if(enableDebugging)
					Log.d(TAG,"inside registerAccelerometerListner");
				accel.enableAccelerometerListener(accelListener, sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{			
			if(enableDebugging)
				Log.d(TAG,"SENSOR_ACCELEROMETER is false");
			accel.disableAccelerometerListener(accelListener);

		}
	}
	/**
	 * To register the Proximity Service
	 */
	public final void registerProximityService(SensorEventListener listenerfromMainApp, int sampleRate) throws ProximitySensorException
	{
		proximityListener = listenerfromMainApp;

		// Create an object of specific service class to  
		proximity = ProximityDataListener.getInstance(contextFromActivity);

		if(CAFConfig.isSensorProximity())
		{						
			try
			{
				if(enableDebugging)
					Log.d(TAG,"inside registerProximityListener");
				proximity.enableProximitySensor(proximityListener, sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			if(enableDebugging)
				Log.d(TAG,"SENSOR_PROXIMITY is false");
			proximity.disableProximitySensor(proximityListener);
		}
	}

	/**
	 * To register the Light Service
	 */
	public final void registerLightService(SensorEventListener listenerfromMainApp, int sampleRate) throws LightSensorException
	{	
		lightListener = listenerfromMainApp;
		
		// Create an object of specific service class to  
		light = LightDataListener.getInstance(contextFromActivity);
		if(CAFConfig.isSensorLight())
		{

			try
			{
				if(enableDebugging)
					Log.d(TAG,"inside registerProximityListener");
				if(lightListener!=null)
					light.enableLightSensor(lightListener, sampleRate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			if(enableDebugging)
				Log.d(TAG,"SENSOR_LIGHT is false");
			light.disableLightSensor(lightListener);

		}
	}

	/**
	 * To un-register the Accelerometer 
	 */
	public final void unregisterAccelerometerService(SensorEventListener listenerfromMainApp) throws AccelerometerSensorException
	{
		//sensorManager.unregisterListener(lightSensorEventListener); // Change the Listener
		if(listenerfromMainApp!=null)
		{
			accel.disableAccelerometerListener(listenerfromMainApp);
			CAFConfig.setSensorAccelerometer(false);
			if(enableDebugging)
				Log.d(TAG,"Unregister Accelerometer Sensor");
		}
		else
		{
			Log.d(TAG,"listenerfromMainApp is null");
		}

	}
	/**
	 * To un-register the Proximity Service
	 */
	public final void unregisterProximityService(SensorEventListener listenerfromMainApp) throws ProximitySensorException
	{
		if(listenerfromMainApp!=null)
		{
			proximity.disableProximitySensor(listenerfromMainApp);
			CAFConfig.setSensorProximity(false);
			if(enableDebugging)
				Log.d(TAG,"Unregister Proximity Sensor");
		}
		else
		{
			Log.d(TAG,"listenerfromMainApp is null");
		}
	}
	/**
	 * To un-register the Light sensor Service
	 */
	public final void unregisterLightService(SensorEventListener listenerfromMainApp) throws LightSensorException
	{
		if(listenerfromMainApp!=null)
		{
			light.disableLightSensor(listenerfromMainApp);
			CAFConfig.setSensorLight(false);
			if(enableDebugging)
				Log.d(TAG,"Unregister Light Sensor");
		}
		else
		{
			Log.d(TAG,"listenerfromMainApp is null");
		}
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

		CAFConfig.setSensorLocation(false);
		if(enableDebugging)
			Log.d(TAG,"Unregister Location Service");
	}
}
