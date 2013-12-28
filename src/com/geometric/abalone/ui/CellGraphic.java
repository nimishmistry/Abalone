package com.geometric.abalone.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.geometric.abalone.datamodel.*;

/**
 * 
 * @author nimishm
 * 
 */
public class CellGraphic {

	/**
	 * Paint object
	 */
	private Paint mPaint;

	/**
	 * Reference to the cell
	 */
	private Cell mCell;

	/**
	 * Position of the cell
	 */
	private PointF mPosition;

	/**
	 * Radius of the cell
	 */
	private float mRadius;

	/**
	 * Create the cell graphic
	 * 
	 * @param cell
	 */
	public CellGraphic(Cell cell, PointF position, float radius) {
		mCell = cell;
		mPosition = position;
		mRadius = radius;

		mPaint = new Paint();

		switch (mCell.getState()) {
		case EMPTY:
			mPaint.setARGB(128, 0, 0, 0);
			break;
		case PLAYER1:
			mPaint.setARGB(255, 255, 0, 0);
			break;
		case PLAYER2:
			mPaint.setARGB(255, 0, 255, 0);
			break;
		default:
			mPaint.setARGB(255, 255, 255, 255);
			break;
		}

		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL);
	}

	/**
	 * Renders the cell on the canvas
	 * 
	 * @param canvas
	 */
	public void Render(Canvas canvas) {
		canvas.drawCircle(mPosition.x, mPosition.y, mRadius, mPaint);
		// canvas.drawText(mCell.getHIndex() + "-" + mCell.getIIndex(),
		// mPosition.x, mPosition.y, mPaint);
	}
}
