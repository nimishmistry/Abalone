package com.geometric.abalone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.geometric.abalone.ui.GameView;
import com.geometric.abalone.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainActivity extends Activity {

	private View myView;

	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		myView = new GameView(this);

		setContentView(myView);
	}
}
