package com.geometric.abalone.ui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.geometric.abalone.datamodel.Board;
import com.geometric.abalone.datamodel.BoardBounds;
import com.geometric.abalone.datamodel.Bound;
import com.geometric.abalone.datamodel.Cell;
import com.geometric.abalone.datamodel.CellState;

/**
 * Represents a board grpahic
 * 
 * @author nimishm
 * 
 */
public class BoardGraphic {
	private Board mBoard;
	private Paint mPlayerScoreBack1;
	private Paint mPlayerScoreBack2;
	private Paint mPlayerScoreFore;
	private List<CellGraphic> mCellGraphics;

	/**
	 * Constructs a board graphic
	 * 
	 * @param board
	 */
	public BoardGraphic(Board board) {
		mBoard = board;

		mPlayerScoreBack1 = new Paint();
		mPlayerScoreBack1.setARGB(255, 255, 128, 128);
		mPlayerScoreBack1.setAntiAlias(true);
		mPlayerScoreBack1.setStyle(Paint.Style.FILL);

		mPlayerScoreBack2 = new Paint();
		mPlayerScoreBack2.setARGB(255, 128, 255, 128);
		mPlayerScoreBack2.setAntiAlias(true);
		mPlayerScoreBack2.setStyle(Paint.Style.FILL);

		mPlayerScoreFore = new Paint();
		mPlayerScoreFore.setARGB(255, 255, 0, 0);
		mPlayerScoreFore.setAntiAlias(true);
		mPlayerScoreFore.setStyle(Paint.Style.STROKE);
		mPlayerScoreFore.setTextSize(36);

		mCellGraphics = new ArrayList<CellGraphic>();
	}

	/**
	 * 
	 * @return
	 */
	public List<CellGraphic> getCellGraphics() {
		return mCellGraphics;
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
		float cellDist = (float) (Math.sin(Math.toRadians(60)) * cellRadius * 2);
		float boardHeight = (2 * cellRadius) + (8 * cellDist);

		for (int hIndex = 1; hIndex <= 9; ++hIndex) {

			float cellPosY = ((height - boardHeight) / 2) + boardHeight
					- ((hIndex - 1) * cellDist) - cellRadius;

			Bound iBound = BoardBounds.getBounds(hIndex);
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

			String msg1 = "Player 1: " + (14 - getScore(CellState.PLAYER2));

			String msg2 = "Player 2: " + (14 - getScore(CellState.PLAYER1));

			canvas.drawRect(0, 0, width, 40, mPlayerScoreBack2);
			canvas.drawRect(0, height - 40, width, height, mPlayerScoreBack1);

			canvas.drawText(msg1,
					(width - mPlayerScoreBack1.measureText(msg1)) / 2, 2,
					mPlayerScoreFore);
			canvas.drawText(msg2,
					(width - mPlayerScoreBack1.measureText(msg1)) / 2,
					height - 38, mPlayerScoreFore);
		}
	}

	/**
	 * 
	 * @param state
	 * @return
	 */
	private int getScore(CellState state) {

		int count = 0;

		List<Cell> cells = mBoard.getCells();

		for (int i = 0; i < cells.size(); ++i) {
			if (cells.get(i).getState() == state) {
				++count;
			}
		}

		return count;
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