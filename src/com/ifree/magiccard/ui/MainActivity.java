package com.ifree.magiccard.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ifree.magiccard.dialog.AboutDialog;
import com.ifree.magiccard.dialog.BasicDialog;
import com.ifree.magiccard.dialog.ExitDialog;
import com.ifree.magiccard.dialog.HelpDialog;
import com.ifree.magiccard.dialog.ResetDialog;
import com.ifree.magiccard.dialog.SettingDialog;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.logical.Media;
import com.ifree.magiccard.logical.SoundManager;
import com.ifree.magiccard.main.R;

public class MainActivity extends BasicActivity implements OnClickListener {
  
	private Button btn_exit = null;
	private Button btn_continuegame = null;
	private Button btn_newgame = null;
	private Button btn_moregame = null;
	private Button btn_setting = null;
	private Button btn_knowlege = null;
	private Button btn_about = null;
	private Button btn_help = null;
	
	private BasicDialog dialog = null;
	
	public static Resources res = null;
	public static Context context = null;
	
	public static boolean isMusic = false;
	public static boolean isShowAnim = false;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mainactivity);
		res = this.getResources();
		context = this;
		btn_knowlege = (Button)this.findViewById(R.id.btn_knowlege);
		btn_knowlege.setOnClickListener(this);
		btn_exit = (Button)this.findViewById(R.id.btn_exit);
		btn_exit.setOnClickListener(this);
		btn_about = (Button)this.findViewById(R.id.btn_about);
		btn_about.setOnClickListener(this);
		btn_help = (Button)this.findViewById(R.id.btn_help);
		btn_help.setOnClickListener(this);
		btn_continuegame = (Button)this.findViewById(R.id.btn_continuegame);
		btn_continuegame.setOnClickListener(this);
		btn_setting = (Button)this.findViewById(R.id.btn_setting);
		btn_setting.setOnClickListener(this);
		btn_newgame = (Button)this.findViewById(R.id.btn_newgame);
		btn_newgame.setOnClickListener(this);
//		btn_moregame = (Button)this.findViewById(R.id.btn_moregame);
//		btn_moregame.setOnClickListener(this);
		Media.initMusic(this, R.raw.other);
		Media.setLoop(true);
//		SoundManager.playMusic(SoundManager.id_other);
	}

	public void onClick(View v) {
		
		if (v == btn_exit) {
			dialog = new ExitDialog(this, true, null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}
		
		else if (v == btn_about) {
			 
			dialog = new AboutDialog(this, true, null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}
		
		else if(v == btn_help)
		{
			dialog = new HelpDialog(this, true, null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}
		else if(v == btn_setting)
		{
			dialog = new SettingDialog(this, true, null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}
		else if(v == btn_continuegame)
		{
			Intent intent = new Intent();
			intent.setClass(this, SelectLevelActivity.class);
			startActivity(intent);
			this.finish();
		}
		else if(v == btn_knowlege)
		{
			Intent intent = new Intent();
			intent.setClass(this, KnowLegeActivity.class);
			startActivity(intent);
			this.finish();
		}
		else if(v == btn_newgame)
		{
			dialog = new ResetDialog(this, true, null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}
		else if(v == btn_moregame)
		{
			handleBtMoreGame();
		}
			
	}
    
	
	private DialogMethod dm = new DialogMethod()
	{

		public void exit() {
			// TODO Auto-generated method stub
			dialog.cancel();
		}

		public void end() {
			exit();
			finish();
//			SoundManager.stopMusic();
			Media.stopMusic();
		}

		public void changeActivity() {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, SelectLevelActivity.class);
			startActivity(intent);
			MainActivity.this.finish();
		}

		public void nextGame() {
			// TODO Auto-generated method stub
			dialog = new ExitDialog(MainActivity.this, true, null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}

		public void tryAgain() {
			// TODO Auto-generated method stub
			
		}
		
	};

	

	public void handleBtMoreGame() {
		Uri uri = Uri.parse("http://gamepie.i139.cn/wap/s.do?j=377channel&flag=1");
		Intent it = new Intent(Intent.ACTION_VIEW, uri);
		MainActivity.this.startActivity(it);
	}
	
	
}
