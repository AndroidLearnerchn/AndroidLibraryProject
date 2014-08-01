/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        UserInfoDbHelper
 * @Created:    06.06.2014
 * @author:     Prasenjit
 * Last Change: 06.06.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.dbmanager;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.contextawareframework.os.UserInfo;

/*******************************************************************************************
 * This is a database helper class for all CRUD operation on User information.
 *******************************************************************************************/
public class  UserInfoDbHelper{

	// Database fields
	private SQLiteDatabase database;
	private ContextAwareSQLiteHelper dbHelper;
	private String[] allColumns = { ContextAwareSQLiteHelper.COLUMN_USER_EMAIL,
			ContextAwareSQLiteHelper.COLUMN_USER_ID, ContextAwareSQLiteHelper.COLUMN_DEV_EMAIL, ContextAwareSQLiteHelper.COLUMN_DEVICE_ID, ContextAwareSQLiteHelper.COLUMN_APP_ID
	};
	/*****************************************************************************
	 * Default Constructor
	 *****************************************************************************/
	public UserInfoDbHelper(Context context) {
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

	//prasen
	/*****************************************************************************
	 * Method to create insert a row of data into the database
	 *****************************************************************************/
	public UserInfo createComment(String userEmail,String userId, String devEmail, String deviceId,String appId){
		ContentValues values = new ContentValues();
		values.put(ContextAwareSQLiteHelper.COLUMN_USER_EMAIL, userEmail);
		values.put(ContextAwareSQLiteHelper.COLUMN_USER_ID,userId);
		values.put(ContextAwareSQLiteHelper.COLUMN_DEV_EMAIL, devEmail);
		values.put(ContextAwareSQLiteHelper.COLUMN_DEVICE_ID, deviceId);
		values.put(ContextAwareSQLiteHelper.COLUMN_APP_ID, appId);
		values.put(ContextAwareSQLiteHelper.COLUMN_USER_AUTH_STATUS, "false");
		long insertId = database.insert(ContextAwareSQLiteHelper.TABLE_USERINFO, null,
				values);
		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_USERINFO,
				allColumns, ContextAwareSQLiteHelper.COLUMN_ACCEL_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		UserInfo newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
	}
	
	/*****************************************************************************
	 * Method to delete a row from database // Presently it will not work as no check
	 * condition is provided for deleting the row.
	 *****************************************************************************/
	public void deleteComment(UserInfo accel) {
		String id = accel.getUserId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(ContextAwareSQLiteHelper.TABLE_USERINFO, ContextAwareSQLiteHelper.COLUMN_USER_ID
				+ " = " + id, null);
	}
	/*****************************************************************************
	 * Method to list all row of the UserInfo table
	 *****************************************************************************/
	public List<UserInfo> getAllComments() {
		List<UserInfo> comments = new ArrayList<UserInfo>();

		Cursor cursor = database.query(ContextAwareSQLiteHelper.TABLE_USERINFO,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			UserInfo userinfo = cursorToComment(cursor);
			comments.add(userinfo);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return comments;
	}
	/*****************************************************************************
	 * Method to intialize a UserInfo POJO object
	 *****************************************************************************/
	private UserInfo cursorToComment(Cursor cursor) {
		UserInfo userinfo = new UserInfo();
		userinfo.setUserEmailId(cursor.getString(0));
		userinfo.setDeveloperEmail(cursor.getString(1));
		userinfo.setDeviceId(cursor.getString(2));
		userinfo.setUserId(cursor.getString(3));
		userinfo.setAppId(cursor.getString(4));
		userinfo.setAuthenticatedUser(false);
		return userinfo;
	}
} 
