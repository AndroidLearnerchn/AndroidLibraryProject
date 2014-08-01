/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        ProximityDBHelper
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 ******************************************************************/
package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import com.contextawareframework.sensors.positionsensors.Proximity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/*******************************************************************************************
 * This is a database helper class for all CRUD operation on Accelerometer Sensor in Android
 *******************************************************************************************/
public class  ProximityDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID,
			ContextAwareSQLiteHelper.COLUMN_PROXIMITY_TIMESTAMP, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_NEAR, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_FAR};
	/***********************************************************************
	 * Default Constructor
	 ***********************************************************************/
	public ProximityDbHelper(Context context) {
		dbHelper = new ContextAwareSQLiteHelper(context);
	}
	/****************************************************************************
	 * Method to open the database for writing
	 ****************************************************************************/
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
	public Proximity createComment(long timestamp,float near, float far){
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
		Proximity newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
	}

	/*****************************************************************************
	 * Method to delete a row from database
	 *****************************************************************************/
	public void deleteComment(Proximity proximity) {
		long id = proximity.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(ContextAwareSQLiteHelper.TABLE_PROXIMITY, ContextAwareSQLiteHelper.COLUMN_PROXIMITY_ID
				+ " = " + id, null);
	}
	/*****************************************************************************
	 * Method to list all row of the Proximity table
	 *****************************************************************************/
	public List<Proximity> getAllComments() {
		List<Proximity> comments = new ArrayList<Proximity>();

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_PROXIMITY,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Proximity proximity = cursorToComment(cursor);
			comments.add(proximity);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return comments;
	}
	/*****************************************************************************
	 * Method to intialize a Proximity POJO object
	 *****************************************************************************/
	private Proximity cursorToComment(Cursor cursor) {
		Proximity proximity = new Proximity();
		proximity.setTimestamp(cursor.getLong(0));
		proximity.setNear(cursor.getFloat(1));
		proximity.setFar(cursor.getFloat(2));

		return proximity;
	}
} 
