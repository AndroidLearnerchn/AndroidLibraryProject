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
 *  
 * @File        GlobalVariable
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 */

package com.contextawareframework.globalvariable;

/**
 * All variable are globally accessible and can have only one state in
 * application. This provides a facility to disable any sensor listener 
 * based on any condition.
 */
public final class GlobalVariable {
	private static  boolean SENSOR_ACCELEROMETER = false;
	private static  boolean SENSOR_PROXIMITY = false;
	private static  boolean SENSOR_LIGHT = false;
	private static  boolean SENSOR_LOCATION = false;
	private static  boolean SENSOR_BATTERY = false;
	private static 	boolean SENSOR_ACCELEROMETER_HIGHPASS = false;
	private static 	boolean SENSOR_ACCELEROMETER_LOWPASS = false;
	private static 	boolean SENSOR_ACCELEROMETER_TABLE = false;
	private static 	boolean SENSOR_PROXIMITY_TABLE = false;
	private static 	boolean SENSOR_LOCATION_TABLE = false;
	private static	boolean SENSOR_LIGHT_TABLE = false;
	private static	boolean SENSOR_BATTERY_TABLE = false;
	private static 	boolean SENSOR_USERINFO_TABLE = false;

	/**
	 * 
	 */
	public static boolean isSENSOR_ACCELEROMETER() {

		return SENSOR_ACCELEROMETER;
	}
	/**
	 * 
	 */
	public static void setSENSOR_ACCELEROMETER(boolean sENSOR_ACCELEROMETER) {
		SENSOR_ACCELEROMETER = sENSOR_ACCELEROMETER;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_PROXIMITY() {
		return SENSOR_PROXIMITY;
	}
	/**
	 * 
	 */
	public static void setSENSOR_PROXIMITY(boolean sENSOR_PROXIMITY) {
		SENSOR_PROXIMITY = sENSOR_PROXIMITY;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_LIGHT() {
		return SENSOR_LIGHT;
	}
	/**
	 * 
	 */
	public static void setSENSOR_LIGHT(boolean sENSOR_LIGHT) {
		SENSOR_LIGHT = sENSOR_LIGHT;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_LOCATION() {
		return SENSOR_LOCATION;
	}
	/**
	 * 
	 */
	public static void setSENSOR_LOCATION(boolean sENSOR_LOCATION) {
		SENSOR_LOCATION = sENSOR_LOCATION;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_BATTERY() {
		return SENSOR_BATTERY;
	}
	/**
	 * 
	 */
	public static void setSENSOR_BATTERY(boolean sENSOR_BATTERY) {
		SENSOR_BATTERY = sENSOR_BATTERY;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_ACCELEROMETER_HIGHPASS() {
		return SENSOR_ACCELEROMETER_HIGHPASS;
	}
	/**
	 * 
	 */
	public static void setSENSOR_ACCELEROMETER_HIGHPASS(
			boolean sENSOR_ACCELEROMETER_HIGHPASS) {
		SENSOR_ACCELEROMETER_HIGHPASS = sENSOR_ACCELEROMETER_HIGHPASS;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_ACCELEROMETER_LOWPASS() {
		return SENSOR_ACCELEROMETER_LOWPASS;
	}
	/**
	 * 
	 */
	public static void setSENSOR_ACCELEROMETER_LOWPASS(
			boolean sENSOR_ACCELEROMETER_LOWPASS) {
		SENSOR_ACCELEROMETER_LOWPASS = sENSOR_ACCELEROMETER_LOWPASS;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_ACCELEROMETER_TABLE() {
		return SENSOR_ACCELEROMETER_TABLE;
	}
	/**
	 * 
	 */
	public static void setSENSOR_ACCELEROMETER_TABLE(
			boolean sENSOR_ACCELEROMETER_TABLE) {
		SENSOR_ACCELEROMETER_TABLE = sENSOR_ACCELEROMETER_TABLE;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_PROXIMITY_TABLE() {
		return SENSOR_PROXIMITY_TABLE;
	}
	/**
	 * 
	 */
	public static void setSENSOR_PROXIMITY_TABLE(boolean sENSOR_PROXIMITY_TABLE) {
		SENSOR_PROXIMITY_TABLE = sENSOR_PROXIMITY_TABLE;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_LOCATION_TABLE() {
		return SENSOR_LOCATION_TABLE;
	}
	/**
	 * 
	 */
	public static void setSENSOR_LOCATION_TABLE(boolean sENSOR_LOCATION_TABLE) {
		SENSOR_LOCATION_TABLE = sENSOR_LOCATION_TABLE;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_LIGHT_TABLE() {
		return SENSOR_LIGHT_TABLE;
	}
	/**
	 * 
	 */
	public static void setSENSOR_LIGHT_TABLE(boolean sENSOR_LIGHT_TABLE) {
		SENSOR_LIGHT_TABLE = sENSOR_LIGHT_TABLE;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_BATTERY_TABLE() {
		return SENSOR_BATTERY_TABLE;
	}
	/**
	 * 
	 */
	public static void setSENSOR_BATTERY_TABLE(boolean sENSOR_BATTERY_TABLE) {
		SENSOR_BATTERY_TABLE = sENSOR_BATTERY_TABLE;
	}
	/**
	 * 
	 */
	public static boolean isSENSOR_USERINFO_TABLE() {
		return SENSOR_USERINFO_TABLE;
	}
	/**
	 * 
	 */
	public static void setSENSOR_USERINFO_TABLE(boolean sENSOR_USERINFO_TABLE) {
		SENSOR_USERINFO_TABLE = sENSOR_USERINFO_TABLE;
	}

}
