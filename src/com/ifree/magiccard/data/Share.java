package com.ifree.magiccard.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.test.IsolatedContext;
import android.util.Log;

public class Share {

	private static String AppShare = "AppShare";

	public static final int INT = 0;
	public static final int FLOAT = 1;
	public static final int BOOLEAN = 2;
	public static final int LONG = 3;
	public static final int STRING = 4;

	public static String isFirst = "isFirst";
	public static String level  = "level";
	public static String object = "object";
	public static String stars = "starts";
	public static String number = "number";
	public static String randomLevel = "randomLevel";

	public static String[][] szScores = { 
			{"levelScores1_1", "levelScores1_2","levelScores1_3", 
			"levelScores1_4", "levelScores1_5", "levelScores1_6",
			"levelScores1_7", "levelScores1_8", "levelScores1_9",
			},
			{ "levelScores2_1","levelScores2_2", "levelScores2_3",
			"levelScores2_4", "levelScores2_5","levelScores2_6", 
			"levelScores2_7", "levelScores2_8", "levelScores2_9"
			}
			};
	
	public static String[][] szStars = { 
		
		{"levelStars1_1", "levelStars1_2","levelStars1_3",
		"levelStars1_4", "levelStars1_5", "levelStars1_6",
		"levelStars1_7", "levelStars1_8", "levelStars1_9", },
		
		{"levelStars2_1","levelStars2_2", "levelStars2_3", 
		"levelStars2_4","levelStars2_5","levelStars2_6",
		"levelStars2_7", "levelStars2_8","levelStars2_9",}
		};

	public static int getLevelinfo(Context context,int level)
	{
		return context.getSharedPreferences(AppShare, 0).getInt(szStars[level / 10 - 1][level % 10], 0);
	}
	
	public static void setLevelinfo(Context context,int level,int value)
	{
		Editor edit =  context.getSharedPreferences(AppShare, 0).edit();
		edit.putInt(szStars[level / 10 - 1][level % 10], value);
		edit.commit();
	}
	
	public static int getLevelScoreinfo(Context context,int level)
	{
		return context.getSharedPreferences(AppShare, 0).getInt(szScores[level / 10 - 1][level % 10], 0);
	}
	
	public static void setLevelScoreinfo(Context context,int level,int value)
	{
		Editor edit =  context.getSharedPreferences(AppShare, 0).edit();
		edit.putInt(szScores[level / 10 - 1][level % 10], value);
		edit.commit();
	}
	
	public static void setIsFirst(Context context,boolean value)
	{
		Editor edit =  context.getSharedPreferences(AppShare, 0).edit();
		edit.putBoolean(isFirst, value);
		edit.commit();
	}
	
	public static boolean getIsFirst(Context context)
	{
		return context.getSharedPreferences(AppShare, 0).getBoolean(isFirst, true);
	}
	
	public static void setObject(Context context,int value)
	{
		Editor edit =  context.getSharedPreferences(AppShare, 0).edit();
		edit.putInt(object, value);
		edit.commit();
	}
	
	public static int getObject(Context context)
	{
		return context.getSharedPreferences(AppShare, 0).getInt(object, 11);
	}
	
	public static void setStars(Context context,int value)
	{
		Editor edit =  context.getSharedPreferences(AppShare, 0).edit();
		edit.putInt(stars, value);
		edit.commit();
	}
	
	public static int getStars(Context context)
	{
		return context.getSharedPreferences(AppShare, 0).getInt(stars, 0);
	}
	
	public static void setLevel(Context context,int value)
	{
		Editor edit =  context.getSharedPreferences(AppShare, 0).edit();
		edit.putInt(level, value);
		edit.commit();
	}
	
	public static int getRandomLevel(Context context)
	{
		return context.getSharedPreferences(AppShare, 0).getInt(randomLevel, 0);
	}
	
	public static void setRandomLevel(Context context,int value)
	{
		Editor edit = context.getSharedPreferences(AppShare, 0).edit();
		edit.putInt(randomLevel, value);
		edit.commit();
	}
	
	public static int getLevel(Context context)
	{
		return context.getSharedPreferences(AppShare, 0).getInt(level, 100);
	}
	
	public static void setNumber(Context context,String value)
	{
		Editor edit =  context.getSharedPreferences(AppShare, 0).edit();
		edit.putString(number, value);
		edit.commit();
	}
	
	public static String getNumber(Context context)
	{
		return context.getSharedPreferences(AppShare, 0).getString(number, "");
	}
	
	public static void cleanShare(Context context) {
		
		Editor edit = context.getSharedPreferences(AppShare, 0).edit();
		edit.remove(object);
		edit.remove(level);
		edit.remove(stars);
		edit.remove(randomLevel);
		
		for(int i = 0 ;i < szScores.length; i++)
			for(int j = 0 ; j < szScores[i].length ; j++)
			{
				edit.remove(szScores[i][j]);
			}
		for(int i = 0 ;i < szStars.length; i++)
			for(int j = 0 ; j < szStars[i].length ; j++)
			{
				edit.remove(szStars[i][j]);
			}
		edit.commit();
	}
}
