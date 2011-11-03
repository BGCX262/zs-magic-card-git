package com.ifree.magiccard.logical;

import android.graphics.Bitmap;

import com.ifree.magiccard.main.R;
import com.ifree.magiccard.util.ImageUtil;



public class ImageManager {
   
	public static final int ADD = 25;
	public static final int DECREASE = 26;
	public static final int MULTIPLY = 27;
	public static final int DIVIDE = 28;
	public static final int EQUAL = 30;
	public static final int RETURN = 29;
	public static final int SPACE = 31;
	
	public static Bitmap getCardImage(int type)
	{
		switch(type)
		{
		case -1:
			return ImageUtil.getImage(R.drawable.card);
		}
		
		return null;
	}
	
	public static final int NUM_HIGHSCORE = 0;
	public static final int NUM_CURRENTSCORE = 1;
	
	public static Bitmap[] getNumsImage(int type , int num)
	{
		Bitmap[] result = null;
//		int index0 = num / 1000;
//		int index1 = (num % 1000) / 100;
//		int index2 = (num % 100) / 10;
//		int index3 = (num % 100) % 10;
//		switch(type)
//		{
//		case NUM_CURRENTSCORE:
//			Bitmap[] temp = ImageUtil.getImages("result/number01.png", 15);
//			result = new Bitmap[]{temp[index0],temp[index1],temp[index2],temp[index3]};
//			break;
//		case NUM_HIGHSCORE:
//			temp = ImageUtil.getImages("result/number02.png", 15);
//			result = new Bitmap[]{temp[index0],temp[index1],temp[index2],temp[index3]};
//			break;
//		}
		return result;
	}
	
	public static Bitmap[] getGameOperateNumImage(int num)
	{
		Bitmap[] result = null;
		Bitmap[] nums = ImageUtil.getImages(R.drawable.num_game, 10);
		if(num >= 100)
		{
			result = new Bitmap[]{nums[num / 100],nums[(num % 100) / 10],nums[num % 10]};
		}
		
		else if(num >= 10)
		{
		    result = new Bitmap[]{nums[num / 10],nums[num % 10]};	
		}
		else
		{
			result = new Bitmap[]{nums[num]};
		}
			
		return result;
	}
	
	
	public static Bitmap getNumsOperateImage(int type)
	{ 
		switch(type)
		{
		case 0: 
			
		case 1:
			
		case 2:
			
		case 3:
			
		case 4:
			
		case 5:
			
		case 6:
			
		case 7:
			
		case 8:
			
		case 9:
			
		case 10:
			
		case 11:
			
		case 12:
			
		case 13:
			
		case 14:
			
		case 15:
			
		case 16:
			
		case 17:
			
		case 18:
			
		case 19:
			
		case 20:
			
		case 21:
			
		case 22:
			
		case 23:
			
		case 24:
			break;
		case ADD:
			return ImageUtil.getImage(R.drawable.add);
		case DECREASE:
			return ImageUtil.getImage(R.drawable.decrease);
		case MULTIPLY:
			return ImageUtil.getImage(R.drawable.multiply);
		case DIVIDE:
			return ImageUtil.getImage(R.drawable.divide);
		case EQUAL:
			return null;
		case RETURN:
			return ImageUtil.getImage(R.drawable.backspace);
		case SPACE:
			return ImageUtil.getImage(R.drawable.space);
		}
		return null;
	}
	
	public static final int TOTAL_BG = 100;
	public static final int TOTAL_NEXT = 101;
	public static final int TOTAL_BACK = 102;
	public static final int TOTAL_CLOSE = 103;
	
