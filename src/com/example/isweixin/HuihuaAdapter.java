package com.example.isweixin;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HuihuaAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<HuiHua> list = new ArrayList<HuiHua>();
	
	public HuihuaAdapter(Context context,ArrayList<HuiHua> list){
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		HuiHua hh = list.get(position);
		H h = null;
		if(view==null){
			h = new H();
			view = LayoutInflater.from(context).inflate(R.layout.liaotian, parent, false);
			h.pic = (ImageView)view.findViewById(R.id.l1);
			h.name = (TextView)view.findViewById(R.id.name);
			h.time = (TextView)view.findViewById(R.id.time);
			h.lastmsg = (TextView)view.findViewById(R.id.lastmsg);
			
			view.setTag(h);
		}else{
			h = (H)view.getTag();
		}
		
		h.pic.setImageResource(Integer.parseInt(hh.getTxPath()));
		h.name.setText(hh.getName1());
		h.time.setText(hh.getLastTime());
		h.lastmsg.setText(hh.getLastContent());
		
		return view;
	}

	class H{
		ImageView pic;
		TextView name;
		TextView time;
		TextView lastmsg;
	}
}
