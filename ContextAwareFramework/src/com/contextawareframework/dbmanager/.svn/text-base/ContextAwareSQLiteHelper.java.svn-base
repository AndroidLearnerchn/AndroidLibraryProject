/*
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
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        ContextAwareSQLiteHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 28.01.2014 by Prasenjit
 */
package com.contextawareframework.dbmanager;

import com.contextawareframework.exceptions.SQLiteQueryException;
import com.contextawareframework.globalvariable.GlobalVariable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This is a Database helper class for creating tables for sensors 
 * and context based on details (property field) provided by Sensor 
 * or Context. Add the table name and create statement here to add 
 * new table.
 */
public class ContextAwareSQLiteHelper extends SQLiteOpenHelper {
	
	// Database name for all sensor (context data) data 
	private static final String DATABASE_NAME = "contextAwareFramework.db";
	private static final int DATABASE_VERSION = 1;
	
	//Added 4.8.14 Prasenjit
	private static boolean enableDebugging = false;
	private ContextAwareSQLiteHelper  contextAwareSQLiteHelper;
	private Context mContext;
	
	//------------------------------------Table for Storing user Information-----------------------------------//
	public static final String TABLE_USERINFO = "UserInfo";
	public static final String COLUMN_USER_EMAIL = null;
	public static final String COLUMN_DEV_EMAIL = null;
	public static final String COLUMN_DEVICE_ID = null;
	public static final String COLUMN_APP_ID = null;
	public static final String COLUMN_USER_ID = null; // unique ( appid + useremail )
	public static final String COLUMN_USER_AUTH_STATUS = "false"; // To check if its true then user can query the server
	//---------------------------------------------------------------------------------------------------------//
	
	//-------------------------------------Table for Accelerometer-------------------------------------------------//
	public static final String TABLE_ACCEL = "Accelerometer";
	public static final String COLUMN_ACCEL_ID = "_id";
	public static final String COLUMN_ACCEL_TIMESTAMP = "Time_Stamp";
	
	//Accelerometer Table Column(Properties)
	public static final String COLUMN_ACCEL_X= "x_value";
	public static final String COLUMN_ACCEL_Y= "y_value";
	public static final String COLUMN_ACCEL_Z= "z_value";
	//------------------------------------- Table for Accelerometer Sensor ends here -------------------------------------------------//

	//-------------------------------------Table for Battery-------------------------------------------------//
	// Not in working state, database not been designed for Battery information
	public static final String TABLE_BATTERY = "Battery";
	public static final String COLUMN_BATTERY_ID = "_id";
	public static final String COLUMN_BATTERY_TIMESTAMP = "Time_Stamp";
	
	//Accelerometer Table Column(Properties)
	public static final String COLUMN_BATTERY_X= "x_value";
	public static final String COLUMN_BATTERY_y= "y_value";
	public static final String COLUMN_BATTERY_Z= "z_value";
	//-------------------------------------Table for Battery End here-------------------------------------------------//

	//-------------------------------------Table for Light Sensor-------------------------------------------------//
	
	//LightSensor Table Column(Properties)
	public static final String TABLE_LIGHT = "Light";
	public static final String COLUMN_LIGHT_ID = "_id";
	public static final String COLUMN_LIGHT_TIMESTAMP = "Time_Stamp";
	public static final String COLUMN_LIGHT_CUR_READING= "Currebnt_Reading";
	
	//-------------------------------------Table for Light Sensor ends here-------------------------------------------------//

	//-------------------------------------Table for Proximity Sensor-------------------------------------------------//
	
	//Proximity Table Column(Properties)
	public static final String TABLE_PROXIMITY = "Proximity";
	public static final String COLUMN_PROXIMITY_ID = "_id";
	public static final String COLUMN_PROXIMITY_TIMESTAMP = "Time_Stamp";
	public static final String COLUMN_PROXIMITY_NEAR= "Near";
	public static final String COLUMN_PROXIMITY_FAR= "Far";
	
	//-------------------------------------Table for Proximity Sensor ends here-------------------------------------------------//
	
	//-------------------------------------Table for Location Sensor-------------------------------------------------//

	//Location Table Column(Properties)
	public static final String TABLE_LOCATION = "Location";
	public static final String COLUMN_LOCATION_ID = "_id";
	public static final String COLUMN_LOCATION_TIMESTAMP = "Time_Stamp";
	public static final String COLUMN_LOCATION_LATITUDE= "lat_value";
	public static final String COLUMN_LOCATION_LONGINTUDE= "long_value";
	public static final String COLUMN_LOCATION_PLACE= "place_name";
	public static final String COLUMN_HANGOUT_INFO= "hangout_info";	
	
	// Changed on 4.3.14 Mam Code integration Above code. 
	
	/*public static final String TABLE_LOCATION = "Location";
	public static final String COLUMN_LOCATION_ID = "_id";
	public static final String COLUMN_LOCATION_TIMESTAMP = "Time_Stamp";
	//Accelerometer Table Column(Properties)
	public static final String COLUMN_LOCATION_LATITUDE= "lat_value";
	public static final String COLUMN_LOCATION_LONGINTUDE= "long_value";
	public static final String COLUMN_LOCATION_PLACE= "z_value"; // To get the place information we may need to use the Geolocation class*/ 
	//-------------------------------------Table for Location Sensor-------------------------------------------------//
	

