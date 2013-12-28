package com.geometric.abalone.ui;

import com.geometric.abalone.datamodel.Board;
import com.geometric.abalone.datamodel.BoardBuilder;
import com.geometric.abalone.datamodel.CellState;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/**
 * 
 * @author nimishm
 * 
 */
public class GameView extends android.view.View {

	/**
	 * 
	 */
	private BoardGraphic mBoardGraphic;

	/**
	 * 
	 */
	private Board mBoard;

	/**
	 * 
	 */
	private Paint mPaint;

	/**
	 * 
	 * @param context
	 */
	public GameView(Context context) {
		super(context);

		mPaint = new Paint();
		mPaint = new Paint();
		mPaint.setARGB(255, 255, 0, 0);
		mPaint.setStyle(Paint.Style.FILL);

		mBoard = BoardBuilder.Build();
		mBoardGraphic = new BoardGraphic(mBoard);

		setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {

				CellGraphic cell = null;

				for (CellGraphic cellGraphic : mBoardGraphic.getCellGraphics()) {
					if (cellGraphic.IsPointInCell(new PointF(arg1.getX(), arg1
							.getY()))) {
						cell = cellGraphic;

						break;
					}
				}

				if (cell != null) {
					cell.getCell().setState(CellState.EMPTY);
				}

				return false;
			}
		});
	}

	/**
	 * 
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mBoardGraphic.Render(canvas);
	}
}
