package com.geometric.abalone.ui;

import com.geometric.abalone.datamodel.Board;
import com.geometric.abalone.datamodel.BoardBuilder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameView extends android.view.View {

	private BoardGraphic mBoardGraphic;
	private Board mBoard;
	private Paint mPaint;

	public GameView(Context context) {
		super(context);

		mPaint = new Paint();
		mPaint = new Paint();
		mPaint.setARGB(255, 255, 0, 0);
		mPaint.setStyle(Paint.Style.FILL);

		mBoard = BoardBuilder.Build();
		mBoardGraphic = new BoardGraphic(mBoard);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// float width = canvas.getWidth();
		// float height = canvas.getHeight();
		//
		// canvas.drawLine(0F, height / 2, width / 4,
		// (float) ((height / 2) + (0.866 * width / 2)), mPaint);
		// canvas.drawLine(width / 4,
		// (float) ((height / 2) + (0.866 * width / 2)), width * 3 / 4,
		// (float) ((height / 2) + (0.866 * width / 2)), mPaint);
		// canvas.drawLine(width * 3 / 4,
		// (float) ((height / 2) + (0.866 * width / 2)), width,
		// height / 2, mPaint);
		// canvas.drawLine(width, height / 2, width * 3 / 4,
		// (float) ((height / 2) - (0.866 * width / 2)), mPaint);
		// canvas.drawLine(width * 3 / 4,
		// (float) ((height / 2) - (0.866 * width / 2)), width / 4,
		// (float) ((height / 2) - (0.866 * width / 2)), mPaint);
		// canvas.drawLine(width / 4,
		// (float) ((height / 2) - (0.866 * width / 2)), 0F, height / 2,
		// mPaint);

		// Hexagon hexagon = new Hexagon(new PointF(width / 2, height / 2),
		// width / 2);
		//
		// canvas.drawLine(hexagon.getVertices().get(0).x, hexagon.getVertices()
		// .get(0).y, hexagon.getVertices().get(1).x, hexagon
		// .getVertices().get(1).y, mPaint);
		// canvas.drawLine(hexagon.getVertices().get(1).x, hexagon.getVertices()
		// .get(1).y, hexagon.getVertices().get(2).x, hexagon
		// .getVertices().get(2).y, mPaint);
		// canvas.drawLine(hexagon.getVertices().get(2).x, hexagon.getVertices()
		// .get(2).y, hexagon.getVertices().get(3).x, hexagon
		// .getVertices().get(3).y, mPaint);
		// canvas.drawLine(hexagon.getVertices().get(3).x, hexagon.getVertices()
		// .get(3).y, hexagon.getVertices().get(4).x, hexagon
		// .getVertices().get(4).y, mPaint);
		// canvas.drawLine(hexagon.getVertices().get(4).x, hexagon.getVertices()
		// .get(4).y, hexagon.getVertices().get(5).x, hexagon
		// .getVertices().get(5).y, mPaint);
		// canvas.drawLine(hexagon.getVertices().get(5).x, hexagon.getVertices()
		// .get(5).y, hexagon.getVertices().get(0).x, hexagon
		// .getVertices().get(0).y, mPaint);

		mBoardGraphic.Render(canvas);
	}
}
