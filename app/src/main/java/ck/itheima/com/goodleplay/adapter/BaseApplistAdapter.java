package ck.itheima.com.goodleplay.adapter;

import android.content.Context;

import java.util.List;

import ck.itheima.com.goodleplay.base.AppListBean;
import ck.itheima.com.goodleplay.widgit.AppItemView;

/**
 * 类名:    BaseApplistAdapter
 * 创建者:  ckqu
 * 创建时间:2017/2/18 0018 下午 12:37
 * 包名:    ck.itheima.com.goodleplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    游戏 应用 首页 的adapter
 */

public class BaseApplistAdapter extends BaseLoadmoreAdapter<AppListBean> {


    private List<AppListBean> mDataList;

    public BaseApplistAdapter(Context context, List<AppListBean> dataList) {
        super(context, dataList);
        mDataList = dataList;
    }

    @Override
    protected void onBindNormalViewHolder(ViewHolder holder, int position) {
        ((AppItemView)holder.mView).bingView(mDataList.get(position));
    }

    @Override
    protected ViewHolder onCreateNormalViewHolder() {
        return new ViewHolder(new AppItemView(getContext()));
    }

   /* @Override
    protected void onBindViewholder(ViewHolder holder, int position) {
        ((AppItemView)holder.mView).bingView(mDataList.get(position));
    }

    @Override
    protected void onBindNormalViewHolder(ViewHolder holder, int position) {

    }

    @Override
    ViewHolder onCreateViewholder(int position) {
        return new ViewHolder(new AppItemView(getContext()));
    }

    @Override
    protected ViewHolder onCreateNormalViewHolder() {
        return null;
    }*/

}
