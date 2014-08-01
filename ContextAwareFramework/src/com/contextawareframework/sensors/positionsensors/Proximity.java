/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Battery
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 ******************************************************************/

package com.contextawareframework.sensors.positionsensors;

/************************************************************************
 * This is a POJO class for accessing all details of Proximity in Android
 ************************************************************************/
public class Proximity {

private float near;
private float far;
private long timestamp;
private int id;
//Default constructor	
public Proximity()
	{
	
	}
public float isNear() {
	return near;
}
public void setNear(float near) {
	this.near = near;
}
public float isFar() {
	return far;
}
public void setFar(float far) {
	this.far = far;
}
public long getTimestamp() {
	return timestamp;
}
public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
