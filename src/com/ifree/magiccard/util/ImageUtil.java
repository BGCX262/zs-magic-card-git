package com.ifree.magiccard.util;

import java.io.IOException;

import com.ifree.magiccard.ui.MainActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class ImageUtil {
    /**
     * 
     * 对图片进行截取
     * @param path
     * @param width_each
     * @return
     */
	public static Bitmap[] getImages(int id,int width_each)
	{
		Bitmap src = null;
		
		src = BitmapFactory.decodeResource(MainActivity.res, id);
		
		if(src  == null)
		{
			return null;
		}
		Bitmap[] array = null;
	    
	    int width = src.getWidth();
	    int height = src.getHeight();
	    
	    int max = width / width_each;
	    
	    array = new Bitmap[max];
	    
	    for(int i = 0; i < max ; i++)
	    {
	    	array[i] = Bitmap.createBitmap(src, i * width_each, 0, width_each, height);
	    }
		
		return array;
	}
	
	public static Bitmap getImage(int id) // 创建图片
	{
		Bitmap ime = null;
		//System.out.println(path);
		
		ime = BitmapFactory.decodeResource(MainActivity.res, id);
		
		return ime;
	}
	
   
}
