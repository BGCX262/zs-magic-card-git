package com.ifree.magiccard.iface;

import android.content.Intent;

import com.ifree.magiccard.ui.GameActivity;
import com.ifree.magiccard.ui.SelectLevelActivity;
import com.ifree.magiccard.view.GameView;

public interface DialogMethod {
  
	public void exit();
	public void end();
	public void changeActivity();
	public void nextGame();
	
	public void tryAgain();
}
