package com.ifree.magiccard.util;


import android.util.Log;

/**
 *  
 *  ������Ϣ��ӡ��
 *  
 *  ���ڷ������ 
 * 
 */
public class Debug {
    
	final String tag = "Debug";
	
	private static boolean isShowMessage = true;
	
	/**
	 * 
	 * �����Ϣd
	 * 
	 * @param �����Ϣ��ǩ
	 * @param �����Ϣ����
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
	 * �����Ϣw
	 * 
	 * @param �����Ϣ��ǩ
	 * @param �����Ϣ����
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
	 * �����Ϣe
	 * 
	 * @param �����Ϣ��ǩ
	 * @param �����Ϣ����
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
	 * �����Ϣi
	 * 
	 * @param �����Ϣ��ǩ
	 * @param �����Ϣ����
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
	 * �����Ϣi
	 * 
	 * @param �����Ϣ��ǩ
	 * @param �����Ϣ����
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
