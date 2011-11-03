package com.ifree.magiccard.logical;

import java.io.IOException;

import com.ifree.magiccard.main.Main;
import com.ifree.magiccard.main.R;
import com.ifree.magiccard.ui.MainActivity;
import com.ifree.magiccard.util.Debug;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundManager {
  
	static final String tag = "SoundManager";
	private static SoundPool sound = null;
	private static MediaPlayer player_other = null;
	private static MediaPlayer player_game = null;
	
	public static int id_other = 99;
	public static int id_game = 98;
	public static int id_win;
	public static int id_lose;
	public static boolean isInit = false;
	
	private static boolean isOtherMusicOn = false;
	private static boolean isPlayMusicOn = false;
	
	public static void init()
	{  
		Debug.e(tag, "loading");
		sound = new SoundPool(2,AudioManager.STREAM_MUSIC, 100);
		id_win = sound.load(MainActivity.context,R.raw.pass,1);
		id_lose = sound.load(MainActivity.context,R.raw.lose,1);
		player_other = MediaPlayer.create(MainActivity.context, R.raw.other);
		try {
			player_other.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player_other.setLooping(true);
		player_game = MediaPlayer.create(MainActivity.context, R.raw.playing);
		try {
			player_game.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player_game.setLooping(true);
		isInit = true;
	}
	
	
	public void playSound(int id)
	{
	  if(!isInit)
		  init();
		sound.play(id, 1, 1, 0, 0, 1);
	}
	
	
	public static void playMusic(int id)
	{
		 if(!isInit)
			  init();
		if(id == id_other)
		{
			player_game.stop();
			if(!isOtherMusicOn)
			 {
				
				player_other.start();
				isOtherMusicOn = true;
				isPlayMusicOn = false;
			 }
			
		}
		else if(id == id_game)
		{
			
			player_other.stop();
			if(!isPlayMusicOn)
				{
					
					player_game.start();
					isPlayMusicOn = true;
					isOtherMusicOn = false;
				}
		}
	}
	
	public static void stopMusic()
	{
		player_game.stop();
		player_other.stop();
		player_game.release();
		player_other.release();
		isPlayMusicOn = false;
		isOtherMusicOn = false;
		isInit = false;
	}
}
