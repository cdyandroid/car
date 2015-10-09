package com.car.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.car.activity.R;

import com.car.adapter.ImagePagerAdapter;
import com.car.adapter.MyNewsAdapter;
import com.car.entity.ImageItem;
import com.car.entity.NewsItem;

import com.car.imagecycleview.CircleFlowIndicator;
import com.car.imagecycleview.ViewFlow;
import com.car.view.ProgressWheel;
import com.car.view.ToastMaker;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


import java.util.ArrayList;
import java.util.List;




/**
 * Created by Administrator on 2015-10-01.
 */
public class NewsImportantFragment extends BaseFragment {
    @ViewInject(R.id.news_important_lv)
    PullToRefreshListView news_important_lv;
    @ViewInject(R.id.pw)
    ProgressWheel pw;
    //适配器
    private MyNewsAdapter adapter;
    // 加载布局
    private LinearLayout loading_llyt;
    // 是否为最后一行
    private boolean isLastRow = false;
    // 是否还有更多数据
    private boolean isMore = true;
    private NewsItem wrrap;
    private ImageItem images;
    @ViewInject(R.id.viewflow)
    private ViewFlow mViewFlow;
    @ViewInject(R.id.viewflowindic)
    private CircleFlowIndicator mFlowIndicator;
    private ArrayList<String> imageUrlList = new ArrayList<String>();
    ArrayList<String> linkUrlArray= new ArrayList<String>();
    ArrayList<String> titleList= new ArrayList<String>();




    @Override
    protected int getLayoutId() {
        return R.layout.fragement_important;
    }

    @Override
    protected void initParams(final Context context) {


        pw.setText("加载中");
            //开始旋转
            pw.spin();

        loading_llyt = (LinearLayout)getLayoutInflater(null).inflate(R.layout.listview_loading_view,null);
        news_important_lv.setMode(PullToRefreshBase.Mode.BOTH);


        loadListView(context);

        loadParams(context);
       // initBanner(context);


    }

   /* private void initBanner(Context context) {
        mViewFlow.setAdapter(new ImagePagerAdapter(context, imageUrlList,
                imageUrlList, titleList).setInfiniteLoop(true));
        mViewFlow.setmSideBuffer(imageUrlList.size()); // 实际图片张数，
        // 我的ImageAdapter实际图片张数为3

        mViewFlow.setFlowIndicator(mFlowIndicator);
        mViewFlow.setTimeSpan(4500);
        mViewFlow.setSelection(imageUrlList.size() * 1000); // 设置初始位置
        mViewFlow.startAutoFlowTimer(); // 启动自动播放
    }*/


    private void loadParams(final Context context) {
        new HttpUtils().send(HttpRequest.HttpMethod.GET, "https://raw.githubusercontent.com/cdyandroid/hello-world/master/image", new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
               images = new Gson().fromJson(responseInfo.result,ImageItem.class);
                for (int i =0;i< images.getList().size();i++){
                    imageUrlList.add(images.getList().get(i).getImage());
                   // ToastMaker.showShortToast(images.getList().get(i).getImage());
                }

               /* imageUrlList.add("http://b.hiphotos.baidu.com/image/pic/item/d01373f082025aaf95bdf7e4f8edab64034f1a15.jpg");
                imageUrlList.add("http://g.hiphotos.baidu.com/image/pic/item/6159252dd42a2834da6660c459b5c9ea14cebf39.jpg");
                imageUrlList.add("http://d.hiphotos.baidu.com/image/pic/item/adaf2edda3cc7cd976427f6c3901213fb80e911c.jpg");*/
                linkUrlArray.add("http://www.nipic.com/show/1/21/31af72795293c823.html");
                linkUrlArray.add("http://www.nipic.com/show/1/21/31af72795293c823.html");
                linkUrlArray.add("http://www.nipic.com/show/1/21/31af72795293c823.html");
                titleList.add("2004款阿斯顿马丁Vanquish S V12");
                titleList.add("给汽车美容时的一些小建议");
                titleList.add("汽车设计图_概念车_3d作品 ");

                mViewFlow.setAdapter(new ImagePagerAdapter(context, imageUrlList,
                        linkUrlArray, titleList).setInfiniteLoop(true));
                mViewFlow.setmSideBuffer(imageUrlList.size()); // 实际图片张数，
                // 我的ImageAdapter实际图片张数为3

                mViewFlow.setFlowIndicator(mFlowIndicator);
                mViewFlow.setTimeSpan(4500);
                mViewFlow.setSelection(imageUrlList.size() * 1000); // 设置初始位置
                mViewFlow.startAutoFlowTimer(); // 启动自动播放
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }


    private void loadListView(final Context context) {
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... strings) {

                HttpUtils http = new HttpUtils();
                http.send(HttpRequest.HttpMethod.GET,
                        "https://raw.githubusercontent.com/cdyandroid/hello-world/master/news",
                        new RequestCallBack<String>() {
                            @Override
                            public void onLoading(long total, long current, boolean isUploading) {

                            }

                            @Override
                            public void onSuccess(ResponseInfo<String> responseInfo) {
                                //ToastMaker.showShortToast(responseInfo.result);
                                Gson gson=new Gson();
                                wrrap = gson.fromJson(responseInfo.result, NewsItem.class);
                                pw.stopSpinning();
                                pw.setVisibility(View.GONE);
                                adapter=new MyNewsAdapter(context, wrrap.getList());
                                //news_important_lv.addFooterView(loading_llyt);
                                loading_llyt.setVisibility(View.GONE);
                                news_important_lv.setAdapter(adapter);

                                news_important_lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                                    @Override
                                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                                               new AsyncTask<Void, Void, Void>() {
                                                   @Override
                                                   protected Void doInBackground(Void... voids) {
                                                       return null;
                                                   }

                                                   @Override
                                                   protected void onPostExecute(Void aVoid) {
                                                       ToastMaker.showShortToast("没有更多数据");
                                                       adapter.notifyDataSetChanged();
                                                       news_important_lv.onRefreshComplete();
                                                       super.onPostExecute(aVoid);
                                                   }
                                               }.execute();
                                    }

                                    @Override
                                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                                                new AsyncTask<Void,Void,Void>(){
                                                    @Override
                                                    protected Void doInBackground(Void... voids) {
                                                        return null;
                                                    }

                                                    @Override
                                                    protected void onPostExecute(Void aVoid) {
                                                       if (!isLastRow && isMore){
                                                           wrrap.getList().addAll(wrrap.getList());

                                                           adapter.notifyDataSetChanged();
                                                           news_important_lv.onRefreshComplete();
                                                           isMore = false;
                                                       }else {
                                                           ToastMaker.showShortToast("没有更多数据");
                                                           adapter.notifyDataSetChanged();
                                                           news_important_lv.onRefreshComplete();
                                                       }

                                                        super.onPostExecute(aVoid);
                                                    }
                                                }.execute();

                                    }
                                });
                            }

                            @Override
                            public void onStart() {
                            }

                            @Override
                            public void onFailure(HttpException error, String msg) {
                                pw.stopSpinning();
                                pw.setVisibility(View.GONE);
                                ToastMaker.showShortToast("网络连接失败");
                            }
                        });
                return null;

            }

            @Override
            protected void onPostExecute(String s) {

            }
        }.execute();

    }

}














































