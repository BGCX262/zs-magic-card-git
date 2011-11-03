package com.ifree.magiccard.data;

import android.graphics.Bitmap;
import android.graphics.Rect;



public class NumOpeInfo extends CardInfo{
  
	public NumOpeInfo()
	{
		
	}
	
	public NumOpeInfo(Rect src, Bitmap card) {
		super(src, card);
		// TODO Auto-generated constructor stub
	}
	public int type;
	public Bitmap image;
	public Rect pos;
	public boolean isNum;
	public Bitmap[] num;
	public Bitmap operate;
}
