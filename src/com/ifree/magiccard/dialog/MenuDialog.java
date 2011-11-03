package com.ifree.magiccard.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.logical.Media;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.ui.GameActivity;
import com.ifree.magiccard.ui.MainActivity;
import com.ifree.magiccard.util.Debug;

public class MenuDialog extends BasicDialog {
	
	final String tag = "MenuDialog";
	
	private View dialog_bg = null;
	private View btn_music = null;
	private EditText edit = null;
	private View btn_edit_ok = null;
	private Rect continue_rect = new Rect(70,20,146,48);
	private Rect help_rect = new Rect(85,150,130,170);
	private Rect back_rect = new Rect(65,230,150,260);
	private DialogMethod dm = null;
	
	private GameActivity context = null;
	public MenuDialog(GameActivity context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context,R.style.dialog);
	
		this.context = context;
		this.setContentView(R.layout.dialog_menu);
		if(cancelListener != null)
		{
			this.setOnCancelListener(cancelListener);
		}
		dialog_bg = this.findViewById(R.id.dialog_bg);
		
		dialog_bg.setOnTouchListener(listener2);
		
		btn_music = (Button)this.findViewById(R.id.btn_musicchange);
		btn_music.setOnClickListener(listener);
		edit = (EditText)this.findViewById(R.id.edit_phonenumber);
		btn_edit_ok = (Button)this.findViewById(R.id.btn_numberenter);
		btn_edit_ok.setOnClickListener(listener);
		this.setCancelable(cancelable);
		String temp = Share.getNumber(getContext());
		change();
		if(temp == null)
		{
			edit.setText("°ó¶¨ºÅÂë!");
		}
		else 
		{
			edit.setText(temp);
		}
		
		if(cancelListener != null)
			this.setOnCancelListener(cancelListener);
	}
	
	
	@Override
	public void setDialogMethod(DialogMethod dm) {
		// TODO Auto-generated method stub
		super.setDialogMethod(dm);
		this.dm = dm;
	}



	private void change()
	{
		if(MainActivity.isMusic)
			btn_music.setBackgroundResource(R.drawable.music_on);
		else 
			btn_music.setBackgroundResource(R.drawable.music_off);
	}
	
	private View.OnClickListener listener = new View.OnClickListener()
	{

		public void onClick(View view) {
			// TODO Auto-generated method stub
			if(view == btn_music)
			{
				MainActivity.isMusic = !MainActivity.isMusic;
				if(MainActivity.isMusic)
					Media.initMusic(getContext(), R.raw.playing);
				else 
					Media.stopMusic();
				change();
			}
			
			else if(view == btn_edit_ok)
			{
				String temp = edit.getEditableText().toString();
				Share.setNumber(getContext(), temp);
			}
		}
		
	};


	private OnTouchListener listener2 = new OnTouchListener() {
		
		public boolean onTouch(View v, MotionEvent event) {
			
			int x = 0;
			int y = 0;
			
			Debug.e(tag, "x:" + (x = (int)event.getX()) 
					+ ",y:" + (y = (int)event.getY()));
			
		
			if(event.getAction() == MotionEvent.ACTION_UP)
			{
				if(continue_rect.contains(x, y))
				{
					dm.exit();
				}
				else if(help_rect.contains(x, y))
				{
					dialog = new HelpDialog(context,true,null);
					dialog.setDialogMethod(dm2);
					dialog.show();
				}
				else if(back_rect.contains(x, y))
				{
					
					Message msg = new Message();
					msg.what = -1;
					context.handler.sendMessage(msg);
				}
			
			}
		return true;
		}
	};
	HelpDialog dialog = null;
	private DialogMethod dm2 = new DialogMethod()
	{

		public void exit() {
			// TODO Auto-generated method stub
		  if(dialog != null)	
			  dialog.cancel();
		}

		public void end() {
			
			
			
		}

		public void changeActivity() {
			// TODO Auto-generated method stub
			
		}

		public void nextGame() {
			// TODO Auto-generated method stub
			
		}

		public void tryAgain() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}
