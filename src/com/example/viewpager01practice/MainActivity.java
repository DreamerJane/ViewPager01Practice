package com.example.viewpager01practice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnPageChangeListener {

	private ViewPager viewPager;
	
	private List<View> list = new ArrayList<View>();
	
	private MyViewPagerAdapter adapter;
	
	private final int imgs[] = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d };
	
	private ImageView dots[];
	
	private int currentPosition;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        initImgs();
        adapter = new MyViewPagerAdapter(list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
        initDots();
        
    }

	private void initImgs() {
    	LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    	
    	for(int i = 0; i < imgs.length; i++ ){
    		ImageView iv = new ImageView(this);
    		iv.setLayoutParams(params);
    		iv.setScaleType(ScaleType.CENTER_CROP);
    		iv.setImageResource(imgs[i]);
    		list.add(iv);
    	}
    }

	private void initDots() {
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
		dots = new ImageView[imgs.length];
		for(int i = 0; i < imgs.length; i++) {
			dots[i] = (ImageView) linearLayout.getChildAt(i);
			dots[i].setEnabled(true);
		}
		currentPosition = 0;
		dots[currentPosition].setEnabled(false);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageSelected(int position) {
		setCurrentDots(position);
	}


	private void setCurrentDots(int position) {
		if(position < 0 || position >=list.size() || currentPosition == position){
			return;
		}
		dots[position].setEnabled(false);
		dots[currentPosition].setEnabled(true);
		currentPosition = position;
		
	}
    
}
