package com.contextawareframework.sensors.motionsensors;

public class Gyrometer {

	private long timeStamp;
	private double xAxis;
	private double yAxis;
	private double zAxis;
	private int id;
	/**
	 * @return the timeStamp
	 */
	public final long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public final void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the xAxis
	 */
	public final double getxAxis() {
		return xAxis;
	}
	/**
	 * @param xAxis the xAxis to set
	 */
	public final void setxAxis(double xAxis) {
		this.xAxis = xAxis;
	}
	/**
	 * @return the yAxis
	 */
	public final double getyAxis() {
		return yAxis;
	}
	/**
	 * @param yAxis the yAxis to set
	 */
	public final void setyAxis(double yAxis) {
		this.yAxis = yAxis;
	}
	/**
	 * @return the zAxis
	 */
	public final double getzAxis() {
		return zAxis;
	}
	/**
	 * @param zAxis the zAxis to set
	 */
	public final void setzAxis(double zAxis) {
		this.zAxis = zAxis;
	}
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}
}
