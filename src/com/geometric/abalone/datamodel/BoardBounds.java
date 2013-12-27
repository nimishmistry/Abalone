/**
 * 
 */
package com.geometric.abalone.datamodel;

/**
 * @author nimishm
 * 
 */
public class BoardBounds {
	public static Bound getBounds(int hIndex) {

		int lower, upper;

		if (hIndex <= 5) {
			lower = 1;
			upper = hIndex + 4;
		} else {
			lower = hIndex - 4;
			upper = 9;
		}

		return new Bound(lower, upper);
	}
}
