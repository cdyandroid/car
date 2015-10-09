package com.car.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.car.activity.R;
import com.car.entity.NewsItem;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2015-10-01.
 */
public class NewsItemAdapter extends SimpleBaseAdapter<NewsItem.ListEntity> {
    public NewsItemAdapter(Context c, List<NewsItem.ListEntity> datas) {
        super(c, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EntityHolder entityHolder = null;
        if ( convertView == null){
           entityHolder = new EntityHolder();
            convertView = layoutInflater.inflate(R.layout.news_item,null);
            ViewUtils.inject(entityHolder,convertView);
            convertView.setTag(entityHolder);
        }else {
            entityHolder = (EntityHolder)convertView.getTag();
        }
        entityHolder.item_tv_title.setText(datas.get(position).getTitle());
        return convertView;
    }
    private class EntityHolder{
        @ViewInject(R.id.item_tv_title)
        TextView item_tv_title;
    }
}
















































