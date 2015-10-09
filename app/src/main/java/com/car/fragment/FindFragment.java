package com.car.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.car.activity.R;
import com.car.adapter.FragementAdapter;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * 找车
 * 
 * @author blue
 */
public class FindFragment extends BaseFragment
{

	@Override
	protected int getLayoutId()
	{
		return R.layout.fragment_find_main;
	}
	@ViewInject(R.id.pager)
	ViewPager pager;
	FragmentPagerAdapter adapter;
	List<Fragment> fragments;
	@ViewInject(R.id.ppzc_tv)
	private TextView ppzc_tv;
	@ViewInject(R.id.jzzc_tv)
	private TextView jzzc_tv;
	@Override
	protected void initParams(Context context)
	{
		fragments = new ArrayList<Fragment>();
		final Fragment ppzc = new Fragementppzc();
		final Fragment jzzc = new Fragementjzzc();
		fragments.add(ppzc);
		fragments.add(jzzc);

		pager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				return fragments.get(position);
			}

			@Override
			public int getCount() {
				return fragments.size();
			}
		});
		pager.setCurrentItem(0);
		pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
					switch (position){
						case 0:
							ppzc_tv.setBackgroundResource(R.drawable.news_ic_selected);
							jzzc_tv.setBackgroundColor(getResources().getColor(android.R.color.transparent));
							ppzc_tv.setTextColor(getResources().getColor(R.color.news_cl_choose));
							jzzc_tv.setTextColor(getResources().getColor(R.color.car_cl_unchoose));
							break;
						case 1:
							jzzc_tv.setBackgroundResource(R.drawable.news_ic_selected);
							ppzc_tv.setBackgroundColor(getResources().getColor(android.R.color.transparent));
							jzzc_tv.setTextColor(getResources().getColor(R.color.news_cl_choose));
							ppzc_tv.setTextColor(getResources().getColor(R.color.car_cl_unchoose));
							break;
					}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});



}
	@OnClick({R.id.ppzc_tv,R.id.jzzc_tv})
	public void viewOnclick(View view){
		switch (view.getId()){
			case R.id.ppzc_tv:
				pager.setCurrentItem(0);
				break;
			case R.id.jzzc_tv:
				pager.setCurrentItem(1);
				break;
		}

	}
}