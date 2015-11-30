package com.example.viewpager01practice;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MyViewPagerAdapter extends PagerAdapter {

	private List<View> list ;
	
	public MyViewPagerAdapter(List<View> list) {
		this.list = list;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View view, int position, Object object) {
		((ViewPager) view).removeView(list.get(position));
	}

	@Override
	public Object instantiateItem(View view, int position) {
		((ViewPager) view).addView(list.get(position));
		return list.get(position);
	}

}
