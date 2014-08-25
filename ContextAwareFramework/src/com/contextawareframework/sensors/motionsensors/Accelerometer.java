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
 * @File        Accelerometer
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 22.08.2014 by Prasenjit
 */
package com.contextawareframework.sensors.motionsensors;

/**
 * This is a POJO class for accessing all details of Accelerometer Sensor in Android. 
 * It contains Getter and Setter for each attribute
 */

public class Accelerometer {
	private long timestamp;
	private double x;
	private double y;
	private double z;
	private int id;
	private String comment;

	/**
	 * Default Constructor
	 */
	public Accelerometer(){
		x=0;
		y=0;
		z=0;
		timestamp = 0;
	}

	/**
	 * Custom Constructor
	 */
	public Accelerometer(long timestamp, double x, double y, double z) {
		this.timestamp = timestamp;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Description : Getter and Setter method for each attribute
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = (int) id;
	}
	/**
	 * 
	 * @return
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * 
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * 
	 * @return
	 */
	public double getZ() {
		return z;
	}

	/**
	 * 
	 * @param z
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * 
	 * @return
	 */
	public String getComment() {

		return comment;
	}

	/**
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 
	 */
	public String toString()
	{
		return "t="+timestamp+", x="+x+", y="+y+", z="+z;
	}
}
