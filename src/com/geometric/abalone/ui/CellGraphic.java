package com.geometric.abalone.ui;

import android.R.bool;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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
	private Paint mPaint1;

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
			mPaint.setARGB(128, 255, 0, 0);
			break;
		case PLAYER2:
			mPaint.setARGB(128, 0, 255, 0);
			break;
		default:
			mPaint.setARGB(128, 255, 255, 255);
			break;
		}

		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL);

		mPaint1 = new Paint();
		mPaint1.setARGB(255, 255, 255, 255);
		mPaint1.setAntiAlias(true);
		mPaint1.setStyle(Paint.Style.STROKE);
	}

	/**
	 * 
	 * @return
	 */
	public Cell getCell() {
		return mCell;
	}

	/**
	 * Renders the cell on the canvas
	 * 
	 * @param canvas
	 */
	public void Render(Canvas canvas) {
		Path path = new Path();
		path.moveTo(mPosition.x - mRadius, mPosition.y - mRadius);
		path.lineTo(mPosition.x + mRadius, mPosition.y - mRadius);
		path.lineTo(mPosition.x + mRadius, mPosition.y + mRadius);
		path.lineTo(mPosition.x - mRadius, mPosition.y + mRadius);
		path.lineTo(mPosition.x - mRadius, mPosition.y - mRadius);

		canvas.drawPath(path, mPaint);
		canvas.drawPath(path, mPaint1);
		// canvas.drawCircle(mPosition.x, mPosition.y, mRadius, mPaint);
		// canvas.drawText(mCell.getHIndex() + "-" + mCell.getIIndex(),
		// mPosition.x, mPosition.y, mPaint);
	}

	/**
	 * 
	 * @param point
	 */
	public Boolean IsPointInCell(PointF point) {

		if (point.x > mPosition.x - mRadius && point.x < mPosition.x + mRadius
				&& point.y > mPosition.y - mRadius
				&& point.y < mPosition.y + mRadius) {
			return true;
		}

		return false;
	}
}
