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
public class CAFConfig {
	
	
	private static  boolean sensorAccelerometer = false;
	private static  boolean SensorProximity = false;
	private static  boolean sensorLight = false;
	private static  boolean sensorLocation = false;
	private static  boolean sensorBattery = false;
	private static 	boolean sensorAccelerometerHighpass = false;
	private static 	boolean sensorAccelerometerLowpass = false;
	private static 	boolean tableAccelerometer = false;
	private static 	boolean tableProximity = false;
	private static 	boolean tableLocation = false;
	private static	boolean tableLight = false;
	private static	boolean tableBattery = false;
	private static 	boolean tableUserinfo = false;
	private static  boolean enableDebugging = false;
	
	/**
	 * @return the sensorAccelerometer
	 */
	public static final boolean isSensorAccelerometer() {
		return sensorAccelerometer;
	}
	/**
	 * @param sensorAccelerometer the sensorAccelerometer to set
	 */
	public static final void setSensorAccelerometer(boolean sensorAccelerometer) {
		CAFConfig.sensorAccelerometer = sensorAccelerometer;
	}
	/**
	 * @return the sensorProximity
	 */
	public static final boolean isSensorProximity() {
		return SensorProximity;
	}
	/**
	 * @param sensorProximity the sensorProximity to set
	 */
	public static final void setSensorProximity(boolean sensorProximity) {
		SensorProximity = sensorProximity;
	}
	/**
	 * @return the sensorLight
	 */
	public static final boolean isSensorLight() {
		return sensorLight;
	}
	/**
	 * @param sensorLight the sensorLight to set
	 */
	public static final void setSensorLight(boolean sensorLight) {
		CAFConfig.sensorLight = sensorLight;
	}
	/**
	 * @return the sensorLocation
	 */
	public static final boolean isSensorLocation() {
		return sensorLocation;
	}
	/**
	 * @param sensorLocation the sensorLocation to set
	 */
	public static final void setSensorLocation(boolean sensorLocation) {
		CAFConfig.sensorLocation = sensorLocation;
	}
	/**
	 * @return the sensorBattery
	 */
	public static final boolean isSensorBattery() {
		return sensorBattery;
	}
	/**
	 * @param sensorBattery the sensorBattery to set
	 */
	public static final void setSensorBattery(boolean sensorBattery) {
		CAFConfig.sensorBattery = sensorBattery;
	}
	/**
	 * @return the sensorAccelerometerHighpass
	 */
	public static final boolean isSensorAccelerometerHighpass() {
		return sensorAccelerometerHighpass;
	}
	/**
	 * @param sensorAccelerometerHighpass the sensorAccelerometerHighpass to set
	 */
	public static final void setSensorAccelerometerHighpass(
			boolean sensorAccelerometerHighpass) {
		CAFConfig.sensorAccelerometerHighpass = sensorAccelerometerHighpass;
	}
	/**
	 * @return the sensorAccelerometerLowpass
	 */
	public static final boolean isSensorAccelerometerLowpass() {
		return sensorAccelerometerLowpass;
	}
	/**
	 * @param sensorAccelerometerLowpass the sensorAccelerometerLowpass to set
	 */
	public static final void setSensorAccelerometerLowpass(
			boolean sensorAccelerometerLowpass) {
		CAFConfig.sensorAccelerometerLowpass = sensorAccelerometerLowpass;
	}
	/**
	 * @return the tableAccelerometer
	 */
	public static final boolean isTableAccelerometer() {
		return tableAccelerometer;
	}
	/**
	 * @param tableAccelerometer the tableAccelerometer to set
	 */
	public static final void setTableAccelerometer(boolean tableAccelerometer) {
		CAFConfig.tableAccelerometer = tableAccelerometer;
	}
	/**
	 * @return the tableProximity
	 */
	public static final boolean isTableProximity() {
		return tableProximity;
	}
	/**
	 * @param tableProximity the tableProximity to set
	 */
	public static final void setTableProximity(boolean tableProximity) {
		CAFConfig.tableProximity = tableProximity;
	}
	/**
	 * @return the tableLocation
	 */
	public static final boolean isTableLocation() {
		return tableLocation;
	}
	/**
	 * @param tableLocation the tableLocation to set
	 */
	public static final void setTableLocation(boolean tableLocation) {
		CAFConfig.tableLocation = tableLocation;
	}
	/**
	 * @return the tableLight
	 */
	public static final boolean isTableLight() {
		return tableLight;
	}
	/**
	 * @param tableLight the tableLight to set
	 */
	public static final void setTableLight(boolean tableLight) {
		CAFConfig.tableLight = tableLight;
	}
	/**
	 * @return the tableBattery
	 */
	public static final boolean isTableBattery() {
		return tableBattery;
	}
	/**
	 * @param tableBattery the tableBattery to set
	 */
	public static final void setTableBattery(boolean tableBattery) {
		CAFConfig.tableBattery = tableBattery;
	}
	/**
	 * @return the tableUserinfo
	 */
	public static final boolean isTableUserinfo() {
		return tableUserinfo;
	}
	/**
	 * @param tableUserinfo the tableUserinfo to set
	 */
	public static final void setTableUserinfo(boolean tableUserinfo) {
		CAFConfig.tableUserinfo = tableUserinfo;
	}
	/**
	 * @return the enableDebugging
	 */
	public static final boolean isEnableDebugging() {
		return enableDebugging;
	}
	/**
	 * @param enableDebugging the enableDebugging to set
	 */
	public static final void setEnableDebugging(boolean enableDebugging) {
		CAFConfig.enableDebugging = enableDebugging;
	}
	

}
