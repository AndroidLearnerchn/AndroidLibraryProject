/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        Battery
 * @Created:    18.11.2013
 * @author:     Prasenjit
 * Last Change: 18.11.2013 by Prasenjit
 ******************************************************************/
package com.contextawareframework.exceptions;
/******************************************************************
 * Can be used if any error caused while using Bluetooth 
 ******************************************************************/
public class BluetoothConnectionException extends CAFException{
	
	/******************************************************************
	 * Default Constructor 
	 ******************************************************************/
	public BluetoothConnectionException()
	{
		super("Bluetooth Device Not Available");
	}
	/******************************************************************
	 * Custom Constructor 
	 ******************************************************************/
	public BluetoothConnectionException(String message)
	{
		super(message);
	}
}
