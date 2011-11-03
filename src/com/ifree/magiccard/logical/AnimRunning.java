package com.ifree.magiccard.logical;

import android.view.View;

import com.ifree.magiccard.data.CardInfo;
import com.ifree.magiccard.util.Debug;
import com.ifree.magiccard.view.GameView;



public class AnimRunning {
   
	private GameView canvas;
	private AnimRun run;
	private int type;
	private int limit = 110;
	private CardInfo card1 = null;
	private CardInfo card2 = null;
	private CardInfo result = null;
	private int pos = 0;
	private GameView g;
	
//	private int x1 = 20;
//	private int x2 = 130;
//	private int y1 = 20;
//	private int y2 = 130;
	
	public AnimRunning(GameView canvas,GameView g)
	{
		this.canvas = canvas;
		run = null;
		pos = 0;
		this.g = g;
	}
	
	public void setCards(CardInfo card1,CardInfo card2,int type)
	{
		this.card1 = card1;
		this.card2 = card2;
		this.type = type;
	}
	
	public void setResult(CardInfo card)
	{
		this.result = card;
	}
	
	public void runAnim()
	{
		 pos = 0;
		 run = new AnimRun();
		 run.start();
		 Debug.e("Anim start: ", "true");
	}
	
	private void drawAnim()
	{  
		
		pos += 3;
//		Debug.e("ar:", "pos=" + pos);
		switch(type)
		{
		case GameLogical.TYPE_ca1:
//			g.drawImage(card2.card, card2.current.left, card2.current.top, Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card1.card, card1.current.left + pos, card1.current.top + pos, Graphics.LEFT | Graphics.TOP);
			card1.current.left = card1.old.left + pos;
			card1.current.top = card1.old.top + pos;
			
			break;
		case GameLogical.TYPE_ca2:
//			g.drawImage(card1.card, card1.current.left, card1.current.top, Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card2.card, card2.current.left - pos, card2.current.top  - pos, Graphics.LEFT | Graphics.TOP);
			card1.current.left = card1.old.left - pos;
			card1.current.top = card1.old.top - pos;
			break;
		case GameLogical.TYPE_ca3:
//			g.drawImage(card1.card, card1.current.left, card1.current.top, Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card2.card, card2.current.left - pos , card2.current.top + pos, Graphics.LEFT | Graphics.TOP);
			card1.current.left = card1.old.left - pos;
			card1.current.top = card1.old.top + pos;
			break;
		case GameLogical.TYPE_ca4:
//			g.drawImage(card2.card, card2.current.left, card2.current.top , Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card1.card, card1.current.left + pos, card1.current.top - pos, Graphics.LEFT | Graphics.TOP);
			card1.current.left = card1.old.left + pos;
			card1.current.top = card1.old.top - pos;
			break;
		case GameLogical.TYPE_lr1:
//			g.drawImage(card1.card, card1.current.left, card1.current.top, Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card2.card, card2.current.left + pos , card2.current.top , Graphics.LEFT | Graphics.TOP);
			card1.current.left = card1.old.left + pos;
			break;
		case GameLogical.TYPE_lr2:
//			g.drawImage(card1.card, card1.current.left, card1.current.top , Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card2.card, card2.current.left - pos, card2.current.top, Graphics.LEFT | Graphics.TOP);
			card1.current.left = card1.old.left - pos;
			break;
		case GameLogical.TYPE_ud1:
//			g.drawImage(card1.card, card1.current.left, card1.current.top , Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card2.card, card2.current.left, card2.current.top  +  pos, Graphics.LEFT | Graphics.TOP);
			card1.current.top = card1.old.top - pos;
			break;
		case GameLogical.TYPE_ud2:
//			g.drawImage(card1.card, card1.current.left, card1.current.top , Graphics.LEFT | Graphics.TOP);
//			g.drawImage(card2.card, card2.current.left, card2.current.top  -  pos, Graphics.LEFT | Graphics.TOP);
			card1.current.top = card1.old.top + pos;
			break;
		}
//		if(isOver)
//		{
////			g.drawImage(result.card, result.current.left, result.current.top, Graphics.LEFT | Graphics.TOP);
//		
//		}
		canvas.Draw();
	}
	
	private void AnimOver()
	{
		run = null;
	}
	
	boolean isOver = false;
	private class AnimRun extends Thread
	{
		AnimRun()
		{
			isOver = false;
		}
		
		public void run()
		{
			while(!isOver)
			{
				drawAnim();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(pos >= limit)
				{
					isOver = true;
					
					pos = 0;
					//card1.reset();
					g.ACountFinish();
					
				}
			}
			AnimOver();
		}
	}
	
	
	
}
