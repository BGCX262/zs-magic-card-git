package com.ifree.magiccard.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;

import com.ifree.magiccard.dialog.MenuDialog;
import com.ifree.magiccard.dialog.ResultDialog;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.logical.Media;
import com.ifree.magiccard.logical.SoundManager;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.util.Debug;
import com.ifree.magiccard.view.GameView;

public class GameActivity extends BasicActivity {

	final String tag = "GameActivity";
	GameView game = null;
	DisplayMetrics outMetrics = new DisplayMetrics();
	public int level = 0;
	public static int ctime = 0;
	public static int cpoint = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		Bundle data = this.getIntent().getExtras();
		if(data != null)
		{
			level = data.getInt("level");
		}
		if(level != 0)
			game = new GameView(this,outMetrics.widthPixels,outMetrics.heightPixels,level);
		else 
		{
			level = 30;
			game = new GameView(this,outMetrics.widthPixels,outMetrics.heightPixels,level);
		}
		this.setContentView(game);
		
		Media.initMusic(this, R.raw.playing);
	}

	Dialog dialog = null;
	final int type_menu = 3;
	public void disDialog(int type) {
		// TODO Auto-generated method stub
		if(type != type_menu)
		{
			dialog = new ResultDialog(GameActivity.this, type, false, level,null);
			((ResultDialog) dialog).setDialogMethod(dm);
			((ResultDialog) dialog).setTime(level,ctime);
			dialog.show();
		}
		else if(type == type_menu)
		{
			dialog = new MenuDialog(GameActivity.this, false, cancelListener);
			((MenuDialog) dialog).setDialogMethod(dm);
			dialog.show();
		}
	}
	
	
	
	private OnCancelListener cancelListener = new OnCancelListener(){

		public void onCancel(DialogInterface dialog) {
			// TODO Auto-generated method stub
		  if(game != null)
			  game.Goon();
		}
		
	};
	
	private DialogMethod dm = new DialogMethod()
	{

		public void exit() {
			// TODO Auto-generated method stub
			if(dialog != null)
				dialog.cancel();
		}

		public void end() {
			
			finish();
			
		}

		public void changeActivity() {
			// TODO Auto-generated method stub
			exit();
			end();
			Intent intent = new Intent();
			intent.setClass(GameActivity.this, MainActivity.class);
			startActivity(intent);
			Media.initMusic(GameActivity.this, R.raw.other);
		}
		
		public void nextGame()
		{
			exit();
			if(level % 10 < 8)
			{
				if(level != 30)
					level = level + 1;
				
//				Bundle data = new Bundle();
//				data.putInt("level", level);
//				Intent intent = new Intent();
//				intent.setClass(GameActivity.this, GameActivity.class);
//				intent.putExtras(data);
//				startActivity(intent);
//				finish();
				game.newGame(level);
				
			}
			else
			{
				end();
				Intent intent = new Intent();
				intent.setClass(GameActivity.this, SelectLevelActivity.class);
				startActivity(intent);
				Media.initMusic(GameActivity.this, R.raw.other);
			}
		}
		
		public void tryAgain()
		{
			exit();
			
//			Bundle data = new Bundle();
//			data.putInt("level", level);
//			Intent intent = new Intent();
//			intent.setClass(GameActivity.this, GameActivity.class);
//			intent.putExtras(data);
//			startActivity(intent);
//			
//			finish();
			GameActivity.cpoint = 0;
			GameActivity.ctime = 0;
			game.newGame(level);
			
			System.gc();
		}
		
	};
	
	public MyHandler handler = new MyHandler();
	
	public class MyHandler extends Handler
	{

		@Override
		public void handleMessage(Message msg) {
		
			Debug.e(tag, "go");
			if(msg.what != -1)
				{
					disDialog(msg.what);
				}
			else
			{
				finish();
				Intent intent = new Intent();
				intent.setClass(GameActivity.this, MainActivity.class);
				startActivity(intent);
				
			}
		}
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(game != null)
		{
			game.Stop();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(game != null)
		{
			game.Goon();
		}
	}
	
	
}