	// Database creation sql statement
	// UserInfo Table Added 06.06.14
	private static final String CREATE_TABLE_USERINFO = "create table "
			+ TABLE_USERINFO + "(" + COLUMN_USER_EMAIL
			+ " text not null, " + COLUMN_USER_ID
			+ " text primary key," + COLUMN_DEV_EMAIL + " text not null, "   +  COLUMN_DEVICE_ID  + " text not null, " +  COLUMN_APP_ID + " text not null " + COLUMN_USER_AUTH_STATUS + " text not null " + " ); ";
	
	
	// Accelerometer Table create statement
	private static final String CREATE_TABLE_ACCELEROMETER = "create table "
			+ TABLE_ACCEL + "(" + COLUMN_ACCEL_ID
			+ " integer primary key autoincrement, " + COLUMN_ACCEL_TIMESTAMP
			+ " text not null," + COLUMN_ACCEL_X + " integer, "   +  COLUMN_ACCEL_Y  + " integer, " +  COLUMN_ACCEL_Z + " integer " + " ); ";
	
	
	// Battery Table create statement. This is sample table, should not be used as column names are not
	// defined as per actual entity attribute(s).
	// For Battery there are lots of field, So which fields have to be stored is not yet fixed.
	private static final String CREATE_TABLE_BATTERY = "create table "
			+ TABLE_BATTERY + "(" + COLUMN_BATTERY_ID
			+ " integer primary key autoincrement, " + COLUMN_BATTERY_TIMESTAMP
			+ " text not null," + COLUMN_BATTERY_X + " integer, "   +  COLUMN_BATTERY_y  + " integer, " +  COLUMN_BATTERY_Z + " integer " + " ); ";
	
	// Light Table create statement
	private static final String CREATE_TABLE_LIGHT = "create table "
			+ TABLE_LIGHT + "(" + COLUMN_LIGHT_ID
			+ " integer primary key autoincrement, " + COLUMN_LIGHT_TIMESTAMP
			+ " text not null," + COLUMN_LIGHT_CUR_READING + " integer" + " ); ";
	
	// Proximity Table create statement
	private static final String CREATE_TABLE_PROXIMITY = "create table "
			+ TABLE_PROXIMITY + "(" + COLUMN_PROXIMITY_ID
			+ " integer primary key autoincrement, " + COLUMN_PROXIMITY_TIMESTAMP
			+ " text not null," + COLUMN_PROXIMITY_NEAR + " integer, "   + COLUMN_PROXIMITY_FAR   + " integer " + " ); ";
	
	// Location Table create statement
	//Date modified 3.3 14
	
	private static final String CREATE_TABLE_LOCATION = "create table " + TABLE_LOCATION + "(" + COLUMN_LOCATION_ID + " integer primary key autoincrement, " + COLUMN_LOCATION_TIMESTAMP
			+ " text not null," + COLUMN_LOCATION_LATITUDE + " text not null, " + COLUMN_LOCATION_LONGINTUDE   + " text not null, " + COLUMN_LOCATION_PLACE + " text not null, " + COLUMN_HANGOUT_INFO + " text not null "  +  " ); ";
	
	
	/*private static final String CREATE_TABLE_LOCATION = "create table "
			+ TABLE_LOCATION + "(" + COLUMN_LOCATION_ID
			+ " integer primary key autoincrement, " + COLUMN_LOCATION_TIMESTAMP
			+ " text not null," + COLUMN_LOCATION_LATITUDE + " integer, "   + COLUMN_LOCATION_LONGINTUDE   + " integer " + " ); ";
	*/
	
	public ContextAwareSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database)
	{
		try
		{
			if(GlobalVariable.isSENSOR_ACCELEROMETER_TABLE())
			{
				database.execSQL(CREATE_TABLE_ACCELEROMETER);
			}
			if(GlobalVariable.isSENSOR_BATTERY_TABLE())
			{
				database.execSQL(CREATE_TABLE_BATTERY);
			}
			if(GlobalVariable.isSENSOR_LIGHT_TABLE())
			{
				database.execSQL(CREATE_TABLE_LIGHT);
			}
			if(GlobalVariable.isSENSOR_PROXIMITY_TABLE())
			{	
				database.execSQL(CREATE_TABLE_PROXIMITY);
			}
			if(GlobalVariable.isSENSOR_LOCATION_TABLE())
			{
				database.execSQL(CREATE_TABLE_LOCATION);
			}
			if(GlobalVariable.isSENSOR_USERINFO_TABLE())
			{
				database.execSQL(CREATE_TABLE_USERINFO);
			}
		}
		catch(SQLiteQueryException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(ContextAwareSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		// If database version updated then it will delete all tables with its database and create a new empty one
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCEL);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BATTERY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIGHT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROXIMITY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERINFO);
		onCreate(db);
	}
	
	
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
	
//	private  ContextAwareSQLiteHelper(Context context)
//	{
//		super(context, DATABASE_NAME, null, DATABASE_VERSION);
//	}
	/**
	 * Description : Method to create an instance of AccelerometerDataListener Class.
	 * @param  context Calling Activity context
	 * @return ContextAwareSQLiteHelper Class instance
	 */
	public synchronized ContextAwareSQLiteHelper getInstance(Context context)
	{
		if (contextAwareSQLiteHelper == null)
			contextAwareSQLiteHelper = new ContextAwareSQLiteHelper(context);

		return contextAwareSQLiteHelper;
	}

} 
