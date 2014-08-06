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

 * @File        LightDBHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 28.01.2014 by Prasenjit
 */

package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.sensors.environmentsensors.Light;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * This is a database helper class for all CRUD operation on Light Sensor in Android
 */
public class  LightDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_LIGHT_ID,
			ContextAwareSQLiteHelper.COLUMN_LIGHT_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_LIGHT_CUR_READING};
	/**
	 * Default Constructor
	 */
	public LightDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}
	/**
	 * Method to open the database for writing
	 */
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	/**
	 * Method to close the database connection
	 */
	public void close() {
		dbHelper.close();
	}
	/**
	 * Method to create insert a row of data into the database
	 */
	public Light createLightRowData(long timestamp,Float light_cur_read){
		ContentValues values = new ContentValues();
		values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, timestamp);
		values.put(ContextAwareSQLiteHelper.COLUMN_LIGHT_CUR_READING, light_cur_read);

		long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_LIGHT, null,
				values);
		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LIGHT,
				allColumns, ContextAwareSQLiteHelper.COLUMN_LIGHT_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Light newRow = cursorToLightRow(cursor);
		cursor.close();
		return newRow;
	}
	/**
	 * Method to delete a row from database
	 */
	public void deleteLightRowData(Light light) {
		long id = light.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(ContextAwareSQLiteHelper.TABLE_LIGHT, ContextAwareSQLiteHelper.COLUMN_LIGHT_ID
				+ " = " + id, null);
	}
	/**
	 * Method to list all row of the Light table
	 */
	public List<Light> getAllComments() {
		List<Light> lightRowData = new ArrayList<Light>();

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_LIGHT,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Light light = cursorToLightRow(cursor);
			lightRowData.add(light);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return lightRowData;
	}
	/**
	 * Method to intialize a Light POJO object
	 */
	private Light cursorToLightRow(Cursor cursor) {
		Light lightpojo = new Light();
		lightpojo.setTimestamp(cursor.getLong(0));
		lightpojo.setCurrentReading(cursor.getFloat(1));

		return lightpojo;
	}
} 
