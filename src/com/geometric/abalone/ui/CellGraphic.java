package com.geometric.abalone.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Shader;

import com.geometric.abalone.datamodel.Cell;

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

		int color1, color2, color3, color4 = 0;

		switch (mCell.getState()) {
		case EMPTY:
			mPaint.setARGB(128, 0, 0, 0);
			break;
		case PLAYER1:
			color1 = Color.rgb(255, 0, 0);
			color2 = Color.rgb(225, 0, 0);
			color3 = Color.rgb(192, 0, 0);
			color4 = Color.rgb(160, 0, 0);

			mPaint.setShader(new RadialGradient(mPosition.x, mPosition.y,
					mRadius, new int[] { color1, color2, color3, color4 },
					null, Shader.TileMode.MIRROR));
			break;
		case PLAYER2:
			color1 = Color.rgb(0, 255, 0);
			color2 = Color.rgb(0, 225, 0);
			color3 = Color.rgb(0, 192, 0);
			color4 = Color.rgb(0, 160, 0);

			mPaint.setShader(new RadialGradient(mPosition.x, mPosition.y,
					mRadius, new int[] { color1, color2, color3, color4 },
					null, Shader.TileMode.MIRROR));
			break;
		default:
			mPaint.setARGB(128, 128, 128, 128);
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
		canvas.drawCircle(mPosition.x, mPosition.y, mRadius, mPaint);
	}

	/**
	 * 
	 * @param point
	 */
	public Boolean IsPointInCell(PointF point) {
		return Math.sqrt(Math.pow(point.x - mPosition.x, 2)
				+ Math.pow(point.y - mPosition.y, 2)) < mRadius;
	}
}
