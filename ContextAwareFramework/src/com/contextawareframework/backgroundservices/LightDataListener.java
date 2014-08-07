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
 * @File         LightDataListener
 * @Created:     20.11.2013
 * @author:      Prasenjit
 * Last Changed: 24.07.2014 by Prasenjit
 */
package com.contextawareframework.backgroundservices;


import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Description : To register light sensor. To make it as service, mention the
 * 				 package name inside service tag of your Android manifest file
 * */
public class LightDataListener  extends CAFService{

	/* Android SensorManager object to work with sensors.*/
	private SensorManager mSensorManager;

	/* Local variable to select the type of sensor.*/
	private Sensor mLight;

	/* Local variable to store the context of the calling activity.*/
	private final Context mContext;

	/* Local variable to store the SensorEventListener from the calling / implementing Activity. */
	private SensorEventListener listener;

	/* Tag for debugging the class */
	private static final String TAG = "LightDataListener";

	/* To enable / disable Log messages. */
	private static boolean enableDebugging = CAFConfig.isEnableDebugging();

	/* Class instance variable */
	private static LightDataListener lightDataListenerInstance;

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
	private LightDataListener(Context context)
	{
		mContext = context;
	}

	/**
	 * Description : Method to create an instance of AccelerometerDataListener Class.
	 * @param context Calling Activity context
	 * @return AccelerometerDataListener Class instance
	 */
	public static synchronized LightDataListener getInstance(Context context)
	{
		if (lightDataListenerInstance == null)
			lightDataListenerInstance = new LightDataListener(context);

		return lightDataListenerInstance;
	}

	/**
	 * Method to enable Light Sensor in Android
	 * */
	public void enableLightSensor(SensorEventListener listenerFromActivity)
	{
		listener = listenerFromActivity;
		if(enableDebugging)
			Log.d(TAG,"enableLightSensor method");
		mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
		if(mSensorManager == null)
		{
			if(enableDebugging)
			{
				Log.d(TAG,"Light Sensor not found");
				Toast.makeText(this,"No Light Sensor found! quit-",Toast.LENGTH_SHORT).show();
			}
		}
		else
		{
			if(enableDebugging)
			{
				Log.d(TAG,"Light Sensor Found");
				Toast.makeText(mContext,"Light Sensor found",Toast.LENGTH_LONG).show();
			}
			try{
				mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
				mSensorManager.registerListener(listener, mLight , SensorManager.SENSOR_DELAY_NORMAL);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to disable Light Sensor in Android
	 * @param listenerFromActivity 
	 * */
	public void disableLightSensor(SensorEventListener listenerFromActivity)
	{
		if(mSensorManager != null)
		{
			mSensorManager.unregisterListener(listenerFromActivity);
		}
	}

}
