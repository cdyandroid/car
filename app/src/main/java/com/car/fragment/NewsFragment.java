package com.car.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.car.activity.R;
import com.car.util.JListKit;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.List;

/**
 * 资讯
 * 
 * @author blue
 */
public class NewsFragment extends BaseFragment
{
	/**
	 * 初始化参数
	 * @return
	 */
	//要闻
	@ViewInject(R.id.news_tv_important)
	TextView news_tv_important;
	//新车
	@ViewInject(R.id.news_tv_car)
	TextView news_tv_car;
	//导购
	@ViewInject(R.id.news_tv_buy)
	TextView news_tv_buy;
	//试车
	@ViewInject(R.id.news_tv_try)
	TextView news_tv_try;
	//图解
	@ViewInject(R.id.news_tv_picture)
	TextView news_tv_picture;
	//行业
	@ViewInject(R.id.news_tv_market)
	TextView news_tv_market;
	//page
	@ViewInject(R.id.news_vp)
	ViewPager news_vp;

	private List<Fragment> fragmentList = JListKit.newArrayList();
	//要闻
	private NewsImportantFragment importantFragment;
	private NewsCarFragment carFragment;
	private NewsBuyFragment buyFragment;
	private NewsTryFragment tryFragment;
	private NewsPictureFragment pictureFragment;
	private NewsMarketFragment marketFragment;

	@Override
	protected int getLayoutId()
	{
		return R.layout.fragment_news_main;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	protected void initParams(Context context)
	{
		importantFragment = new NewsImportantFragment();
		carFragment = new NewsCarFragment();
		buyFragment = new NewsBuyFragment();
		tryFragment = new NewsTryFragment();
		pictureFragment = new NewsPictureFragment();
		marketFragment = new NewsMarketFragment();

		fragmentList.add(importantFragment);
		fragmentList.add(carFragment);
		fragmentList.add(buyFragment);
		fragmentList.add(tryFragment);
		fragmentList.add(pictureFragment);
		fragmentList.add(marketFragment);
		news_vp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				return fragmentList.get(position);
			}

			@Override
			public int getCount() {
				return fragmentList.size();
			}
		});
		news_vp.setCurrentItem(0);
		news_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				switch (position){
					case 0:
						news_tv_important.setBackgroundResource(R.drawable.news_ic_selected);
						news_tv_car.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_buy.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_try.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_picture.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_market.setBackgroundColor(getResources().getColor(android.R.color.transparent));

						news_tv_important.setTextColor(getResources().getColor(R.color.news_cl_choose));
						news_tv_car.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_buy.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_try.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_picture.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_market.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						break;
					// 新车
					case 1:

						news_tv_car.setBackgroundResource(R.drawable.news_ic_selected);
						news_tv_important.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_buy.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_try.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_picture.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_market.setBackgroundColor(getResources().getColor(android.R.color.transparent));

						news_tv_car.setTextColor(getResources().getColor(R.color.news_cl_choose));
						news_tv_important.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_buy.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_try.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_picture.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_market.setTextColor(getResources().getColor(R.color.news_cl_unchoose));

						break;
					// 导购
					case 2:

						news_tv_buy.setBackgroundResource(R.drawable.news_ic_selected);
						news_tv_important.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_car.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_try.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_picture.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_market.setBackgroundColor(getResources().getColor(android.R.color.transparent));

						news_tv_buy.setTextColor(getResources().getColor(R.color.news_cl_choose));
						news_tv_important.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_car.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_try.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_picture.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_market.setTextColor(getResources().getColor(R.color.news_cl_unchoose));

						break;
					// 试车
					case 3:

						news_tv_try.setBackgroundResource(R.drawable.news_ic_selected);
						news_tv_important.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_car.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_buy.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_picture.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_market.setBackgroundColor(getResources().getColor(android.R.color.transparent));

						news_tv_try.setTextColor(getResources().getColor(R.color.news_cl_choose));
						news_tv_important.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_car.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_buy.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_picture.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_market.setTextColor(getResources().getColor(R.color.news_cl_unchoose));

						break;
					// 图解
					case 4:

						news_tv_picture.setBackgroundResource(R.drawable.news_ic_selected);
						news_tv_important.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_car.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_buy.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_try.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_market.setBackgroundColor(getResources().getColor(android.R.color.transparent));

						news_tv_picture.setTextColor(getResources().getColor(R.color.news_cl_choose));
						news_tv_important.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_car.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_buy.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_try.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_market.setTextColor(getResources().getColor(R.color.news_cl_unchoose));

						break;
					// 行情
					case 5:

						news_tv_market.setBackgroundResource(R.drawable.news_ic_selected);
						news_tv_important.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_car.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_buy.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_try.setBackgroundColor(getResources().getColor(android.R.color.transparent));
						news_tv_picture.setBackgroundColor(getResources().getColor(android.R.color.transparent));

						news_tv_market.setTextColor(getResources().getColor(R.color.news_cl_choose));
						news_tv_important.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_car.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_buy.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_try.setTextColor(getResources().getColor(R.color.news_cl_unchoose));
						news_tv_picture.setTextColor(getResources().getColor(R.color.news_cl_unchoose));

						break;

				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	//控件点击事件
	@OnClick({ R.id.news_tv_important, R.id.news_tv_car, R.id.news_tv_buy, R.id.news_tv_try, R.id.news_tv_picture, R.id.news_tv_market })
	public void viewOnClick(View view){
		switch (view.getId()){
			case R.id.news_tv_important:
				news_vp.setCurrentItem(0);
				break;
			case R.id.news_tv_car:

				news_vp.setCurrentItem(1);

				break;
			case R.id.news_tv_buy:

				news_vp.setCurrentItem(2);

				break;
			case R.id.news_tv_try:

				news_vp.setCurrentItem(3);

				break;
			case R.id.news_tv_picture:

				news_vp.setCurrentItem(4);

				break;
			case R.id.news_tv_market:

				news_vp.setCurrentItem(5);

				break;

			default:
				break;
		}
	}
}















































































































































































































































































































