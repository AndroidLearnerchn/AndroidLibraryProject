/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Notification
 * @Created:    21.07.2014
 * @author:     Divya
 * Last Change: 22.07.2014 by Divya
 ******************************************************************/
package com.contextawareframework.notificationService;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
public class IssueNotification {

	private Context context1;
	public IssueNotification(Context mcontext){
		context1=mcontext;
	}
	public void startAlert(PendingIntent pintent,int icon2,CharSequence tickerText,CharSequence contentTitle,CharSequence contentText)//(View view)
	{ 
		try{
			NotificationCompat.Builder noti=new NotificationCompat.Builder(context1);
			noti.setContentTitle(contentTitle);
			noti.setContentText(contentText);
			noti.setSmallIcon(icon2);
			noti.setTicker(tickerText);
			noti.setSmallIcon(icon2);
			noti.setTicker(tickerText);
			noti.setContentIntent(pintent);
			noti.setAutoCancel(true);
			NotificationManager nmgr=(NotificationManager)context1.getSystemService(Context.NOTIFICATION_SERVICE);
			nmgr.notify(0,noti.build());

		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
