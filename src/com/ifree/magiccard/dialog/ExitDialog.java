package com.ifree.magiccard.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.ui.MainActivity;
import com.ifree.magiccard.util.Debug;

public class ExitDialog extends BasicDialog {

	private View dialog_bg;
	final int type_1 = 1;
	final int type_2 = 2;
	
	final String tag = "ExitDialog";
	
	private DialogMethod methos = null;
	
	private int type;
	
	private Rect type1_no_rect = new Rect(67,155,115,205);
	
	private Rect type1_yes_rect = new Rect(172,155,220,205);
	
	private Rect type2_yes_rect = new Rect(42,187,109,233);
	
	private Rect type2_no_rect = new Rect(188,187,250,233);
	
	private Context context = null;
	
	public ExitDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		 
		super(context,R.style.dialog);
		
		this.context = context;
		
		type = type_1;
		
		this.setContentView(R.layout.dialog_exit);
		this.setCancelable(cancelable);
		if(cancelListener != null)
			this.setOnCancelListener(cancelListener);
		dialog_bg = this.findViewById(R.id.dialog_bg);
		dialog_bg.setOnTouchListener(listener);
		
	}
	
	public void setDialogMethod(DialogMethod dm)
	{
		this.methos = dm;
	}
	
	private OnTouchListener listener = new OnTouchListener() {
		
		public boolean onTouch(View v, MotionEvent event) {
			
			int x = 0;
			int y = 0;
			
			Debug.e(tag, "x:" + (x = (int)event.getX()) 
					+ ",y:" + (y = (int)event.getY()));
			
			if(event.getAction() == MotionEvent.ACTION_UP)
			{
			
			if(type == type_1)
				{
					if(type1_yes_rect.contains(x, y))
					{
						dialog_bg.setBackgroundResource(R.drawable.exit_02);
						type = type_2;
//						methos.end();
					}
					else if(type1_no_rect.contains(x, y))
					{
						methos.exit();
					}
				}
			else if(type == type_2)
				{
					if(type2_yes_rect.contains(x, y))
					{
						handleBtMoreGame();
						methos.end();
					}
					else if(type2_no_rect.contains(x, y))
					{
						methos.end();
					}
				}
			
			}
			return true;
		}
	};
	
	public void handleBtMoreGame() {
		Uri uri = Uri.parse("http://gamepie.i139.cn/wap/s.do?j=377channel&flag=1");
		Intent it = new Intent(Intent.ACTION_VIEW, uri);
		context.startActivity(it);
	}
	

}
