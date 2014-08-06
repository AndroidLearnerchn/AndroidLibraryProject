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
 * @File        ProximityDBHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 */
package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.sensors.positionsensors.Proximity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * This is a database helper class for all CRUD operation on Accelerometer Sensor in Android
 */
public class  ProximityDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID,
			ContextAwareSQLiteHelper.COLUMN_PROXIMITY_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_NEAR, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_FAR};
	/**
	 * Default Constructor
	 */
	public ProximityDbHelper(Context context) {
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
	public Proximity createProximiytRowData(long timestamp,float near, float far){
		ContentValues values = new ContentValues();
		values.put(ContextAwareSQLiteHelper.COLUMN_PROXIMITY_TIMESTAMP, timestamp);
		values.put(ContextAwareSQLiteHelper.COLUMN_PROXIMITY_NEAR,near);
		values.put(ContextAwareSQLiteHelper.COLUMN_PROXIMITY_FAR, far);

		long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_PROXIMITY, null,
				values);
		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_PROXIMITY,
				allColumns, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Proximity newComment = cursorToProximityRow(cursor);
		cursor.close();
		return newComment;
	}

	/**
	 * Method to delete a row from database
	 */
	public void deleteProximityRowData(Proximity proximity) {
		long id = proximity.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(ContextAwareSQLiteHelper.TABLE_PROXIMITY, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID
				+ " = " + id, null);
	}
	/**
	 * Method to list all row of the Proximity table
	 */
	public List<Proximity> getAllComments() {
		List<Proximity> proximityRow = new ArrayList<Proximity>();

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_PROXIMITY,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Proximity proximity = cursorToProximityRow(cursor);
			proximityRow.add(proximity);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return proximityRow;
	}
	/**
	 * Method to intialize a Proximity POJO object
	 */
	private Proximity cursorToProximityRow(Cursor cursor) {
		Proximity proximityRow = new Proximity();
		proximityRow.setTimestamp(cursor.getLong(0));
		proximityRow.setNear(cursor.getFloat(1));
		proximityRow.setFar(cursor.getFloat(2));

		return proximityRow;
	}
} 
