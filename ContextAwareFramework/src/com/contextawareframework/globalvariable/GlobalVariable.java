/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        GlobalVariable
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 ******************************************************************/
package com.contextawareframework.globalvariable;

/********************************************************************
 * All variable are globally accessible and can have only one state in
 * application. This provides a facility to disable any sensor listener 
 * based on any condition.
 ********************************************************************/
public final class GlobalVariable {
public static   boolean SENSOR_ACCELEROMETER = false;
public static   boolean SENSOR_PROXIMITY = false;
public static   boolean SENSOR_LIGHT = false;
public static   boolean SENSOR_LOCATION = false;
public static   boolean SENSOR_BATTERY = false;
public static 	boolean SENSOR_ACCELEROMETER_HIGHPASS = false;
public static 	boolean SENSOR_ACCELEROMETER_LOWPASS = false;
public static 	boolean SENSOR_ACCELEROMETER_TABLE = false;
public static 	boolean SENSOR_PROXIMITY_TABLE = false;
public static 	boolean SENSOR_LOCATION_TABLE = false;
public static	boolean SENSOR_LIGHT_TABLE = false;
public static	boolean SENSOR_BATTERY_TABLE = false;
public static 	boolean SENSOR_USERINFO_TABLE = false;

}
