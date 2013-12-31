package com.geometric.abalone.ui;

import java.util.EventObject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.geometric.abalone.algo.Algo;
import com.geometric.abalone.datamodel.Board;
import com.geometric.abalone.datamodel.BoardBuilder;
import com.geometric.abalone.datamodel.BoardChangedEventListener;
import com.geometric.abalone.datamodel.Direction;

/**
 * 
 * @author nimishm
 * 
 */
public class GameView extends android.view.View {
	Algo mAlgo;
	/**
	 * 
	 */
	private CellGraphic mPrevCellGraphic;

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

	private Boolean mCanMove;

	private Direction mDir;

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
		mAlgo = new Algo(mBoard);

		mBoard.setOnChangedListener(new BoardChangedEventListener() {

			@Override
			public void onBoardChanged(EventObject e) {
				invalidate();
			}
		});

		mBoardGraphic = new BoardGraphic(mBoard);

		setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent motionEvent) {
				CellGraphic cell = null;

				switch (motionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:
					cell = getCell(new PointF(motionEvent.getX(),
							motionEvent.getY()));

					if (cell != null) {
						mPrevCellGraphic = cell;
					}

					break;

				case MotionEvent.ACTION_MOVE:
					cell = getCell(new PointF(motionEvent.getX(),
							motionEvent.getY()));

					if (cell != null && cell != mPrevCellGraphic) {

						mDir = getMotionDirection(mPrevCellGraphic, cell);

						mCanMove = mAlgo.CanMove(mPrevCellGraphic.getCell(),
								mDir);
					}

					break;

				case MotionEvent.ACTION_UP:
					if (mCanMove) {
						mAlgo.Move(mPrevCellGraphic.getCell(), mDir);
						mCanMove = false;
					}
					break;

				}

				return true;
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

	/**
	 * 
	 * @param point
	 * @return
	 */
	private CellGraphic getCell(PointF point) {

		CellGraphic cell = null;

		for (CellGraphic cellGraphic : mBoardGraphic.getCellGraphics()) {
			if (cellGraphic.IsPointInCell(new PointF(point.x, point.y))) {
				cell = cellGraphic;

				break;
			}
		}
		return cell;
	}

	/**
	 * 
	 * @param prev
	 * @param curr
	 */
	private Direction getMotionDirection(CellGraphic prev, CellGraphic curr) {
		Direction direction = Direction.NONE;

		if (mBoard.getCellAtNE(prev.getCell()) == curr.getCell()) {
			direction = Direction.NORTH_EAST;
		} else if (mBoard.getCellAtE(prev.getCell()) == curr.getCell()) {
			direction = Direction.EAST;
		} else if (mBoard.getCellAtSE(prev.getCell()) == curr.getCell()) {
			direction = Direction.SOUTH_EAST;
		} else if (mBoard.getCellAtSW(prev.getCell()) == curr.getCell()) {
			direction = Direction.SOUTH_WEST;
		} else if (mBoard.getCellAtW(prev.getCell()) == curr.getCell()) {
			direction = Direction.WEST;
		} else if (mBoard.getCellAtNW(prev.getCell()) == curr.getCell()) {
			direction = Direction.NORTH_WEST;
		}

		return direction;
	}
}
