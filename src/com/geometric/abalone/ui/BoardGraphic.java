package com.geometric.abalone.ui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.IInterface;
import android.telephony.CellLocation;

import com.geometric.abalone.datamodel.*;

/**
 * Represents a board grpahic
 * 
 * @author nimishm
 * 
 */
public class BoardGraphic {
	private Board mBoard;
	private List<CellGraphic> mCellGraphics;

	/**
	 * Constructs a board graphic
	 * 
	 * @param board
	 */
	public BoardGraphic(Board board) {
		mBoard = board;
		mCellGraphics = new ArrayList<CellGraphic>();
	}

	/**
	 * Renders the board graphic
	 * 
	 * @param canvas
	 */
	public void Render(Canvas canvas) {
		float width = canvas.getWidth();
		float height = canvas.getHeight();
		float cellRadius = getCellRadius(width);

		for (int hIndex = 1; hIndex <= 9; ++hIndex) {
			Bound iBound = BoardBounds.getBounds(hIndex);

			float cellHeight = 9 * cellRadius * 2;

			// float cellPosY = ((height - cellHeight) / 2) + cellHeight
			// - (hIndex * cellRadius * 2) - cellRadius;

			float cellPosY = ((height - cellHeight) / 2) + cellHeight
					- ((hIndex - 1) * cellRadius * 2) - cellRadius;

			int iLowerBound = iBound.getLower();
			int iUpperBound = iBound.getUpper();

			for (int iIndex = iLowerBound; iIndex <= iUpperBound; ++iIndex) {

				float cellWidth = (iUpperBound - iLowerBound + 1) * cellRadius
						* 2;

				float cellPosX = ((width - cellWidth) / 2)
						+ ((iIndex - iLowerBound) * cellRadius * 2)
						+ cellRadius;

				Cell cell = mBoard.getCell(hIndex, iIndex);

				CellGraphic cellGraphic = new CellGraphic(cell, new PointF(
						cellPosX, cellPosY), cellRadius);

				cellGraphic.Render(canvas);

				mCellGraphics.add(cellGraphic);
			}
		}
	}

	/**
	 * Gets the board rect
	 * 
	 * @param canvas
	 * @return
	 */
	private RectF getBoardRect(Canvas canvas) {

		float width = canvas.getWidth();
		float height = canvas.getHeight();

		return new RectF(0, (height - width) / 2, width, (height - width) / 2
				+ width);
	}

	/**
	 * Gets the cell radius
	 * 
	 * @param boardWidth
	 * @return
	 */
	private float getCellRadius(float boardWidth) {
		return boardWidth / (9 * 2);
	}
}