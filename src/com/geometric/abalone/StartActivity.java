/**
 * 
 */
package com.geometric.abalone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.geometric.abalone.datamodel.GameMode;

/**
 * @author nimishm
 * 
 */
public class StartActivity extends android.app.Activity {
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_start);

		findViewById(R.id.single_player).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						startGame(GameMode.SINGLE_PLAYER);
					}
				});
	}

	/**
	 * 
	 * @param gameMode
	 */
	private void startGame(GameMode gameMode) {
		Intent intent = new Intent(this, GameActivity.class);
		intent.putExtra(GameActivity.GAME_MODE, gameMode);
		startActivity(intent);
	}
}
