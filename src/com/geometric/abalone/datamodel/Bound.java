package com.geometric.abalone.datamodel;

/**
 * 
 * @author nimishm
 * 
 */
public class Bound {
	private int lower;
	private int upper;

	/**
	 * 
	 * @param lower
	 * @param upper
	 */
	public Bound(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
	}

	/**
	 * 
	 * @return
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * 
	 * @return
	 */
	public int getUpper() {
		return upper;
	}
}
