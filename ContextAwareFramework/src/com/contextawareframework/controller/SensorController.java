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
 * @File        SensorController
 * @Created:    25.11.2013
 * @author:     Prasenjit
 * Last Change: 26.11.2013 by Prasenjit
 */

package com.contextawareframework.controller;

import com.contextawareframework.globalvariable.CAFConfig;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;
/**
 * This class is the controller part. User can register the sensor listener. 
 * Presently This class is not being used for registering / un-registering the sensors.
 * 
 * @Note : SensorController1 is being used for now.
 */

public class SensorController {
	public Context SensorControllerclasscontext;
	private SensorEventListener listener;
	private SensorManager sensorManager;
	
	// Use this string constant to debug this class
    private static final String TAG = "SensorController";
    
	public SensorController(Context context)
	{
		SensorControllerclasscontext = context;
	}
	/**
	 * Method to register the Proximity Sensor listener. Listener will be implemented on
	 * Main Application level. For storing the data aslo user will mention in the listener
	 */
	public final void registerProximityService(SensorEventListener listenerfromMainApp) 
	{
		listener = listenerfromMainApp;
		if(CAFConfig.isSensorProximity())
		{
			sensorManager = (SensorManager)SensorControllerclasscontext.getSystemService(Context.SENSOR_SERVICE);
	        Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
	        if (proximitySensor == null){
	            Toast.makeText(SensorControllerclasscontext,
	              "No Proximity Sensor! quit-",
	              Toast.LENGTH_LONG).show();
	           }
	        
	        else
	        {
	        	
	            float max =  proximitySensor.getMaximumRange();
	            Toast.makeText(SensorControllerclasscontext,
	  	              "Proximity Sensor found! value = " + max,
	  	              Toast.LENGTH_LONG).show();
	            Log.d("Debug","max value = " + max);
	            
	            sensorManager.registerListener(listener,
	            		proximitySensor,
		                SensorManager.SENSOR_DELAY_NORMAL);//proximitySensorEventListener
	         }
	    }
		else
		{
			//Else part
			
		}
	}

	/**
	 * Method to register the Proximity Sensor listener. Listener will be implemented on
	 * Main Application level. For storing the data aslo user will mention in the listener
	 */
	public final void registerLightService(SensorEventListener listenerfromMainApp) 
	{
		listener = listenerfromMainApp;
		if(CAFConfig.isSensorLight())
		{
			
			sensorManager = (SensorManager)SensorControllerclasscontext.getSystemService(Context.SENSOR_SERVICE);
	        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
	        if (lightSensor == null){
	            Toast.makeText(SensorControllerclasscontext,
	              "No Light Sensor! quit-",
	              Toast.LENGTH_LONG).show();
	           }
	        
	        else
	        {
	        	
	            float max =  lightSensor.getMaximumRange();
	            Toast.makeText(SensorControllerclasscontext,
	  	              "Light Sensor found! value = " + max,
	  	              Toast.LENGTH_LONG).show();
	            Log.d("Debug","max value = " + max);
	            
	            sensorManager.registerListener(listener,
	            		lightSensor,
		                SensorManager.SENSOR_DELAY_NORMAL);//proximitySensorEventListener
	            
	         }
	    }
		else
		{
			//Else part when GLobal vairable fasle
			
		}
	}
	/**
	 * Method to register the Proximity Sensor listener. Listener will be implemented on
	 * Main Application level. For storing the data aslo user will mention in the listener
	 */
	public final void registerAccelerometerService(SensorEventListener listenerfromMainApp) 
	{
		listener = listenerfromMainApp;
		if(CAFConfig.isSensorAccelerometer())
		{
			
			sensorManager = (SensorManager)SensorControllerclasscontext.getSystemService(Context.SENSOR_SERVICE);
	        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	        if (accelerometerSensor == null){
	            Toast.makeText(SensorControllerclasscontext,
	              "No Accelerometer Sensor! quit-",
	              Toast.LENGTH_LONG).show();
	           }
	        
	        else
	        {
	        	
	            float max =  accelerometerSensor.getMaximumRange();
	            Toast.makeText(SensorControllerclasscontext,
	  	              "Accelerometer Sensor found! value = " + max,
	  	              Toast.LENGTH_LONG).show();
	            Log.d("Debug","max value = " + max);
	            
	            sensorManager.registerListener(listener,
	            		accelerometerSensor,
		                SensorManager.SENSOR_DELAY_NORMAL);//proximitySensorEventListener
	         }
	    }
		else
		{
			//Else part
			
		}
	}
	// Here No need of all these function, only one will suffice the requirement as we are passing
	// listener to the unregister method, we just have to write a switch statement to set the global
	// Variable true or false. 
	/*
	 * To Unregister the Light Listener
	 * */
	public final void unregisterLightService(SensorEventListener listenerfromMainApp)
	{
		listener = listenerfromMainApp;
		sensorManager.unregisterListener(listener);
		CAFConfig.setSensorLight(false);
		
	}
	/*
	 * To Unregister the Proximity Listener
	 * */
	public final void unregisterProximityService(SensorEventListener listenerfromMainApp)
	{
		listener = listenerfromMainApp;
		sensorManager.unregisterListener(listener);
		CAFConfig.setSensorProximity(false);
		
	}
	/*
	 * To Unregister the Location Listener
	 * */
	public final void unregisterLocationService(SensorEventListener listenerfromMainApp)
	{
		listener = listenerfromMainApp;
		sensorManager.unregisterListener(listener);
		CAFConfig.setSensorLocation(false);
		
	}
	/*
	 * To Unregister the Accelerometer Listener
	 * */
	public final void unregisterAccelerometerService(SensorEventListener listenerfromMainApp)
	{
		listener = listenerfromMainApp;
		sensorManager.unregisterListener(listener);
		CAFConfig.setSensorAccelerometer(false);
		
	}
	
	
}
