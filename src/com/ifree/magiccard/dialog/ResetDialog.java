package com.ifree.magiccard.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.util.Debug;

public class ResetDialog extends BasicDialog {

	private View dialog_bg;
	
	final String tag = "ResetDialog";
	
	private DialogMethod methos = null;
	
	private Rect type1_no_rect = new Rect(67,155,115,194);
	
	private Rect type1_yes_rect = new Rect(172,155,220,195);
	
	private Context context = null;
	
	public ResetDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		 
		super(context,R.style.dialog);
		
		this.context = context;
	
		this.setContentView(R.layout.dialog_reset);
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
				if(type1_no_rect.contains(x, y))
					methos.exit();
				else if(type1_yes_rect.contains(x, y))
				{
					Share.cleanShare(context);
					methos.changeActivity();
				}
					
			}
			
			return true;
		}
	};
	

	

}
