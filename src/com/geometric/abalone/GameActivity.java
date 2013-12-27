package com.geometric.abalone;

import com.geometric.abalone.ui.GameView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * 
 * @author nimishm
 * 
 */
public class GameActivity extends Activity {

	/**
	 * 
	 */
	public static final String GAME_MODE = "com.geometric.abalone.GameActivity.GAME_MODE";

	/**
	 * 
	 */
	private View gameView;

	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		gameView = new GameView(this);

		setContentView(gameView);
	}
}
