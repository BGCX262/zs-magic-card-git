package com.ifree.magiccard.util;


import android.util.Log;

/**
 *  
 *  调试信息打印类
 *  
 *  用于方便管理 
 * 
 */
public class Debug {
    
	final String tag = "Debug";
	
	private static boolean isShowMessage = true;
	
	/**
	 * 
	 * 输出信息d
	 * 
	 * @param 输出信息标签
	 * @param 输出信息内容
	 */
	public static void d(String tag,String msg)
	{
		if(isShowMessage)
		{
			Log.d(tag, msg);
		}
	}
	
	/**
	 * 
	 * 输出信息w
	 * 
	 * @param 输出信息标签
	 * @param 输出信息内容
	 */
	public static void w(String tag,String msg)
	{
		if(isShowMessage)
		{
			Log.w(tag, msg);
		}
	}
	
	/**
	 * 
	 * 输出信息e
	 * 
	 * @param 输出信息标签
	 * @param 输出信息内容
	 */
	public static void e(String tag,String msg)
	{
		if(isShowMessage)
		{
			Log.e(tag, msg);
		}
	}
	
	/**
	 * 
	 * 输出信息i
	 * 
	 * @param 输出信息标签
	 * @param 输出信息内容
	 */
	public static void i(String tag,String msg)
	{
		if(isShowMessage)
		{
			Log.i(tag, msg);
		}
	}
	
	/**
	 * 
	 * 输出信息i
	 * 
	 * @param 输出信息标签
	 * @param 输出信息内容
	 */
	public static void v(String tag,String msg)
	{
		if(isShowMessage)
		{
			Log.v(tag, msg);
		}
	}
	
	public static void show(String tag, String value)
	{
		if(isShowMessage)
		{
			System.out.println(tag + value);
		}
	}
	
	public static void show(String tag, int value)
	{
		if(isShowMessage)
		{
			System.out.println(tag + value);
		}
	}
	
	public static void show(String tag, long value)
	{
		if(isShowMessage)
		{
			System.out.println(tag + value);
		}
	}
	
	public static void show(String tag, double value)
	{
		if(isShowMessage)
		{
			System.out.println(tag + value);
		}
	}
	
	public static void show(String tag, float value)
	{
		if(isShowMessage)
		{
			System.out.println(tag + value);
		}
	}
	
	public static void show(String tag, char value)
	{
		if(isShowMessage)
		{
			System.out.println(tag + value);
		}
	}
	
	public static void show(String tag, boolean value)
	{
		if(isShowMessage)
		{
			System.out.println(tag + value);
		}
	}
}
