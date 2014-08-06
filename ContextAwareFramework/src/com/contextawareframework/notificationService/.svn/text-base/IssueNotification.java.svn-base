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
/**********************************************************************************
 *This class will issue notification.The developer can set Title,icon,Ticker text,
 *Content Text,Content Title by just passing the value to the startAlert() 
***********************************************************************************/
public class IssueNotification {

	private Context context;
	public IssueNotification(Context mcontext){
		context=mcontext;//Passes the context of the application component 
	}
/**
 * Method to issue notification,the developer just requires to pass the PendingIntent object,Resource id 
 * to be used as icon in the status bar,Text to scroll on the status bar,Text which has to be set as 
 * the first line of text in the platform notification template,Text which has to be set as the second
 * line of text in the platform notification template.
 * @param pintent
 * @param icon2
 * @param tickerText
 * @param contentTitle
 * @param contentText
 */
	public void startAlert(PendingIntent pintent,int icon2,CharSequence tickerText,CharSequence contentTitle,CharSequence contentText)//(View view)
	{ 
		try{
			NotificationCompat.Builder noti=new NotificationCompat.Builder(context);
			//Sets the second line of text in the platform notification template.
			noti.setContentTitle(contentTitle);
			//Sets the first line of text in the platform notification template.
			noti.setContentText(contentText);
			//Sets the icon 
			noti.setSmallIcon(icon2);
			//Sets the text to scroll on the status bar
			noti.setTicker(tickerText);
			//Supply a PendingIntent to be sent when the notification is clicked.
			noti.setContentIntent(pintent);
			//Notification automatically dismissed when user touches it
			noti.setAutoCancel(true);
			//Obtain a handle to Notification Service
			NotificationManager nmgr=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
			//Post notification on the status bar
			nmgr.notify(0,noti.build());

		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
