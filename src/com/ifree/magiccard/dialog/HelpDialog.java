package com.ifree.magiccard.dialog;

import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.main.R;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;

public class HelpDialog extends BasicDialog {
	
	final String tag = "HelpDialog";
	private View dialog_bg;
	private View btn_close = null;
	private View btn_change = null;
	final int type_1 = 1;
	final int type_2 = 2;
	private DialogMethod methos = null;
	private int type;
	
	public HelpDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, R.style.dialog);
		
		type = type_1;
		
		this.setContentView(R.layout.dialog_help);

		this.setCancelable(cancelable);
		if(cancelListener != null)
			this.setOnCancelListener(cancelListener);
		
		dialog_bg = this.findViewById(R.id.dialog_bg);
		btn_close = this.findViewById(R.id.dialog_btn_close);
		btn_close.setOnClickListener(listener);
		btn_change = this.findViewById(R.id.dialog_btn_change);
		btn_change.setOnClickListener(listener);
		
		
		
	}
	
	public void setDialogMethod(DialogMethod dm)
	{
		this.methos = dm;
	}
	
	private View.OnClickListener listener = new View.OnClickListener()
	{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v == btn_close)
			{
				methos.exit();
			}
			else if(v == btn_change)
 			{
				if(type == type_1)
				{
					dialog_bg.setBackgroundResource(R.drawable.help2);
					btn_change.setBackgroundResource(R.drawable.goback);
					type = type_2;
				}
				else if(type == type_2)
				{
					dialog_bg.setBackgroundResource(R.drawable.help1);
					btn_change.setBackgroundResource(R.drawable.next);
					type = type_1;
				}
			
			}
		}

		
		
	};

}
