package ck.itheima.com.goodleplay.adapter;

import android.content.Context;

import java.util.List;

import ck.itheima.com.goodleplay.bean.CategoryBean;
import ck.itheima.com.goodleplay.widgit.CategoryItemView;

/**
 * 类名:    CategoryAdapter
 * 创建者:  ckqu
 * 创建时间:2017/2/16 0016 下午 7:01
 * 包名:    ck.itheima.com.goodleplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    分类的adapter
 */

public class CategoryAdapter extends BaseListAdapter<CategoryBean> {

    public CategoryAdapter(Context context, List<CategoryBean> dataList) {
        super(context, dataList);
    }

    @Override
    protected void onBindViewholder(ViewHolder holder, int position) {
        ((CategoryItemView)holder.mView).bindView(getDataList().get(position));
    }

    @Override
    ViewHolder onCreateViewholder(int position) {

        return new ViewHolder(new CategoryItemView(getContext()));
    }
}
