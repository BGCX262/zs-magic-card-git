package com.ifree.magiccard.dialog;

import com.ifree.magiccard.iface.DialogMethod;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;

public class BasicDialog extends Dialog {

	public BasicDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}
	
	public BasicDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	public void setDialogMethod(DialogMethod dm)
	{
		
	}
	

}
