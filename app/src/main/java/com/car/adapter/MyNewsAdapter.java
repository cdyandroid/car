package com.car.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.car.activity.R;
import com.car.entity.NewsItem;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2015-10-02.
 */
public class MyNewsAdapter extends BaseAdapter {
    private Context context;
    private List<NewsItem.ListEntity> list;
    private LayoutInflater layoutInflater = null;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    DisplayImageOptions options;
    public MyNewsAdapter(Context context, List<NewsItem.ListEntity> list) {
        this.context = context;
        this.list = list;
        layoutInflater = layoutInflater.from(context);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.drawable.ic_launcher)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.ic_launcher)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .build();//构建完成
    }
    public void refreshDatas(List<NewsItem.ListEntity> datas)
    {
        this.list = datas;
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        EntityHolder entityHolder = null;
        if ( view == null){
            entityHolder = new EntityHolder();
            view = layoutInflater.inflate(R.layout.news_item,null);
            ViewUtils.inject(entityHolder, view);
            view.setTag(entityHolder);
        }else {
            entityHolder = (EntityHolder)view.getTag();
        }
        NewsItem.ListEntity listEntity = list.get(i);
        entityHolder.item_tv_title.setText(listEntity.getTitle());
        ImageLoader.getInstance().displayImage("http://pic78.nipic.com/file/20150923/6021825_002715706002_2.jpg", entityHolder.item_iv_img,options);
        return view;
    }
    private class EntityHolder{
        @ViewInject(R.id.item_tv_title)
        TextView item_tv_title;
        @ViewInject(R.id.item_iv_img)
        ImageView item_iv_img;
    }
}
