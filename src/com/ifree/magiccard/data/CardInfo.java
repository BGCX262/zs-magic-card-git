package com.ifree.magiccard.data;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.ifree.magiccard.util.Debug;



public class CardInfo {
   
	public int type;
	public Rect old;
	public Rect current;
	public Bitmap card;
	public boolean isClick;
	
	public CardInfo()
	{
		
	}
	
	public CardInfo(Rect src, Bitmap card)
	{
		old = new Rect(src);
		current = new Rect(src);
		isClick  = false;
		this.card = card;
	}
	
	public CardInfo(CardInfo src)
	{
		old = new Rect(src.old);
		current = new Rect(old);
		isClick  = false;
		this.card = src.card;
		this.type = src.type;
	}
	
	public void reset()
	{  
		Debug.e("Card Reset:", "true");
		current = new Rect(old);
		isClick = false;
	}
}
