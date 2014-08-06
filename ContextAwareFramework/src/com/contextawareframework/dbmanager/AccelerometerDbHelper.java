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
 * @File        AccelerometerDBHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 */

package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.sensors.motionsensors.Accelerometer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * This is a database helper class for all CRUD operation on Accelerometer Sensor in Android
 */
public class  AccelerometerDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_ACCEL_ID,
			ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_ACCEL_X, ContextAwareSQLiteHelper.COLUMN_ACCEL_Y, ContextAwareSQLiteHelper.COLUMN_ACCEL_Z
	};
	/**
	 * Default Constructor
	 */
	public AccelerometerDbHelper(Context context) {
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

	//prasen
	/**
	 * Method to create insert a row of data into the database
	 */
	public Accelerometer createAccelRowData(long timestamp,Float x, Float y, Float z){
		ContentValues values = new ContentValues();
		values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_TIMESTAMP, timestamp);
		values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_X,x);
		values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_Y, y);
		values.put(ContextAwareSQLiteHelper.COLUMN_ACCEL_Z, z);
		long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_ACCEL, null,
				values);
		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_ACCEL,
				allColumns, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Accelerometer newRow = cursorToAccelRow(cursor);
		cursor.close();
		return newRow;
	}

	/**
	 * Method to delete a row from database.
	 */
	/*public void deleteAccelRowData(Accelerometer accel) {
		long id = accel.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(ContextAwareSQLiteHelper.TABLE_ACCEL, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID+ " = " + id, null);
	}*/
	/**
	 * Method to list all row of the Accelerometer table
	 */
	public List<Accelerometer> getAllRows() {
		List<Accelerometer> accelRows = new ArrayList<Accelerometer>();

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_ACCEL,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Accelerometer accel = cursorToAccelRow(cursor);
			accelRows.add(accel);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return accelRows;
	}
	/**
	 * Method to intialize a Accelerometer POJO object
	 */
	private Accelerometer cursorToAccelRow(Cursor cursor) {
		Accelerometer accelRow = new Accelerometer();
		accelRow.setTimestamp(cursor.getLong(0));
		accelRow.setX(cursor.getFloat(1));
		accelRow.setY(cursor.getFloat(2));
		accelRow.setZ(cursor.getFloat(3));
		return accelRow;
	}
} 
