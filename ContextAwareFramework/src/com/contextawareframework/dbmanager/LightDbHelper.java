/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        AccelerometerDBHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 28.01.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.sensors.environmentsensors.Light;
import com.contextawareframework.sensors.motionsensors.Accelerometer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/*******************************************************************************************
 * This is a database helper class for all CRUD operation on Light Sensor in Android
 *******************************************************************************************/
public class  LightDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_LIGHT_ID,
			ContextAwareSQLiteHelper.COLUMN_LIGHT_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_LIGHT_CUR_READING};
	/*****************************************************************************
	 * Default Constructor
	 *****************************************************************************/
	public LightDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}
	/*****************************************************************************
	 * Method to open the database for writing
	 *****************************************************************************/
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	/*****************************************************************************
	 * Method to close the database connection
	 *****************************************************************************/
	public void close() {
		dbHelper.close();
	}
	/*****************************************************************************
	 * Method to create insert a row of data into the database
	 *****************************************************************************/
	public Light createComment(long timestamp,Float light_cur_read){
		ContentValues values = new ContentValues();
		values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, timestamp);
		values.put(ContextAwareSQLiteHelper.COLUMN_LIGHT_CUR_READING, light_cur_read);

		long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_LIGHT, null,
				values);
		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LIGHT,
				allColumns, ContextAwareSQLiteHelper.COLUMN_LIGHT_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Light newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
	}
	/*****************************************************************************
	 * Method to delete a row from database
	 *****************************************************************************/
	public void deleteComment(Light light_cur_read) {
		long id = light_cur_read.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(ContextAwareSQLiteHelper.TABLE_LIGHT, ContextAwareSQLiteHelper.COLUMN_LIGHT_ID
				+ " = " + id, null);
	}
	/*****************************************************************************
	 * Method to list all row of the Light table
	 *****************************************************************************/
	public List<Light> getAllComments() {
		List<Light> comments = new ArrayList<Light>();

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LIGHT,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Light light_cur_read = cursorToComment(cursor);
			comments.add(light_cur_read);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return comments;
	}
	/*****************************************************************************
	 * Method to intialize a Light POJO object
	 *****************************************************************************/
	private Light cursorToComment(Cursor cursor) {
		Light light_cur_read = new Light();
		light_cur_read.setTimestamp(cursor.getLong(0));
		light_cur_read.setCurrentReading(cursor.getFloat(1));

		return light_cur_read;
	}
} 
