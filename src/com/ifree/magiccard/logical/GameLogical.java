package com.ifree.magiccard.logical;

import java.util.Random;
import java.util.Vector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.ifree.magiccard.data.CardInfo;
import com.ifree.magiccard.data.Define;
import com.ifree.magiccard.data.NumOpeInfo;
import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.data.SubjectInfo;
import com.ifree.magiccard.ui.MainActivity;
import com.ifree.magiccard.util.Debug;



public class GameLogical {
   
	//DataManager dm = null;
	Context context = null;
	public static final int TYPE_lr1 = 0;
	public static final int TYPE_lr2 = 1;
	public static final int TYPE_ud1 = 2;
	public static final int TYPE_ud2 = 3;
	public static final int TYPE_ca1 = 4;
	public static final int TYPE_ca2 = 5;
	public static final int TYPE_ca3 = 6;
	public static final int TYPE_ca4 = 7;
	
	Random ran = null;
	static int level_pos = 0;
	public GameLogical(Context context)
	{
		ran = new Random();
		this.context = context;
		
	}

	private static int get3Stars()
	{
		return Share.getStars(MainActivity.context);
	}
	
	public int canGoon(CardInfo c1,CardInfo c2,int type)
	{
		if(type == ImageManager.DECREASE && c1.type < c2.type)
		{
			return Define.FU;
		}
		
		if(type == ImageManager.DIVIDE && c2.type == 0)
		{
			return Define.CHUSHU;
		}
		
		if(type == ImageManager.DIVIDE && c1.type % c2.type != 0)
		{
			return Define.XIAOSHU;
		}
		
		
		return Define.OK;
	}
	
	public Vector getNewCards(int level,Rect[] rects)
	{
		Vector cards = null;
		cards = new Vector();
		int[][] level_subjects = null;
		
		if(level / 10 == 1)
		{
			level_subjects = SubjectInfo.level1[level % 10];
		}
		else
		{
			level_subjects = SubjectInfo.level2[level % 10];
		}
		int index = ran.nextInt(13000) % level_subjects.length;
		level_pos = index;
		for(int i = 0 ; i < level_subjects[index].length ; i++)
		{
			int type = level_subjects[index][i];
			Debug.show("Card type: ", type);
			CardInfo card = new CardInfo(rects[i],ImageManager.getCardImage(-1));
			card.type = type;
			cards.addElement(card);
		}
		Debug.show("GetNewCards:", cards.size());
		return cards;
	}
	
	private int[] randomArray(int[] temp)
	{
		Random rand = new Random();
		int c = 0;
		
		for(int i = 0 ; i < temp.length ; i++)
		{
			int ix = rand.nextInt(temp.length);
			c = temp[i];
			temp[i] = temp[ix];
			temp[ix] = c;
		}
		
		return temp;
	}
	
	public Vector getNewCards2(Rect[] rects)
	{
		Vector cards = null;
		cards = new Vector();
		int[][] level_subjects = null;
		int level = new Random().nextInt(13000) % 9;
		
		level_subjects = SubjectInfo.level2[level];
		
		int index = ran.nextInt(13000) % level_subjects.length;
		
		int[] temp = level_subjects[index];
		
		temp = randomArray(temp);
		
		for(int i = 0 ; i < temp.length ; i++)
		{
			int type = temp[i];
			Debug.show("Card type: ", type);
			CardInfo card = new CardInfo(rects[i],ImageManager.getCardImage(-1));
			card.type = type;
			cards.addElement(card);
		}
		Debug.show("GetNewCards:", cards.size());
		return cards;
	}
	
	public NumOpeInfo[] getOperate(Rect[] rects)
	{
		NumOpeInfo[] operates = null;
		if(rects != null)
		{
				operates = new NumOpeInfo[rects.length];
				for(int i = 0 ; i < operates.length ; i++)
				{
					operates[i] = new NumOpeInfo();
					operates[i].type = 25 + i;
					operates[i].pos = rects[i];
					operates[i].isNum = false;
					operates[i].image = ImageManager.getNumsOperateImage(operates[i].type);
				}
		}
		return operates;
	}
	
	public NumOpeInfo[] getGameEquation(Rect[] rects)
	{
		NumOpeInfo[] operates = null;
		if(rects != null)
		{
				operates = new NumOpeInfo[rects.length];
				for(int i = 0 ; i < operates.length ; i++)
				{
					operates[i] = new NumOpeInfo();
					
				    if(i == 3)
				    {
				    	operates[i].type = 31;
				    	operates[i].isNum = false;
				    	operates[i].operate = ImageManager.getGameOperation(ImageManager.EQUAL);
				    }
				    else
				    {
				    	operates[i].type = 31;
				    }
				    operates[i].pos = rects[i];
				    
					operates[i].image = ImageManager.getNumsOperateImage(operates[i].type);
				}
		}
		return operates;
	}
	
	public  CardInfo getCardInfo(int type,Rect pos)
	{
		CardInfo card = null;
		Bitmap temp = ImageManager.getCardImage(-1);
		card = new CardInfo(pos,temp);
		card.type = type;
		return card;
	}
	
	public  NumOpeInfo getSpaceNumOpeInfo(Rect pos)
	{
		NumOpeInfo nums = new NumOpeInfo();
		nums.type = ImageManager.SPACE;
		nums.pos = pos;
		nums.image = ImageManager.getNumsOperateImage(nums.type);
		return nums;
	}
	
