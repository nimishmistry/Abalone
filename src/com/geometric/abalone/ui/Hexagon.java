/**
 * 
 */
package com.geometric.abalone.ui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.PointF;

/**
 * @author nimishm
 * 
 */
public class Hexagon {

	/**
	 * Center of the hexagon
	 */
	private PointF mCenter;

	/**
	 * Dimension of the hexagon
	 */
	private float mDimension;

	/**
	 * Vertices of the hexagon
	 */
	private List<PointF> mVertices;

	/**
	 * 
	 */
	public Hexagon(PointF center, float dimension) {
		mCenter = center;
		mDimension = dimension;

		mVertices = new ArrayList<PointF>(6);
		generateVertices();
	}

	public List<PointF> getVertices() {
		return mVertices;
	}

	/**
	 * Generates the vertices of the Hexagon
	 */
	private void generateVertices() {
		mVertices.add(new PointF(mCenter.x - mDimension, mCenter.y));
		mVertices.add(new PointF(mCenter.x
				- (float) (Math.cos(60) * mDimension), mCenter.y
				+ (float) (Math.sin(60) * mDimension)));
		mVertices.add(new PointF(mCenter.x
				+ (float) (Math.cos(60) * mDimension), mCenter.y
				- (float) (Math.sin(60) * mDimension)));
		mVertices.add(new PointF(mCenter.x + mDimension, mCenter.y));
		mVertices.add(new PointF(mCenter.x
				+ (float) (Math.cos(60) * mDimension), mCenter.y
				+ (float) (Math.sin(60) * mDimension)));
		mVertices.add(new PointF(mCenter.x
				- (float) (Math.cos(60) * mDimension), mCenter.y
				+ (float) (Math.sin(60) * mDimension)));
	}
}
