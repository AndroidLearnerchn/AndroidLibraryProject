/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Notification
 * @Created:    23.07.2014
 * @author:     Divya
 * Last Change: 24.07.2014 by Divya
 ******************************************************************/

package com.contextawareframework.os;

import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;

public class CAFPowerManager {
	PowerManager.WakeLock wakelock;
	Context context1;
public CAFPowerManager(Context context)
{
	context1=context;
}
public void acquireWakelock(){
	try{
		PowerManager pm=(PowerManager)context1.getSystemService(Context.POWER_SERVICE);
		wakelock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"My wakelock");
		wakelock.acquire();
		Log.d("Hello","inside try");
		Toast acquire=Toast.makeText(context1, "Wake lock on", Toast.LENGTH_SHORT);
		acquire.show();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
public void acquireWakelocktime(long time){
	try{
		PowerManager pm=(PowerManager)context1.getSystemService(Context.POWER_SERVICE);
		wakelock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"My wakelock");
		wakelock.acquire(time);
		Log.d("Hello","inside try");
		Toast acquire=Toast.makeText(context1, "Wake lock on", Toast.LENGTH_SHORT);
		acquire.show();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void releaseWakeLock(){
	try{
		wakelock.release();
		Toast release= Toast.makeText(context1, "Wake Lock off",Toast.LENGTH_SHORT);
		release.show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }

 
}
