package com.ifree.magiccard.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.logical.Media;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.ui.MainActivity;

public class SettingDialog extends BasicDialog {
  
	private Button music = null;
	private EditText edit = null;
	private Button edit_ok = null;
	private View dialog_bg = null;
	private Rect rect_back = new Rect(77,29,147,52);
	private Rect rect_exit = new Rect(82,162,124,187);
	
	private DialogMethod dm = null;
	public SettingDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		
		super(context, R.style.dialog);
		this.setContentView(R.layout.dialog_setting);
		dialog_bg = this.findViewById(R.id.dialog_bg);
		dialog_bg.setOnTouchListener(listener2);
		music = (Button)this.findViewById(R.id.btn_musicchange);
		music.setOnClickListener(listener);
		edit = (EditText)this.findViewById(R.id.edit_phonenumber);
		edit_ok = (Button)this.findViewById(R.id.btn_numberenter);
		edit_ok.setOnClickListener(listener);
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
			music.setBackgroundResource(R.drawable.music_on);
		else 
			music.setBackgroundResource(R.drawable.music_off);
	}
	
	private View.OnClickListener listener = new View.OnClickListener()
	{

		public void onClick(View view) {
			// TODO Auto-generated method stub
			if(view == music)
			{
				MainActivity.isMusic = !MainActivity.isMusic;
				if(MainActivity.isMusic)
					Media.initMusic(getContext(), R.raw.other);
				else 
					Media.stopMusic();
				change();
			}
			
			else if(view == edit_ok)
			{
				String temp = edit.getEditableText().toString();
				Share.setNumber(getContext(), temp);
			}
		}
		
	};
	
	private OnTouchListener listener2 = new OnTouchListener(){

		public boolean onTouch(View view, MotionEvent motionevent) {
			
			int x = (int)motionevent.getX();
			int y = (int)motionevent.getY();
			
			if(rect_back.contains(x, y))
			{
				 dm.exit();
			}
			else if(rect_exit.contains(x, y))
					{
						dm.exit();
						dm.nextGame();
						
					}
			return false;
		}
		
	};
	

}
