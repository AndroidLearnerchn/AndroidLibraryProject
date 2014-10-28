package com.contextawareframework.os;

/*
 * Copyright (c) 2013-14 by CDAC Chennai 
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
 * @File        CAFPowerManager
 * @Created:    23.07.2014
 * @author:     Divya
 * Last Change: 15.10.2014 by Prasenjit
 */



import android.os.PowerManager;
import android.widget.Toast;
import android.content.Context;

/**
 * This class implements PARTIAL_WAKE_LOCK 
 */
public class CAFPowerManager {
	PowerManager.WakeLock wakeLock;
	Context mcontext;
	/**
	 * Method to assign the context of the component
	 * @param context
	 */
	public CAFPowerManager(Context context)
	{
		mcontext=context;
	}

	/**
	 * Method to acquire a wake lock
	 */
	public void acquireWakeLock(){ 
		try
		{
			//pm-Stores the handle to the system-level service POWER_SERVICE
			PowerManager pm=(PowerManager)mcontext.getSystemService(Context.POWER_SERVICE);
			
			//create a new wakelock
			wakeLock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"My wakelock");

			Toast acquire=Toast.makeText(mcontext, "Wake lock on", Toast.LENGTH_SHORT);
			acquire.show();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Method to acquire a wakelock with a timeout
	 * @param time
	 */
	public void acquireWakelocktime(long time){
		try{
			//pm-Stores the handle to the system-level service POWER_SERVICE
			PowerManager pm=(PowerManager)mcontext.getSystemService(Context.POWER_SERVICE);
			//create a new Wakelock
			wakeLock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"My wakelock");
			//acquire Wakelock
			wakeLock.acquire(time);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Method to release Wakelock acquired using acquireWakeLock()
	 */
	public void releaseWakeLock(){
		try{
			//releases the wakelock
			wakeLock.release();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}