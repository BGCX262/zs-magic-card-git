package com.ifree.magiccard.ui;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.ifree.magiccard.data.Share;
import com.ifree.magiccard.dialog.KnowlegeDetailDialog;
import com.ifree.magiccard.iface.DialogMethod;
import com.ifree.magiccard.logical.GameLogical;
import com.ifree.magiccard.main.R;

public class KnowLegeActivity extends BasicActivity implements OnClickListener,OnItemClickListener{

	final String tag = "KnowLegeActivity";
	private GridView box_grid = null;
	private View btn_back = null;
	private int[] boxes = new int[]{
			R.drawable.knowledge_box_01,
			R.drawable.knowledge_box_02,
			R.drawable.knowledge_box_03,
			R.drawable.knowledge_box_04,
			R.drawable.knowledge_box_05
	};
	private int stars = 0;
	private KnowlegeDetailDialog dialog = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		stars = GameLogical.getOpenBoxs();
		this.setContentView(R.layout.knowlegeactivity);
		box_grid = (GridView)this.findViewById(R.id.grid_knowlegebox);
		box_grid.setAdapter(getAdapter());
		box_grid.setOnItemClickListener(this);
		btn_back = this.findViewById(R.id.dialog_btn_change);
		btn_back.setOnClickListener(this);
		
	}
	
	private SimpleAdapter getAdapter()
	{
		SimpleAdapter adapter = null;
		
		ArrayList<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> map =  null;
		for(int i = 0 ; i < boxes.length;i++)
		{
			map = new HashMap<String,Object>();
			map.put("box", boxes[i]);
			if(i <= stars - 1)
			{
				map.put("lock", 0);
			}
			else 
			{
				map.put("lock", R.drawable.lock_knowledge_box);
			}
			data.add(map);
		}
		adapter = new SimpleAdapter(this, data, R.layout.gridview_knowlegebox, new String[]{"box","lock"}, new int[]{R.id.image1,R.id.image2});
		
		return adapter;
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		if(arg2 <= stars - 1)
		{
			dialog = new KnowlegeDetailDialog(this,true,arg2,null);
			dialog.setDialogMethod(dm);
			dialog.show();
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		this.finish();
		Intent intent = new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
	}
	
	
	private DialogMethod dm = new DialogMethod()
	{

		public void exit() {
			// TODO Auto-generated method stub
		  if(dialog != null)
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
