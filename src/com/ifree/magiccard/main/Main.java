package com.ifree.magiccard.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.RadioGroup.LayoutParams;
import cn.emagsoftware.animation.OpeningAnimation;
import cn.emagsoftware.api.GameInterface.AnimationCompleteCallback;

import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.logical.SoundManager;
import com.ifree.magiccard.ui.MainActivity;
import com.ifree.magiccard.util.Debug;



public class Main extends Activity {
    /** Called when the activity is first created. */
	

	private RelativeLayout rlLogo = null;

	public static Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.main2);
		DisplayMetrics outMetrics = new DisplayMetrics();
		
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		
		Debug.e("dm", "x:" + outMetrics.widthPixels + ", y:" + outMetrics.heightPixels);
		
		context = this;

		init();
		
	}
	RelativeLayout svDisclaimer;
	public void init() {
		rlLogo = (RelativeLayout) findViewById(R.id.rlLogo);
		// OpeningAnimation open = new OpeningAnimation(this) {
		//
		// @Override
		// public void onAnimationFinished(boolean musicEnabled) {
		// // TODO Auto-generated method stub
		// System.out.println(musicEnabled);
		// Share.setIsBgMusic(context, musicEnabled);
		// Share.setIsSoundEffect(context, musicEnabled);
		// Intent in = new Intent();
		// in.setClassName(GeometryFlipLooked.this.getPackageName(),
		// StartPage.class.getName());
		// GeometryFlipLooked.this.startActivity(in);
		// GeometryFlipLooked.this.finish();
		// }
		// };
		//		
		// rlLogo.addView(open);
		// Index open = new Index(this, this);
		// rlLogo.addView(open);

		OpeningAnimation mOpeningAnimation = new OpeningAnimation(this,
				new AnimationCompleteCallback() {
					public void onAnimationCompleted(boolean isMusicEnabled) {
						// 游戏开发者需要实现的代码：即开启游戏背景音乐
						MainActivity.isMusic = isMusicEnabled;
						// 游戏开发者需要在此处：实现游戏主界面的展现代码
						Main.this.startActivity(new Intent(
								Main.this, MainActivity.class));
					}
				});
		LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		rlLogo.addView(mOpeningAnimation, lp);

		if (Share.getIsFirst(this)) {
			Share.setIsFirst(this, false);

			svDisclaimer = (RelativeLayout) findViewById(R.id.svDisclaimer);
			svDisclaimer.setVisibility(View.VISIBLE);

			rlLogo.setVisibility(View.GONE);

			Button btSure = (Button) findViewById(R.id.btDisclaimerSure);
			btSure.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {

					svDisclaimer.setVisibility(View.GONE);

					rlLogo.setVisibility(View.VISIBLE);
				}
			});
		}else{
			
			rlLogo.setVisibility(View.VISIBLE);
		}
	}
   
}