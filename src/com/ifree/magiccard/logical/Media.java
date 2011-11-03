package com.ifree.magiccard.logical;

import java.io.IOException;

import com.ifree.magiccard.ui.MainActivity;

import android.content.Context;
import android.media.MediaPlayer;

public class Media {

	public static MediaPlayer mAudio = null;
	public static int resid = 0;
	
	/**
	 * ��ʼ������
	 */
	public static void initMusic(Context context,int resid) {
		Media.resid = resid;
		
		
		if(MainActivity.isMusic)
		{
			stopMusic();
			try {
				mAudio = MediaPlayer.create(context, resid);
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				mAudio.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		mAudio.start();
		mAudio.setLooping(true);
		}
	}
	
	/**
	 * ��������
	 */
	public static void reStart(Context context) {
		if (mAudio != null && MainActivity.isMusic)
			mAudio.start();
	}

	/**
	 * ��ͣ
	 */
	public static void pauseMusic(Context context) {
		if (mAudio != null && MainActivity.isMusic)
			mAudio.pause();
	}

	/**
	 * ֹͣ��������
	 */
	public static void stopMusic() {
		if (mAudio != null) {
			mAudio.reset();
			mAudio = null;
		}
	}
	
	public static void setLoop(boolean loop){
		if(mAudio != null){
			mAudio.setLooping(loop);
		}
	}
}
