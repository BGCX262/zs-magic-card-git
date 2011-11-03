package com.ifree.magiccard.ui;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import cn.emagsoftware.api.GameInterface;
import cn.emagsoftware.api.GameInterface.BillingViewCallBack;
import cn.emagsoftware.gamebilling.BillingInfo;
import cn.emagsoftware.gamebilling.BillingView;

import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.dialog.AnimDialog;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.logical.Media;
import com.ifree.magiccard.logical.SoundManager;
import com.ifree.magiccard.main.R;

public class SelectLevelActivity extends BasicActivity implements OnClickListener,OnItemClickListener{

	final String tag = "SelectLevelActivity";
	private int type = 0;
	final int type_1 = 0;
	final int type_2 = 1;
	
	private View btn_close = null;
	private View btn_level1 = null;
	private View btn_level2 = null;
	private View btn_level3 = null;
	RelativeLayout rlBuy;
	
	private GridView grid_level = null;
//	private Bitmap[] numbers = new Bitmap[10];
	private int[] numbers = null;
	private int scoreWidth = 15;
	private Resources res = null;
	private AnimDialog dialog = null;
	private int level = 0;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if (rlBuy.getVisibility() == View.VISIBLE) {
                rlBuy.setVisibility(View.GONE);
            }

            super.handleMessage(msg);
        }

    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		res = this.getResources();
		if(!MainActivity.isShowAnim)
		{
			MainActivity.isShowAnim = true;
			dialog = new AnimDialog(this,true,null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}
		if(type == type_1)
		{
			Type1_init();
		}
		else if(type == type_2)
		{
			Type2_init();
		}
//		SoundManager.playMusic(SoundManager.id_game);
		
	}
    
	private void Type1_init()
	{   
		int level = Share.getLevel(this);
		this.setContentView(R.layout.selectlevelactivity);
		rlBuy = (RelativeLayout) this.findViewById(R.id.rlBuy);
		btn_close = this.findViewById(R.id.dialog_btn_change);
		btn_close.setOnClickListener(this);
		btn_level1 = this.findViewById(R.id.btn_level1);
		btn_level1.setOnClickListener(this);
		btn_level2 = this.findViewById(R.id.btn_level2);
		btn_level2.setOnClickListener(this);
		btn_level3 = this.findViewById(R.id.btn_level3);
		btn_level3.setOnClickListener(this);
		
		if(level == 100)
		{
			btn_level2.setEnabled(false);
			btn_level3.setEnabled(false);
		}
		else if(level == 110)
		{
			btn_level3.setEnabled(false);
		}
	}
	
	private void getNumberImage()
	{
	  if(numbers == null)
	  {	
		    numbers = new int[10];
		    numbers[0] =  R.drawable.number0;
			numbers[1] =  R.drawable.number1;
			numbers[2] =  R.drawable.number2;
			numbers[3] =  R.drawable.number3;
			numbers[4] =  R.drawable.number4;
			numbers[5] =  R.drawable.number5;
			numbers[6] =  R.drawable.number6;
			numbers[7] =  R.drawable.number7;
			numbers[8] =  R.drawable.number8;
			numbers[9] =  R.drawable.number9;
	  }
	}
	
	private void Type2_init()
	{   
//		Bitmap number = BitmapFactory.decodeResource(getResources(), R.drawable.number);
//		for(int i = 0; i <10; i++)
//	    {
//	        	numbers[i] = Bitmap.createBitmap(number, scoreWidth*i, 0, scoreWidth, number.getHeight());
			
//	    }
		getNumberImage();
		this.setContentView(R.layout.selectlevelactivity2);
		ImageView iv = (ImageView)this.findViewById(R.id.image_title);
		if(level == 10)
			iv.setImageResource(R.drawable.chooselevel_lv_01);
		else if(level == 20)
			iv.setImageResource(R.drawable.chooselevel_lv_02);
		btn_close = this.findViewById(R.id.dialog_btn_change);
		btn_close.setOnClickListener(this);
		grid_level = (GridView)this.findViewById(R.id.grid_level);
		grid_level.setAdapter(getAdapter());
		grid_level.setOnItemClickListener(this);
		
	}
	
	private ListAdapter getAdapter()
	{
		ListAdapter adapter = null;
		ArrayList<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> map =  null;
		for(int i = 1 ; i < numbers.length;i++)
		{
			map = new HashMap<String,Object>();
			
			int infos  = Share.getLevelinfo(this, (level + i - 1));
			if(i != 1 && infos < 10)
			{
				map.put("number", R.drawable.btn_chooselevel_lv_lock);
				map.put("star", 0);
			}
			else 
			{
				map.put("number", numbers[i]);
				switch(infos % 10)
				{
					case 0:
						map.put("star", 0);
						break;
					case 1:
						map.put("star", R.drawable.lv_satr01);
						break;
					case 2:
						map.put("star", R.drawable.lv_satr02);
						break;
					case 3:
						map.put("star", R.drawable.lv_satr03);
						break;
				}
			}
			data.add(map);
		}
		adapter = new SimpleAdapter(this, data, R.layout.gridview_level, new String[]{"number","star"}, new int[]{R.id.image2,R.id.image});
		return adapter;
	}
	
	private void Type1_click(View v)
	{
		if(v == btn_level1)
		{
			type = type_2;
			level = 10;
			Type2_init();
			
		}
		else if(v == btn_level2)
		{
//			type = type_2;
//			level = 20;
//			Type2_init();
		    handleBuy();
			
		}
		else if(v == btn_level3)
		{
			Bundle data = new Bundle();
			data.putInt("level", 0);
			GameActivity.ctime = 0;
			Intent intent = new Intent();
			intent.setClass(this, GameActivity.class);
			intent.putExtras(data);
			startActivity(intent);
			this.finish();
		}
		else if(v == btn_close)
		{
			this.finish();
			Intent intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			
		}
	}
	
	private void Type2_click(View v)
	{
		 if(v == btn_close)
		 {
			 	type = type_1;
				Type1_init();
				level = 0;
		 }
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(type == type_1)
		{
			Type1_click(v);
		}
		else if(type == type_2)
		{
			Type2_click(v);
		}
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		int canGo = Share.getLevelinfo(this, level + arg2);
		if(arg2 != 0 && canGo >= 10)
		{	Bundle data = new Bundle();
			data.putInt("level", level + arg2);
			Intent intent = new Intent();
			intent.setClass(this, GameActivity.class);
			intent.putExtras(data);
			startActivity(intent);
			this.finish();
		}
		else if(arg2 == 0)
		{
			Bundle data = new Bundle();
			data.putInt("level", level + arg2);
			Intent intent = new Intent();
			intent.setClass(this, GameActivity.class);
			intent.putExtras(data);
			startActivity(intent);
			this.finish();
		}
	}

    public void handleBuy() {
        // BillingView bv = new BillingView(this){
        //
        // @Override
        // public void onBillingFinish() {
        // //�Ʒ����̽���
        // if(handler != null){
        // handler.sendEmptyMessage(0);
        // }
        // }
        //
        // @Override
        // public void onBillingSuccess() {
        // //�Ʒѳɹ�
        // Share.setShareValue(ChoseLevels.this, Share.szFlag[14], true);
        // }
        //
        // @Override
        // public void onUserOperCancel() {
        // //�û�ȡ���Ʒ�����
        // if(handler != null){
        // handler.sendEmptyMessage(0);
        // }
        // }
        //
        // @Override
        // public void onUserOperError(int errCode) {
        // //��Ҫʵ�ִ���׽������errCode��ο��ĵ�
        //              
        // /**
        // * ERROR_SMS_SEND_FAILURE�������ʹ�ö��Ż����û����ŷ���ʧ�ܺ�δʹ�������Ʒѣ��򴥷��ô���
        // * ERROR_WEB_NETWORK_ERROR����������
        // * ERROR_WEB_USING_CMWAP_ON_ANDROID_ERROR��Androidʹ��CMWAP����
        // */
        //
        // switch (errCode) {
        // case ERROR_SMS_SEND_FAILURE:
        // Log.e("BillingErr", "ERROR_SMS_SEND_FAILURE");
        // Toast.makeText(ChoseLevels.this, "���ŷ���ʧ��", Toast.LENGTH_LONG).show();
        // break;
        // case ERROR_WEB_NETWORK_ERROR:
        // Log.e("BillingErr", "ERROR_WEB_NETWORK_ERROR");
        // Toast.makeText(ChoseLevels.this, "��������", Toast.LENGTH_LONG).show();
        // break;
        // case ERROR_WEB_USING_CMWAP_ON_ANDROID_ERROR:
        // Log.e("BillingErr", "ERROR_WEB_USING_CMWAP_ON_ANDROID_ERROR");
        // Toast.makeText(ChoseLevels.this, "CMWAP����",
        // Toast.LENGTH_LONG).show();
        // break;
        // default:
        // Log.e("BillingErr", "BillingErr");
        // break;
        // }
        // if(handler != null){
        // handler.sendEmptyMessage(0);
        // }
        // }
        //          
        // };
        //      
        //
        //      
        // String s =
        // "�𾴵Ŀͻ���������������Ϸ���ƣ�ħ����\n�����ṩ�̣���˼���(�Ϻ�)���޹�˾\n�ʷ�˵����4Ԫ\n\n�����ȷ�ϡ���ťȷ�Ϲ���\n�й��ƶ�";
        //      
        // //�Ʒ����ͣ���Ϸ���ƣ��Ʒѵ����ƣ�����������ƣ��Ʒ�������������żƷ����ݣ������Ʒ�key
        // bv.init(BillingView.WEB_BILLING_ON_SMS_BILLING_FAILED, "���η�����",
        // "һ���Լ���", "��˼���(�Ϻ�)���޹�˾", "400",s, "47013C0ECF68D26710EADB7C6");
        // bv.setBackgroundColor(Color.rgb(5, 121, 175));
        // if(rlBuy.getVisibility() == View.GONE){
        // rlBuy.setVisibility(View.VISIBLE);
        // rlBuy.addView(bv);
        // }
        
        

        // ��ȡ���ؼ����־�������ܵķ�ֹ���棬��IMEI
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        final String key = "activateflag" + tm.getDeviceId();
        final SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        boolean activate = sp.getBoolean(key, false);
        // δ������������������
        if (!activate) {

            BillingViewCallBack callback = new BillingViewCallBack() {

                public void onBillingFinish() {
                    // �Ʒ����̽���
                    if (handler != null) {
                        handler.sendEmptyMessage(0);
                    }
                }

                public void onBillingSuccess() {
                    // �Ʒѳɹ�
                    Editor edit = sp.edit();
                    edit.putBoolean(key, true);
                    edit.commit();
                    Toast.makeText(SelectLevelActivity.this, "����ɹ�", Toast.LENGTH_LONG)
                            .show();
                }

                public void onUserOperCancel() {
                    // �û�ȡ���Ʒ�����
                    if (handler != null) {
                        handler.sendEmptyMessage(0);
                    }
                }

                public void onUserOperError(int errCode) {
                    // ��Ҫʵ�ִ���׽������errCode��ο��ĵ�
                    switch (errCode) {
                    case BillingView.ERROR_SMS_SEND_FAILURE:
                        Toast.makeText(SelectLevelActivity.this, "���ż���ʧ��",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case BillingView.ERROR_WEB_NETWORK_ERROR:
                        Toast.makeText(SelectLevelActivity.this, "��������",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case BillingView.ERROR_WEB_USING_CMWAP_ON_ANDROID_ERROR:
                        Toast.makeText(SelectLevelActivity.this, "Android��֧��CMWAP���ʼƷ�",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (handler != null) {
                        handler.sendEmptyMessage(0);
                    }
                }
            };
            //��Ϸ����ʱ����øó�ʼ��������ע��ó�ʼ�����������ȵ���
            GameInterface.initializeApp(this, "ħ����", "��˼���(�Ϻ�)���޹�˾", "020-38886860-350", "", new BillingInfo[]{
                    new BillingInfo("һ���Լ���", "A7133EBBA73AEF1C16874C88F", "A7133EBBA73AEF1C16874C88F", 500)});
            
            View bv = GameInterface.getBillingView(this,
                    BillingView.WEB_BILLING_ON_SMS_BILLING_FAILED, 0, callback);
            if (rlBuy.getVisibility() == View.GONE) {
                rlBuy.setVisibility(View.VISIBLE);
                rlBuy.addView(bv);
            }
        } else {
            // ��������������������
            type = type_2;
            level = 20;
            Type2_init();
        }
    }

	private DialogMethod dm = new DialogMethod()
	{

		public void exit() {
			// TODO Auto-generated method stub
			dialog.cancel();
		}

		public void end() {
			
			finish();
			
		}

		public void changeActivity() {
			// TODO Auto-generated method stub
			
		}

		public void nextGame() {
			// TODO Auto-generated method stub
			
		}

		public void tryAgain() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}
