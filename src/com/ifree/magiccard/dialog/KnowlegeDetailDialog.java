package com.ifree.magiccard.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.main.R;

public class KnowlegeDetailDialog extends BasicDialog {

	DialogMethod dm = null;
	private View dialog_bg = null;
	private View btn_close = null;
	private View btn_next = null;
	private boolean isFirst = true;
	
	
	public KnowlegeDetailDialog(Context context, boolean cancelable,int index,
			OnCancelListener cancelListener) {
		super(context, R.style.dialog);
		this.setContentView(R.layout.dialog_knowlegebox);
		dialog_bg = this.findViewById(R.id.dialog_bg);
		btn_close = this.findViewById(R.id.dialog_btn_close);
		btn_close.setOnClickListener(listener);
		
		btn_next = this.findViewById(R.id.dialog_btn_change);
		btn_next.setOnClickListener(listener);
		
		init(index);
		
	}
	
	private void changeBg()
	{
		isFirst = !isFirst;
		if(isFirst)
		{
			dialog_bg.setBackgroundResource(R.drawable.box_details01_1);
			btn_next.setBackgroundResource(R.drawable.next);
		}
		else
		{
			dialog_bg.setBackgroundResource(R.drawable.box_details01_2);
			btn_next.setBackgroundResource(R.drawable.goback);
		}
	}
	
	private void init(int type)
	{
		btn_next.setVisibility(View.INVISIBLE);
		switch(type)
		{
		case 0:
			dialog_bg.setBackgroundResource(R.drawable.box_details01_1);
			btn_next.setVisibility(View.VISIBLE);
			break;
		case 1:
			dialog_bg.setBackgroundResource(R.drawable.box_details02);
			break;
		case 2:
			dialog_bg.setBackgroundResource(R.drawable.box_details03);
			break;
		case 3:
			dialog_bg.setBackgroundResource(R.drawable.box_details04);
			break;
		case 4:
			dialog_bg.setBackgroundResource(R.drawable.box_details05);
			break;
		}
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
	
	

}
