package com.ifree.magiccard.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.logical.GameLogical;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.ui.GameActivity;
import com.ifree.magiccard.util.Debug;

public class ResultDialog extends BasicDialog {

	final String tag = "ResultDialog";
	public static final int type_win = 1;
	public static final int type_lose = 2;
	public static final int type_lose2 = 22;
	private int type;
	private View dialog_bg = null;
	
	private ImageView image_level = null;
	
	private ImageView maxstar = null;
	
	private ImageView currentstar = null;
	
	private TextView maxpoint = null;
	
	private TextView currentpoint = null;
	
	private TextView r_maxpoint = null;
	
	private TextView r_currentpoint = null;
	
	private Rect home_rect = new Rect(22,211,63,252);
	
	private Rect again_rect = new Rect(88,211,127,252);
	
	private Rect next_rect = new Rect(150,211,190,252);
	
	private Context context;
	
	private DialogMethod methos = null;
	
	public ResultDialog(Context context, int type,boolean cancelable, int level,
			OnCancelListener cancelListener) {
		
		super(context,R.style.dialog);
		this.context = context;
		this.type = type;
		this.setContentView(R.layout.dialog_result);
		dialog_bg = this.findViewById(R.id.dialog_bg);
		dialog_bg.setOnTouchListener(listener);
		
		maxstar = (ImageView)this.findViewById(R.id.image_maxstar);
		maxpoint = (TextView)this.findViewById(R.id.text_maxpoint);
		
		currentpoint = (TextView)this.findViewById(R.id.text_currentpoint);
		currentstar = (ImageView)this.findViewById(R.id.image_currentstar);
		
		r_maxpoint = (TextView)this.findViewById(R.id.text_random_maxpoint);
		r_currentpoint = (TextView)this.findViewById(R.id.text_random_currentpoint);
		
		image_level = (ImageView)this.findViewById(R.id.image_level);
		
		if(type == type_win)
		{
		  if(level != 30)
			dialog_bg.setBackgroundResource(R.drawable.showscore_win);
		  else
			dialog_bg.setBackgroundResource(R.drawable.showscore_win2);
		}
		else if(type == type_lose)
			{
			if(level != 30)
				dialog_bg.setBackgroundResource(R.drawable.showscore_lose2);
			else
				dialog_bg.setBackgroundResource(R.drawable.showscore_lose4);
			}
		else if(type == type_lose2)
			{
			if(level != 30)
				dialog_bg.setBackgroundResource(R.drawable.showscore_lose);
			else
				dialog_bg.setBackgroundResource(R.drawable.showscore_lose3);
			}
		this.setCancelable(cancelable);
		if(cancelListener != null)
			this.setOnCancelListener(cancelListener);
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
			
				if(home_rect.contains(x, y))
				{
					methos.changeActivity();
				}
				
				if(again_rect.contains(x, y))
				{
					methos.tryAgain();
				}
				
				if(type ==type_win)
				{
					if(next_rect.contains(x, y))
					{
						methos.nextGame();
					}
				}
			
			}
		return true;
		}
	};
	
	public void setTime(int level,int ctime)
	{    
		
		if(level != 30)
		{
		   int star = Share.getLevelinfo(context, level);	
		   int point = Share.getLevelScoreinfo(context, level);	
		   
		   maxpoint.setText(point + "");
		   switch(star % 10)
		   {
		   case 0:
			   break;
		   case 1:
			   maxstar.setImageResource(R.drawable.lv_satr01);
			   break;
		   case 2:
			   maxstar.setImageResource(R.drawable.lv_satr02);
			   break;
		   case 3:
			   maxstar.setImageResource(R.drawable.lv_satr03);
			   break;
		   }
		
		if(type == ResultDialog.type_win)
		if(ctime != -1)
		{
			int cpoint = GameLogical.countPoint(level, ctime);
			int star2 = GameLogical.countStar(level, cpoint);
			Debug.e(tag, "star:" + star2);
			currentpoint.setText(cpoint + "");
			switch(star2 % 10)
			 {
			   case 0:
				   break;
			   case 1:
				   currentstar.setImageResource(R.drawable.lv_satr01);
				   break;
			   case 2:
				   currentstar.setImageResource(R.drawable.lv_satr02);
				   break;
			   case 3:
				   currentstar.setImageResource(R.drawable.lv_satr03);
				   break;
			 }
		}
		
		}
		
		else 
		{
			if(type == type_lose || type == type_lose2)
			{
				int point = Share.getRandomLevel(context);
				int cpoint = GameActivity.cpoint;
				
				r_currentpoint.setText("" + cpoint);
				r_maxpoint.setText("" + point);
			}
			
			
		}
	}
}
