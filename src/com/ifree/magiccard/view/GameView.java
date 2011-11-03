package com.ifree.magiccard.view;

import java.util.Vector;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Message;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.ifree.magiccard.data.CardInfo;
import com.ifree.magiccard.data.Define;
import com.ifree.magiccard.data.NumOpeInfo;
import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.dialog.ResultDialog;
import com.ifree.magiccard.iface.ViewMethod;
import com.ifree.magiccard.logical.AnimRunning;
import com.ifree.magiccard.logical.GameLogical;
import com.ifree.magiccard.logical.ImageManager;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.ui.GameActivity;
import com.ifree.magiccard.util.Debug;
import com.ifree.magiccard.util.ImageUtil;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{
 
	final String tag = "GameView";
	private SurfaceHolder holder;
	int width;
	int height;
	private Rect all_rect = null;
	private int state = 0;
	private ViewMethod methos = null;
	private Resources res = null;
	private GameLogical gl = null;
	private Bitmap image_bg = null;
	private Bitmap image_time = null;
	private Bitmap[] image_nums = null;
	private Bitmap[] image_card_nums = null;
	private Bitmap image_ocard1 = null;
	private Bitmap image_ocard2 = null;
	private Bitmap image_ocard1_detail = null;
	private Bitmap image_ocard2_detail = null;
	
	private CardInfo c1,c2;
	private AnimRunning ar = null;
	private Vector cards = null;
	private int process_index = -1;
	private Vector[] process = new Vector[4];
	private NumOpeInfo[] operates;
	private NumOpeInfo[] equation;
	
	private Rect time_rect = new Rect(15,16,68,40);
	private Rect card1_src = new Rect(78,90,141,191);
	private Rect card2_src = new Rect(177,90,240,191);
	private Rect card3_src = new Rect(78,215,141,316);
	private Rect card4_src = new Rect(177,215,240,316);
	
	
	private Rect oper1_src = new Rect(52,394,94,442);
	private Rect oper2_src = new Rect(96,394,138,442);
	private Rect oper3_src = new Rect(140,394,182,442);
	private Rect oper4_src = new Rect(184,394,226,442);
	private Rect oper5_src = new Rect(228,394,270,442);
	
	private Rect equal1_src = new Rect(52,338,94,386);
	private Rect equal2_src = new Rect(96,338,138,386);
	private Rect equal3_src = new Rect(140,338,182,386);
	private Rect equal4_src = new Rect(184,338,226,386);
	private Rect equal5_src = new Rect(228,338,270,386);
	
	private Rect menu_rect = new Rect(15,450,55,470);
	private Rect back_rect = new Rect(260,450,300,470);
	
	private Rect ocard1_rect = new Rect(188,7,230,40);
	private Rect ocard2_rect = new Rect(246,7,289,40);
	private Rect ocard_use_rect = new Rect(45,445,115,474);
	private Rect ocard_cancel_rect = new Rect(202,445,275,474);
	
	private boolean canClick = true;
	private boolean menu_clicked = false;
	private boolean back_clicked = false;
	private boolean showCard = false;
	private Bitmap menu_btn_down = null;
	private Bitmap menu_btn_up = null;
	private Bitmap back_btn_down = null;
	private Bitmap back_btn_up = null;
	
	private int dialog_type;
	private boolean showDialog = false;
	private Paint paint = new Paint();
	private int time;
	public GameThread gt = null;
	
	public void setMethos(ViewMethod methos)
	{
		this.methos = methos;
	}
	
	GameActivity context = null;
	
	private void ChangeSize()
	{
		time_rect = new Rect(changeWidth(time_rect.left), changeHeight(time_rect.top), changeWidth(time_rect.right), changeHeight(time_rect.bottom));
		card1_src = new Rect(changeWidth(card1_src.left), changeHeight(card1_src.top), changeWidth(card1_src.right), changeHeight(card1_src.bottom));
		card2_src = new Rect(changeWidth(card2_src.left), changeHeight(card2_src.top), changeWidth(card2_src.right), changeHeight(card2_src.bottom));
		card3_src = new Rect(changeWidth(card3_src.left), changeHeight(card3_src.top), changeWidth(card3_src.right), changeHeight(card3_src.bottom));
		card4_src = new Rect(changeWidth(card4_src.left), changeHeight(card4_src.top), changeWidth(card4_src.right), changeHeight(card4_src.bottom));
		oper1_src = new Rect(changeWidth(oper1_src.left), changeHeight(oper1_src.top), changeWidth(oper1_src.right), changeHeight(oper1_src.bottom));
		oper2_src = new Rect(changeWidth(oper2_src.left), changeHeight(oper2_src.top), changeWidth(oper2_src.right), changeHeight(oper2_src.bottom));
		oper3_src = new Rect(changeWidth(oper3_src.left), changeHeight(oper3_src.top), changeWidth(oper3_src.right), changeHeight(oper3_src.bottom));
		oper4_src = new Rect(changeWidth(oper4_src.left), changeHeight(oper4_src.top), changeWidth(oper4_src.right), changeHeight(oper4_src.bottom));
		oper5_src = new Rect(changeWidth(oper5_src.left), changeHeight(oper5_src.top), changeWidth(oper5_src.right), changeHeight(oper5_src.bottom));
		equal1_src = new Rect(changeWidth(equal1_src.left), changeHeight(equal1_src.top), changeWidth(equal1_src.right), changeHeight(equal1_src.bottom));
		equal2_src = new Rect(changeWidth(equal2_src.left), changeHeight(equal2_src.top), changeWidth(equal2_src.right), changeHeight(equal2_src.bottom));
		equal3_src = new Rect(changeWidth(equal3_src.left), changeHeight(equal3_src.top), changeWidth(equal3_src.right), changeHeight(equal3_src.bottom));
		equal4_src = new Rect(changeWidth(equal4_src.left), changeHeight(equal4_src.top), changeWidth(equal4_src.right), changeHeight(equal4_src.bottom));
		equal5_src = new Rect(changeWidth(equal5_src.left), changeHeight(equal5_src.top), changeWidth(equal5_src.right), changeHeight(equal5_src.bottom));
		menu_rect = new Rect(changeWidth(menu_rect.left), changeHeight(menu_rect.top), changeWidth(menu_rect.right), changeHeight(menu_rect.bottom));
		back_rect = new Rect(changeWidth(back_rect.left), changeHeight(back_rect.top), changeWidth(back_rect.right), changeHeight(back_rect.bottom));
		ocard1_rect = new Rect(changeWidth(ocard1_rect.left), changeHeight(ocard1_rect.top), changeWidth(ocard1_rect.right), changeHeight(ocard1_rect.bottom));
		ocard2_rect = new Rect(changeWidth(ocard2_rect.left), changeHeight(ocard2_rect.top), changeWidth(ocard2_rect.right), changeHeight(ocard2_rect.bottom));
		ocard_use_rect = new Rect(changeWidth(ocard_use_rect.left), changeHeight(ocard_use_rect.top), changeWidth(ocard_use_rect.right), changeHeight(ocard_use_rect.bottom));
		ocard_cancel_rect = new Rect(changeWidth(ocard_cancel_rect.left), changeHeight(ocard_cancel_rect.top), changeWidth(ocard_cancel_rect.right), changeHeight(ocard_cancel_rect.bottom));
	}
	private int level = 0;
	public GameView(GameActivity context,int width,int height,int level) {
		super(context);
		this.context = context;
		res = this.getResources();
		this.width = width;
		this.height = height;
		this.level = level;
		holder = this.getHolder();
		holder.addCallback(this);
		ChangeSize();
		all_rect = new Rect(0,0,width,height);
		initImage();
		gl = new GameLogical(context);
		
		paint.setTextSize(16);
		
		newGame(level);
		
	}

	public void newGame(int level)
	{
		this.level = level;
		Rect[] rects = { card1_src, card2_src, card3_src, card4_src };

		if (level != 30)

			cards = gl.getNewCards(level, rects);

		else

			cards = gl.getNewCards2(rects);

		Rect[] rects2 = { oper1_src, oper2_src, oper3_src, oper4_src, oper5_src };

		operates = gl.getOperate(rects2);

		Rect[] rects3 = { equal1_src, equal2_src, equal3_src, equal4_src,
				equal5_src };

		equation = gl.getGameEquation(rects3);
		if (level == 30 && GameActivity.ctime != 0) {
			if (GameActivity.ctime + 30 <= 300)
				time = GameActivity.ctime + 30;
			else
				time = 300;
		} else
			time = gl.getLevel_time(level);

		if (ar == null) {
			ar = new AnimRunning(this, this);
		}
		process_index = -1;
		process = new Vector[4];
		sol_index = 0;
		saveAProcess();
		Stop();
		gt = new GameThread();
		gt.start();
		Draw();
	}
	
	private void saveAProcess()
	{  
		int max = cards.size();
		Vector temp = new Vector();
		process_index++;
		Debug.e(tag, "index change:" + process_index);
		for(int i = 0 ; i < max ; i++)
		{  
			CardInfo src = (CardInfo)cards.get(i);
			CardInfo tem = new CardInfo(src);
			temp.add(tem);
		}
		process[process_index] = temp;
	}
	
	private void returnAProcess()
	{  
		if(process_index > 0)
		{
			process_index--;
		}
		Debug.e(tag, "process_index: " + process_index);
		int max = process[process_index].size();
		Vector tt = process[process_index];
		Vector temp = new Vector();
		for(int i = 0 ; i < max ; i++)
		{  
			CardInfo src = (CardInfo)tt.get(i);
			CardInfo tem = new CardInfo(src);
			temp.add(tem);
		}
		cards = temp;
	}
	
	private int changeWidth(int x)
	{
	    return x * 	width / 320;
	}
	
	private int changeHeight(int y)
	{
	    return y * 	height / 480;
	}
	
	
	public void Draw() {
		// TODO Auto-generated method stub
		
//		synchronized (holder) {
			Canvas canvas = holder.lockCanvas();
			if(canvas != null)
			{canvas.drawBitmap(image_bg, null,all_rect,null);
			canvas.drawBitmap(image_time, null,time_rect, null);

			drawAnim(canvas);
			drawOperate(canvas);
			drawEquation(canvas);
			drawTime(canvas);
			
			if(!menu_clicked)
				canvas.drawBitmap(menu_btn_up, null, menu_rect, null);
			else
				canvas.drawBitmap(menu_btn_down, null, menu_rect, null);
			
			if(!back_clicked)
				canvas.drawBitmap(back_btn_up, null, back_rect, null);
			else
				canvas.drawBitmap(back_btn_down, null, back_rect, null);

			if(level != 30)
			{
				int pro = Share.getObject(context);
				if(pro > 20)
					canvas.drawBitmap(image_ocard1, null, ocard1_rect, null);
				if(pro % 10 == 2)
				 canvas.drawBitmap(image_ocard2, null, ocard2_rect, null);
			}
			
		    if(showDialog)
			   getDialog(canvas);
			
			holder.unlockCanvasAndPost(canvas);
			}
//		}
	}
	
	private void drawTime(Canvas canvas)
	{
		canvas.drawBitmap(image_nums[time/100], changeWidth(70), changeHeight(16), null);
		canvas.drawBitmap(image_nums[time%100/10], changeWidth(90), changeHeight(16), null);
		canvas.drawBitmap(image_nums[time%10], changeWidth(110), changeHeight(16), null);
	}
	
	private void getDialog(Canvas canvas)
	{  
		String temp = null;
		Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.plank_01);
		switch(dialog_type)
		{
		case Define.CHUSHU: 
			   temp = "除数不能为0！";
			   break;
		case Define.FU: 
			   temp = "出现负数！";
			   break;
		case Define.XIAOSHU: 
			   temp = "不能被整除！";
			   break;
		}
		if(dialog_type != Define.CARD1_DETAIL && dialog_type != Define.CARD2_DETAIL)
		{	
			canvas.drawBitmap(bitmap, null, this.all_rect ,null);
		
			canvas.drawText(temp, all_rect.width() / 3, all_rect.height()/ 2, paint);
		}
		else
		{
			if(dialog_type == Define.CARD1_DETAIL)
			{
				canvas.drawBitmap(image_ocard1_detail, null, this.all_rect ,null);
			}
			else if(dialog_type == Define.CARD2_DETAIL)
			{
				canvas.drawBitmap(image_ocard2_detail, null, this.all_rect ,null);
			}
		}
	}
	
	private void initImage()
	{
		image_bg = BitmapFactory.decodeResource(res, R.drawable.bg_game);
		menu_btn_down = BitmapFactory.decodeResource(res, R.drawable.btn_menu_down);
		menu_btn_up = BitmapFactory.decodeResource(res, R.drawable.btn_menu_up);
		back_btn_down = BitmapFactory.decodeResource(res, R.drawable.btn_exitgame_down);
		back_btn_up = BitmapFactory.decodeResource(res, R.drawable.btn_exitgame_up);
		image_time = BitmapFactory.decodeResource(res, R.drawable.time);
		image_nums = ImageUtil.getImages(R.drawable.num_gametime, 13);
		image_card_nums = ImageUtil.getImages(R.drawable.number03, 14);
		image_ocard1 = BitmapFactory.decodeResource(res, R.drawable.mini_card_word_01);
		image_ocard2 = BitmapFactory.decodeResource(res, R.drawable.mini_card_word_02);
		image_ocard1_detail = BitmapFactory.decodeResource(res, R.drawable.car_01);
		image_ocard2_detail = BitmapFactory.decodeResource(res, R.drawable.car_02);
	}
	
	public void ACountFinish()
	{
		state = 0;
		cards.removeElement(c2);
		
		switch(equation[1].type)
		{
		case ImageManager.ADD:
				c2.type = c1.type + c2.type;
				break;
		case ImageManager.DECREASE:
				c2.type = c1.type - c2.type;
			 	break;
		case ImageManager.MULTIPLY:
				c2.type = c1.type * c2.type;
				break;
		case ImageManager.DIVIDE:
				c2.type = c1.type / c2.type;
				break;
		}
		
		c2 = gl.getCardInfo(c2.type, c2.current);
		cards.removeElement(c1);
		cards.addElement(c2);
		Rect[] rects3 = {equal1_src,equal2_src,equal3_src,equal4_src,equal5_src};
		equation = gl.getGameEquation(rects3);
		Draw();
		Goon();
		if(cards.size() == 1)
		{  
			Stop();
			if(gl.check24((CardInfo)cards.elementAt(0)))
			{
			  if(level != 30)
				{
					int point = Share.getLevelScoreinfo(context, context.level);
					int cpoint = GameLogical.countPoint(context.level, time);
					int star = GameLogical.countStar(context.level, cpoint);
					
					if (point < cpoint) {
						Share.setLevelScoreinfo(context, context.level, cpoint);
						int old = Share.getLevelinfo(context, level);
							Share.setLevelinfo(context, context.level, 10 + star);
						int old_star = Share.getStars(context);
						if(old % 10 != 3)
						{
							old_star++;
							Share.setStars(context, old_star);
						}
					}
					
					int Object = gl.GenObject(star);
					Share.setObject(context, Object);
					
					if (context.level % 10 < 8) {
						int nextlevel = Share.getLevelinfo(context,
								context.level + 1);
						if (nextlevel < 10) {
							Share.setLevelinfo(context, context.level + 1, 10);
						}
					} else if (context.level % 10 == 8) {
						if (context.level / 10 != 2) {
							if(Share.getLevelinfo(context, 20) < 10)
								Share.setLevelinfo(context, 20, 10);
							Share.setLevel(context, 110);
						}
						else if (context.level / 10 == 2)
						{
							Share.setLevel(context, 111);
						}
					}
				}
			  else 
			  {
				  GameActivity.ctime = time;
				  int point = GameLogical.countRandomPoint(time);
				  GameActivity.cpoint += point;
				  
			  }
				Message message = new Message();
				message.what = ResultDialog.type_win;
				GameActivity.ctime = time;
				context.handler.sendMessage(message);
				
			}
			else
			{  
				if(level == 30)
				{  
				    int old_max = Share.getRandomLevel(context);
				    if(GameActivity.cpoint > old_max)
				    	Share.setRandomLevel(context, GameActivity.cpoint);
				}
				
				Message message = new Message();
				message.what = ResultDialog.type_lose;
				message.arg1 = -1;
				context.handler.sendMessage(message);
			}
		}
		else 
		{
			saveAProcess();
		}
		canClick = true;
	}
	
	
	int cardid;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		int x = (int) event.getX();
		int y = (int) event.getY();
		if(canClick)
		{
			Debug.e(tag,"x:" + x + ", y:" + y);
			if(!showDialog)
			{
			if (state != 1)
				for (int i = 0; i < cards.size(); i++) {
					CardInfo temp = (CardInfo) cards.elementAt(i);
					
					if (!temp.isClick && temp.current.contains(x, y)) {
						Debug.show("Current card type:", temp.type);
						if (state == 0) {
							cardid = i;
							
						}
						if(!temp.isClick)
							ready(temp);
					}
				}
			else if (state == 1)
				for (int i = 0; i < operates.length; i++) {
					if (i != operates.length - 1) {
						if (operates[i].pos.contains(x, y)) {

							ready(operates[i]);
						}
					}
				}
			
				if (operates[operates.length - 1].pos.contains(x, y)) {
					if (state > 0) {
					equation[state - 1] = gl.getSpaceNumOpeInfo(equation[state - 1].pos);
					state--;
					if(state == 0)
					{
						
						CardInfo temp = ((CardInfo)cards.elementAt(cardid));
						temp.isClick = false;
						cards.setElementAt(temp, cardid);
						cardid = -1;
					}
					}
					else if(state == 0)
					{
						Debug.e(tag, "==");
						returnAProcess();
						Rect[] rects3 = {equal1_src,equal2_src,equal3_src,equal4_src,equal5_src};
						equation = gl.getGameEquation(rects3);
					}
			}

			if (menu_rect.contains(x, y)) {
				 
				Debug.e(tag, "aa");
				menu_clicked = true;
				Draw();
				Stop();
				postDelayed(new Runnable(){

					public void run() {
						// TODO Auto-generated method stub
						menu_clicked = false;
						Draw();
						Message msg = new Message();
						msg.what = 3;
						msg.arg1 = -1;
						context.handler.sendMessage(msg);
					}
					
				}, 100);
				
			}

			if (back_rect.contains(x, y)) {
				
				Debug.e(tag, "aa");
				back_clicked = true;
				Draw();
				Stop();
				postDelayed(new Runnable(){

					public void run() {
						// TODO Auto-generated method stub
						back_clicked = false;
						Draw();
						Message msg = new Message();
						msg.what = -1;
						context.handler.sendMessage(msg);
					}
					
				}, 100);
			}
			
			if(Share.getObject(context) > 20 && ocard1_rect.contains(x, y))
			{
				Stop();
				showDialog = true;
				dialog_type = Define.CARD1_DETAIL;
			}
			
			if(Share.getObject(context)%10 == 2 && ocard2_rect.contains(x, y))
			{
				Stop();
				showDialog = true;
				dialog_type = Define.CARD2_DETAIL;
			}

		}
			else {
				if(dialog_type != Define.CARD1_DETAIL && dialog_type != Define.CARD2_DETAIL)
				{
					
					showDialog = false;
					Goon();
				}
				else
				{
					if(ocard_cancel_rect.contains(x, y))
					{
						showDialog = false;
						Goon();
					}
					else if(ocard_use_rect.contains(x, y))
					{ 
						showDialog = false;
						if(dialog_type == Define.CARD1_DETAIL)
						{
							time += 30;
							int object = Share.getObject(context);
							object -= 10;
							Share.setObject(context, object);
							Goon();
						}
						else if(dialog_type == Define.CARD2_DETAIL)
						{
							  int [][] temp = gl.Super(level);
							  
							  for(int i = 0 ; i < temp.length ; i++)
							  {
								  for(int j = 0 ; j < temp[i].length ; j++)
								  {
									  System.out.print(temp[i][j] + " ");
								  }
								  System.out.println();
							  }
							  process_index = 0;
							  returnAProcess();
							  Rect[] rects3 = {equal1_src,equal2_src,equal3_src,equal4_src,equal5_src};
							  equation = gl.getGameEquation(rects3);
							  new SuperCardThread(temp).start();
							  int object = Share.getObject(context);
							  object -= 1;
							  Share.setObject(context, object);
							  
						}
						
						
					}
				}
				
			}
			Draw();
		}
		return super.onTouchEvent(event);
	}

	private void ready(CardInfo card)
	{
		
		switch(state)
		{
		case 0:  
			    c1 = card;
			    state = 1;
			    card.isClick = true;
			    equation[0] = gl.getNumOpeInfo2(card.type, equation[0].pos);
			    Draw();
			    break;
		case 1: 
				state = 2;
				equation[1] = gl.getNumOpeInfo(((NumOpeInfo)card).type, equation[1].pos);
				Draw();
				break;
		case 2:
			 	c2 = card;
			 	equation[2] = gl.getNumOpeInfo2(card.type, equation[2].pos);
			 	int type = GameLogical.checkforType(c1.current, c2.current);
			 	
			 	switch(equation[1].type)
				{
				case ImageManager.ADD:
						equation[4].type = c1.type + c2.type;
						break;
				case ImageManager.DECREASE:
						if(gl.canGoon(c1,c2,ImageManager.DECREASE) == Define.OK)
							equation[4].type = c1.type - c2.type;
						else
						{
							showDialog = true;
							dialog_type = gl.canGoon(c1,c2,ImageManager.DECREASE);
						}
					 	break;
				case ImageManager.MULTIPLY:
						equation[4].type = c1.type * c2.type;
						break;
				case ImageManager.DIVIDE:
						if(gl.canGoon(c1,c2,ImageManager.DIVIDE) == Define.OK)
							equation[4].type = c1.type / c2.type;
						else
						{
							showDialog = true;
							dialog_type = gl.canGoon(c1,c2,ImageManager.DIVIDE);
						}
						break;
				}
			 	Debug.show(tag, "showDialog: " + showDialog);
			 	if(!showDialog)
			 	{	
			 		canClick = false;
			 		equation[4] = gl.getNumOpeInfo2(equation[4].type, equation[4].pos);
				 	ar.setCards(c1, c2, type);
				 	//ar.setResult(card3);
				 	Stop();
				 	ar.runAnim();
				 	Debug.show(tag, "start anim? : " + true);
				 	//ACountFinish();
				 	
			 	}
			 	else
			 	{
			 		Rect[] rects3 = {equal1_src,equal2_src,equal3_src,equal4_src,equal5_src};
					equation = gl.getGameEquation(rects3);
					state = 0;
					Stop();
					c1.isClick = false;
					c2.isClick = false;
			 	}
				break;
		}
	}
	
	private void drawOperate(Canvas g)
	{
		for(int i = 0 ; i < operates.length ; i++)
		{
			g.drawBitmap(operates[i].image, operates[i].pos.left
					, operates[i].pos.top, null);
		}
	}
	
	private void drawEquation(Canvas g)
	{
		for(int i = 0 ; i < equation.length ; i++)
		{
			g.drawBitmap(equation[i].image, equation[i].pos.left
					, equation[i].pos.top, null);
			if(equation[i].isNum)
			{
//				g.drawString(equation[i].type + "",    + 
//						equation[i].pos.left + 10, equation[i].pos.top + 10, 20);
				for(int j = 0 ; j < equation[i].num.length ; j++)
					g.drawBitmap(equation[i].num[j], equation[i].pos.left + equation[i].pos.width() / 5 + j * 10 
							, equation[i].pos.top + equation[i].pos.height() / 4, null);
			}
			else
			{ 
				if(equation[i].operate != null)
					g.drawBitmap(equation[i].operate,  equation[i].pos.left + equation[i].pos.width() / 3 
							, equation[i].pos.top + equation[i].pos.height() / 4, null);
			}
		}
	}
	
	private void drawCardNum(Canvas g,int num,int left,int top)
	{
		int index0 = num / 1000;
		int index1 = (num % 1000) / 100;
		int index2 = (num % 100) / 10;
		int index3 = (num % 100) % 10;
		Bitmap[] result = null;
		
		if(num >= 1000)
		{
			result = new Bitmap[]{image_card_nums[index0],image_card_nums[index1],image_card_nums[index2],image_card_nums[index3]};
		}
		
		else if(num >= 100)
		{
			result = new Bitmap[]{image_card_nums[index1],image_card_nums[index2],image_card_nums[index3]};
		}
		
		else if(num >= 10)
		{
			result = new Bitmap[]{image_card_nums[index2],image_card_nums[index3]};
		}
		
		else 
		{
			result = new Bitmap[]{image_card_nums[index3]};
		}
		
		for(int f = 0 ; f < result.length ; f++)
		{
			g.drawBitmap(result[f], left + 10 + 15 * f
				, top + 15, null);
		}
	}
	
	private void drawAnim(Canvas g)
		{
		synchronized(cards){
		 if(cards != null)
		 {	for(int i = 0 ; i < cards.size() ; i++)
			{
//				Debug.show("card: ", i);
			 	CardInfo temp = (CardInfo)cards.elementAt(i);
				
			 	if(!temp.isClick)
				{
					g.drawBitmap(temp.card, temp.current.left, temp.current.top, null);
//					g.drawText("" + temp.type, temp.current.left + 10
//							, temp.current.top + 30, paint);
//					}
			 	  drawCardNum(g,temp.type,temp.current.left
							 , temp.current.top + 10);
				}
			}
			
			for(int i = 0 ; i < cards.size() ; i++)
			{
				CardInfo temp = (CardInfo)cards.elementAt(i);
				if(temp.isClick)
				{
					g.drawBitmap(temp.card, temp.current.left, temp.current.top, null);
//					g.drawText("" + temp.type, temp.current.left + 10
//							, temp.current.top + 30, paint);
					 drawCardNum(g,temp.type,temp.current.left
							 , temp.current.top + 10);
				}
			}
		 }
		}
	}
	
	public void Stop()
	{  
		isStop = true;
	}
	
	public void Goon()
	{  
		Stop();
		isStop = false;
		if(!showDialog && canClick && !showCard)
		{	gt = new GameThread();
			gt.start();
		}
	}
	
	boolean isStop = false;
	public class GameThread extends Thread
	{
        public GameThread()
        {
        	isStop = false;
        }
      
		@Override
		public void run() {
			// TODO Auto-generated method stub
		 
			while(!isStop && time > 0)
			{
				time--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Draw();
				if(time == 0)
				{
					isStop = true;
					Message message = new Message();
					message.arg1 = -1;
					message.what = ResultDialog.type_lose2;
					context.handler.sendMessage(message);
				}
			}
		
		}
		
	}

	
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
		Draw();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	
	private int index_c1 = -1;
	private int findCard(int type)
	{
		int i;
		Debug.show("the card type: ", type);
		for(i = 0 ; i < cards.size() ; i++)
		{
			CardInfo card = (CardInfo)cards.elementAt(i);
			Debug.show("the current card type: ", card.type);
			if(card.type == type)
			{
				if(index_c1 == -1)
				{
					index_c1 = i;
					break;
				}
				else if(i != index_c1)
				{
					break;
				}
			}
		}
		Debug.show("the card index:", "" + i);
		return i;
	}
	
	private int sol_index = 0;
	private void SuperCard(int[][] solution)
	{   
        Debug.show(tag, "solution.length: " + solution.length);
		if (sol_index < solution.length - 1) {
			CardInfo card1 = (CardInfo) cards
					.elementAt(findCard(solution[sol_index][0]));
			CardInfo card2 = (CardInfo) cards
					.elementAt(findCard(solution[sol_index][1]));
			ready(card1);
			NumOpeInfo operate = new NumOpeInfo();
			int ope = solution[solution.length - 1][sol_index];
			operate.type = ope;
			ready(operate);
			
			ready(card2);
			sol_index++;
			index_c1 = -1;
		}

	}
	
	public class SuperCardThread extends Thread
	{  
		private boolean isStop = false;
		private int[][] content = null;
		
		public SuperCardThread(int[][] content)
		{
			this.content = content;
		}
		
		public void run()
		{    
			while(!isStop)
			{
				Stop();
				if(canClick)
				{
					
					if(sol_index == content.length - 1)
						{ 
							isStop = false;
							break;
						}
					else
					{
						SuperCard(content);
					}
					
				}
			}
		}
	}
}