	public  NumOpeInfo getNumOpeInfo2(int type,Rect pos)
	{
		NumOpeInfo nums = new NumOpeInfo();
		nums.type = type;
		nums.pos = pos;
		nums.isNum = true;
		nums.image = ImageManager.getNumsOperateImage(ImageManager.SPACE);
		nums.num = ImageManager.getGameOperateNumImage(type);
		return nums;
	}
	
	public  NumOpeInfo getNumOpeInfo(int type,Rect pos)
	{
		NumOpeInfo nums = new NumOpeInfo();
		nums.type = type;
		nums.pos = pos;
		nums.isNum = false;
		nums.image = ImageManager.getNumsOperateImage(ImageManager.SPACE);
		nums.operate = ImageManager.getGameOperation(type);
		return nums;
	}
	
	public static  int checkforType(Rect c1,Rect c2)
	{
		if(c1.left > c2.left)
		{
			if(c1.top > c2.top)
			{
				return TYPE_ca2;
			}
			else if(c1.top < c2.top)
			{
				return TYPE_ca3;
			}
			else
			{
				return TYPE_lr2;
			}
		}
		else if(c1.left < c2.left)
		{
			if(c1.top > c2.top)
			{
				return TYPE_ca4;
			}
			else if(c1.top < c2.top)
			{
				return TYPE_ca1;
			}
			else
			{
				return TYPE_lr1;
			}
		}
		else
		{
			if(c1.top > c2.top)
			{
				return TYPE_ud1;
			}
			else if(c1.top < c2.top)
			{
				return TYPE_ud2;
			}
			else
			{
				return -1;
			}
		}
	}
	
	public static int getOpenBoxs()
	{
		int num = 0;
		int stars = get3Stars();
		if(stars >= 8)
		{
			num = 5;
		}
		else if(stars >= 6)
		{
			num = 4;
		}
		else if(stars >= 4)
		{
			num = 3;
		}
		else if(stars >= 2)
		{
			num = 2;
		}
		else if(stars >= 1)
		{
			num = 1;
		}
		return num;
	}
//	public int[] getLevel()
//	{
//		init();
//		return data.level;
//	}
//	
//	public int[] getLevels(int type)
//	{
//		init();
//		return data.levels[type];
//	}
//	
	
	public int getLevel_time(int level)
	{
		if(level == 30)
		{
			return 300;
		}
		else
		{
			return SubjectInfo.level_time[level/10 - 1][level % 10];
		}
	}
	
	public boolean isLevelLock(int level)
	{
	
		return true;
	}
	
	public boolean check24(CardInfo card)
	{
		if(card.type == 24)
		{
			return true;
		}
		return false;
	}
	
	
	public static int countPoint(int level,int ctime)
	{
		
		int T = SubjectInfo.level_time[level/10 - 1 ][level%10];
		float C = SubjectInfo.level_hard[level/10 - 1][level%10];
		
		return (int)(1000 * ctime * C / T);
	}
	
	public static int countStar(int level,int point)
	{
		float C = SubjectInfo.level_hard[level/10 - 1][level%10];
		Debug.e("P", "point:" + point);
		Debug.e("P1", "" + 0.8f * C * 1000);
		Debug.e("P2", "" + C * 1000);
		
		if(point >= 0.8f * C * 1000 && point <= C * 1000)
		{
			return Define.THREE_STAR;
		}
		
		else if(point >= 0.5f * C * 1000 && point < 0.8f* C * 1000)
		{
			return Define.TWO_STAR;
		}
		
		else
		{
			return Define.ONE_STAR;
		}
	}
	
	public static int countRandomPoint(int time)
	{ 
		int C = 3;
		int T = 300;
		
		int randomPoint = 1000 * time * 3 / T;
		
		return randomPoint;
	}
	
	public int GenObject(int star)
	{
		int Object = Share.getObject(MainActivity.context);
		Random rand = new Random();
		if(star == 3)
		{
			int temp = rand.nextInt() % 10;
			Debug.show("temp:", temp);
			Debug.show("Object:", Object);
			if(temp == 1 || temp == 3 || temp == 5)
			{
				
				if(Object % 10 == 2)
				{
					
				}
				else
				{
					Object ++;
				}
			}
			
			temp = rand.nextInt() % 10;
			if(temp == 0 || temp == 1 || temp == 3 || temp == 5 
						|| temp == 7 || temp == 9)
			{
				if(Object > 20)
				{
					
				}
				else
				{
					Object += 10;
				}
				
			}
		}
		else if(star == 2)
		{
			int temp = rand.nextInt() % 10;
			if(temp == 1)
			{
				if(Object % 10 == 2)
				{
					
				}
				else
				{
					Object ++;
				}
			}
			
			temp = rand.nextInt() % 10;
			if( temp == 3 || temp == 5 
						|| temp == 7 )
			{
				
				
				if(Object > 20)
				{
					
				}
				else
				{
					Object += 10;
				}
			}
		}
		Debug.show("Object: ", Object);
		return Object;
	}
	
	public int[][] Super(int level)
	{
		if(level / 10  == 1)
		{
			return SubjectInfo.solution_level1[level%10][level_pos];
		}
		else if(level / 10 == 2)
		{
			return SubjectInfo.solution_level2[level%10][level_pos];
		}
		
		return null;
		
	}
}
