/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Battery
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 ******************************************************************/
package com.contextawareframework.sensors.motionsensors;
/****************************************************************************
 * This is a POJO class for accessing all details of Accelerometer Sensor in Android. 
 * It contains Getter and Setter for each attribute
 ****************************************************************************/
   
public class Accelerometer {
	private long timestamp;
	private double x;
	private double y;
	private double z;
	private int id;
	private String comment;
	/****************************************************************************
	 * Default Constructor
	 ****************************************************************************/
	public Accelerometer(){
	x=0;
	y=0;
	z=0;
	timestamp = 0;
	}
	/****************************************************************************
	 * Custom Constructor
	 ****************************************************************************/
	public Accelerometer(long timestamp, double x, double y, double z) {
		this.timestamp = timestamp;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/******************************************************************
	 * Description : Getter and Setter method for each attribute
	 ******************************************************************/
	public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = (int) id;
	  }
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public String getComment() {
	    
		return comment;
	  }

	  public void setComment(String comment) {
	    this.comment = comment;
	  }
	public String toString()
	{
		return "t="+timestamp+", x="+x+", y="+y+", z="+z;
	}
}