	public static Bitmap getToatlImages(int type)
	{
//		String path = null;
//		switch(type)
//		{
//		case TOTAL_BG:
//			path = "share/bg_second.png";
//			break;
//		case TOTAL_NEXT:
//			path = "share/next.png";
//			break;
//		case TOTAL_BACK:
//			path = "share/goback.png";
//			break;
//		case TOTAL_CLOSE:
//			path = "share/close.png";
//			break;
//		
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	
	public static final int INPUT_KEYBOARD = 1;
	public static final int INPUT_LEFT = 2;
	public static final int INPUT_RIGHT = 3;
	
	public static Bitmap getInputImages(int type)
	{
		String path = null;
//		switch(type)
//		{
//		case INPUT_KEYBOARD:
//			path = "input/keyboard.png";
//			break;
//			
//		case INPUT_LEFT:
//			path = "input/setting_back.png";
//			break;
//			
//		case INPUT_RIGHT:
//			path = "input/setting_sure.png";
//			break;
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int ABOUT_BG = 1;
	public static final int ABOUT_BG2 = 2;
	
	public static Bitmap getAboutImages(int type)
	{
//		String path = null;
//		switch(type)
//		{
//		case ABOUT_BG:
//			path = "about/about_01.png";
//			break;
//		case ABOUT_BG2:
//			path = "about/about_02.png";
//			break;
//		}
//		
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int HELP_BG = 1;
	public static final int HELP_BG2 = 2;
	
	public static Bitmap getHelpImages(int type)
	{
//		String path = null;
//		switch(type)
//		{
//		case HELP_BG:
//			path = "help/help1.png";
//			break;
//		case HELP_BG2:
//			path = "help/help2.png";
//			break;
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int KNOWLEGE_BG = 0;
	public static final int KBOX_1 = 1;
	public static final int KBOX_2 = 2;
	public static final int KBOX_3 = 3;
	public static final int KBOX_4 = 4;
	public static final int KBOX_5 = 5;
	public static final int KBOX_LOCK = 6;
	public static final int KBOX_CHOOSE = 13;
	public static final int KBOX_1_DETAIL = 7;
	public static final int KBOX_1_DETAIL2 = 12;
	public static final int KBOX_2_DETAIL = 8;
	public static final int KBOX_3_DETAIL = 9;
	public static final int KBOX_4_DETAIL = 10;
	public static final int KBOX_5_DETAIL = 11;
	
	public static Bitmap getKnowlegeImages(int type)
	{
//		String path = null;
//		switch(type)
//		{
//		case KNOWLEGE_BG:
//			path = "knowlege/bg_knowledge_box.png";
//			break;
//		case KBOX_1:
//			path = "knowlege/knowledge_box_01.png";
//			break;
//		case KBOX_2:
//			path = "knowlege/knowledge_box_02.png";
//			break;
//		case KBOX_3:
//			path = "knowlege/knowledge_box_03.png";
//			break;
//		case KBOX_4:
//			path = "knowlege/knowledge_box_04.png";
//			break;
//		case KBOX_5:
//			path = "knowlege/knowledge_box_05.png";
//			break;
//		case KBOX_1_DETAIL:
//			path = "knowlege/box_details01_1.png";
//			break;
//		case KBOX_1_DETAIL2:
//			path = "knowlege/box_details01_2.png";
//			break;
//		case KBOX_2_DETAIL:
//			path = "knowlege/box_details02.png";
//			break;
//		case KBOX_3_DETAIL:
//			path = "knowlege/box_details03.png";
//			break;
//		case KBOX_4_DETAIL:
//			path = "knowlege/box_details04.png";
//			break;
//		case KBOX_5_DETAIL:
//			path = "knowlege/box_details05.png";
//			break;
//		case KBOX_LOCK:
//			path = "knowlege/lock_knowledge_box.png";
//			break;
//		case KBOX_CHOOSE:
//			path = "knowlege/knowledge_box_choose.png";
//			break;
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int DIALOG_EXIT1 = 0;
	public static final int DIALOG_EXIT2 = 1;
	public static final int DIALOG_RESET = 2;
	
	public static Bitmap getDialog(int type)
	{
//		String path = null;
//		switch(type)
//		{
//			case DIALOG_EXIT1:
//				path = "dialog/menu_exit_01.png";
//				break;
//			case DIALOG_EXIT2:
//				path = "dialog/menu_exit_02.png";
//				break;
//			case DIALOG_RESET:
//				path = "dialog/startpage_newgame.png";
//				break;
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int LEVEL_LEVELBG = 0;
	public static final int LEVEL_LEVELBG2 = 1;
	public static final int LEVEL_LEVELSELECT = 2;
	public static final int LEVEL_LEVELLOCK = 3;
	public static final int LEVEL_LEVELSBG = 4;
	public static final int LEVEL_LEVELSTAR = 5;
	public static final int LEVEL_LEVELSTAR2 = 6;
	public static final int LEVEL_LEVELSTAR3 = 7;
	public static final int LEVEL_LEVELSLOCK = 8;
	public static final int LEVEL_LEVELSSELECT = 9;
	public static final int LEVEL_LEVELPT = 10;
	public static final int LEVEL_LEVELST = 11;
	
	public static Bitmap getLevelImage(int type)
	{
//		String path = null;
//		switch(type)
//		{
//			case LEVEL_LEVELBG2:
//				path = "level/bg_chooselevel_02.png";
//				break;
//			case LEVEL_LEVELBG:
//				path = "level/chooselevel.png";
//				break;
//			case LEVEL_LEVELLOCK:
//				path = "level/btn_chooselevel_lvlock.png";
//				break;
//			case LEVEL_LEVELSLOCK:
//				path = "level/btn_chooselevel_lv_lock.png";
//				break;
//			case LEVEL_LEVELSELECT:
//				path = "level/btn_chooselevel_choose01.png";
//				break;
//			case LEVEL_LEVELSBG:
//				path = "level/btn_chooselevel_lv_down.png";
//				break;
//			case LEVEL_LEVELSTAR:
//				path = "level/lv_satr01.png";
//				break;
//			case LEVEL_LEVELSTAR2:
//				path = "level/lv_satr02.png";
//				break;
//			case LEVEL_LEVELSTAR3:
//				path = "level/lv_satr03.png";
//				break;
//			case LEVEL_LEVELSSELECT:
//				path = "level/btn_chooselevel_choose02.png";
//				break;
//			case LEVEL_LEVELPT:
//				path = "level/chooselevel_lv_01.png";
//				break;
//			case LEVEL_LEVELST:
//				path = "level/chooselevel_lv_02.png";
//				break;
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int GAME_BG = 0;
	public static final int GAME_CARDBG = 1;
	public static final int GAME_SELECT_CARD = 2;
	public static final int GAME_SELECT_OPE = 3;
	public static Bitmap getGameImages(int type)
	{
//		String path = null;
//		switch(type)
//		{
//			case GAME_BG:
//				path = "game/bg_game.png";
//				break;
//			case GAME_CARDBG:
//				path = "game/card/card.png";
//				break;
//			case GAME_SELECT_CARD:
//				path = "game/choose_card.png";
//				break;
//			case GAME_SELECT_OPE:
//				path = "game/operate_choose.png";
//				break;
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int SETTING_BG = 0;
	public static final int SETTING_SELECT = 1;
	public static final int SETTING_MUSICON = 2;
	public static final int SETTING_MUSICOFF = 3;
	public static final int SETTING_INPUTNUM = 4;
	public static final int SETTING_BG2 = 5;
	
	public static Bitmap getSettingImage(int type)
	{
//		String path = null;
//		switch(type)
//		{
//			case SETTING_BG:
//				path = "Setting/bg_setting.png";
//				break;
//			case SETTING_BG2:
//				path = "Setting/bg_setting2.png";
//				break;
//			case SETTING_SELECT:
//				path = "Setting/choose.png";
//				break;
//			case SETTING_MUSICON:
//				path = "Setting/music_on.png";
//				break;
//			case SETTING_MUSICOFF:
//				path = "Setting/music_off.png";
//				break;
//			case SETTING_INPUTNUM:
//				path = "Setting/textinput_01.png";
//				break;
//				
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static final int RESULT_BG = 0;
	public static final int RESULT_BG2 = 1;
	public static final int RESULT_BG3 = 2;
	public static final int RESULT_SELECT = 3;
	public static final int RESULT_BOXTIP = 4;
	public static final int RESULT_STAR1 = 5;
	public static final int RESULT_STAR2 = 6;
	public static final int RESULT_STAR3 = 7;
	public static final int RESULT_STAR0 = 8;
	
	public static Bitmap getResultImages(int type)
	{
//		String path = null;
//		switch(type)
//		{
//			case RESULT_BG:
//				path = "result/showscore_lose.png";
//				break;
//			case RESULT_BG2:
//				path = "result/showscore_win.png";
//				break;
//			case RESULT_BG3:
//				path = "result/showscore_win_highscore.png";
//				break;
//			case RESULT_SELECT:
//				path = "result/result_choose.png";
//				break;
//			case RESULT_BOXTIP:
//				path = "result/btn_box_info.png";
//				break;
//			case RESULT_STAR1:
//				path = "result/lv_satr1.png";
//				break;
//			case RESULT_STAR2:
//				path = "result/lv_satr2.png";
//				break;
//			case RESULT_STAR3:
//				path = "result/lv_satr3.png";
//				break;
//			case RESULT_STAR0:
//				path = "result/lv_satr0.png";
//				break;
//			
//				
//		}
//		if(path != null)
//		{
//			return ImageUtil.getImage(path);
//		}
		return null;
	}
	
	public static Bitmap getGameOperation(int type)
	{
		String path = null;
		Bitmap[] operates = ImageUtil.getImages(R.drawable.num_operator, 15);
		switch(type)
		{
			case ADD:
				return operates[0];
			case DECREASE:
				return operates[1];
			case MULTIPLY:
				return operates[2];
			case DIVIDE:
				return operates[3];
			case EQUAL:
				return operates[4];
		}
		return null;
		
	}
}
