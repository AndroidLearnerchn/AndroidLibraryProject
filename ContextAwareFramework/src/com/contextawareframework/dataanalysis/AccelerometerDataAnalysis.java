/*
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        AccelerometerDataAnalysis
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 */
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
 */
package com.contextawareframework.dataanalysis;
/*******************************************************************************************
 * This class help the user to select either low pass or high pass filter from the Accelerometer
 * Sensor in Android. It returns the float array with first three values as low pass filter
 * and the next three value as high pass filter.
 *******************************************************************************************/
import com.contextawareframework.contextawarefunctions.ContextAwareFunction;
import com.contextawareframework.globalvariable.GlobalVariable;

import android.content.Context;
import android.util.Log;

public class AccelerometerDataAnalysis {

	Context localContext;
/*************************************************************************************
 * Default Constructor
 *************************************************************************************/
	public AccelerometerDataAnalysis(Context contextFromMainApp)
	{
		localContext = contextFromMainApp;
	}
	
/*************************************************************************************
 * Method to perform low pass filter and high pass filter on Accelerometer data.
 *************************************************************************************/
	public float[] AccelDataAnalysis(float x,float y, float z)
	{	
		float [] values = {0,0,0,0,0,0} ;
		try{
			//ContextAwareFunction caf = new ContextAwareFunction(localContext);
			// alpha is calculated as t / (t + dT)
	        // with t, the low-pass filter's time-constant
	        // and dT, the event delivery rate

			final float alpha = (float) 0.75;
			
			float gravity[]={0,0,0};

			// Isolate the force of gravity with the low-pass filter.
			gravity[0] = alpha * gravity[0] + (1 - alpha) * x;
			gravity[1] = alpha * gravity[1] + (1 - alpha) * y;
			gravity[2] = alpha * gravity[2] + (1 - alpha) * z;
			
			// Assigning values that can be used in Application level directly for any additional feature
			values[0] = gravity[0];
			values[1] = gravity[1];
			values[2] = gravity[2];
			
			// Remove the gravity contribution with the high-pass filter.
			
			float linear_acceleration[]= {0,0,0};
			
			// Assigning values that can be used in Application level directly for any additional feature
			linear_acceleration[0] = x - gravity[0];
			linear_acceleration[1] = y - gravity[1];
			linear_acceleration[2] = z - gravity[2];
			
			values[3] = linear_acceleration[0];
			values[4] = linear_acceleration[1];
			values[5] = linear_acceleration[2];
			//Log.d("Debug","X coordinate value = " + event.values[0]);

			// Using high pass filter
			if(GlobalVariable.SENSOR_ACCELEROMETER_HIGHPASS == true)
			{
//				if(linear_acceleration[0] > 10)
//				{
//					//addListenerOnRadioButton();
//					Log.d("Debug","X coordinate value more = " + linear_acceleration[0]);
//					caf.volumeDecrease();
//				}
//				if(linear_acceleration[0] < -10)
//				{
//					Log.d("Debug","X coordinate value less = " + linear_acceleration[0]);
//					caf.volumeIncrease();
//				}
			}
			// Using Low pass filter
			if(GlobalVariable.SENSOR_ACCELEROMETER_LOWPASS == true)
			{
//				if(gravity[0] > 10)
//				{
//					//addListenerOnRadioButton();
//					Log.d("Debug","X coordinate value more = " + gravity[0]);
//					caf.volumeDecrease();
//				}
//				if(gravity[0] < -10)
//				{
//					Log.d("Debug","X coordinate value less = " + gravity[0]);
//					caf.volumeIncrease();
//				}
			}
			//Log.d("Debug","Z coordinate value = " + event.values[2]);


			//addListenerOnRadioButton(); // Increase or decrease method call based on radio button selection
			//Log.d("Debug","Inside Main, After Sensor Event");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  values;
	}
	
}
