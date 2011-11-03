package com.ifree.magiccard.dialog;

import android.content.Context;
import android.view.View;

import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.main.R;

public class AnimDialog extends BasicDialog {

	private View dialog_bg = null;
	private View btn_change = null;
	private View btn_close = null;
	private boolean isFirst = true;
	DialogMethod dm = null;
	
	public AnimDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, R.style.dialog);
		// TODO Auto-generated constructor stub
		this.setContentView(R.layout.dialog_anim);
		dialog_bg = this.findViewById(R.id.dialog_bg);
		dialog_bg.setBackgroundResource(R.drawable.anim_01);
		btn_change = this.findViewById(R.id.dialog_btn_change);
		btn_change.setOnClickListener(listener);
		btn_close = this.findViewById(R.id.dialog_btn_close);
		btn_close.setOnClickListener(listener);
	}

	private View.OnClickListener listener = new View.OnClickListener(){

		public void onClick(View v) {
			// TODO Auto-generated method stub
		  if(v == btn_close)
			  dm.exit();
		  else
		  {
			  changeBg();
		  }
		}

	};
	
	
	@Override
	public void setDialogMethod(DialogMethod dm) {
		// TODO Auto-generated method stub
		super.setDialogMethod(dm);
		this.dm = dm;
	}
	
	private void changeBg()
	{
		isFirst = !isFirst;
		if(isFirst)
		{
			dialog_bg.setBackgroundResource(R.drawable.anim_01);
			btn_change.setBackgroundResource(R.drawable.next);
		}
		else
		{
			dialog_bg.setBackgroundResource(R.drawable.anim_02);
			btn_change.setBackgroundResource(R.drawable.goback);
		}
	}
}
