package ck.itheima.com.goodleplay.adapter;

import android.content.Context;

import java.util.List;

import ck.itheima.com.goodleplay.widgit.LoadingMoreProgressView;

/**
 * 类名:    BaseLoadmoreAdapter
 * 创建者:  ckqu
 * 创建时间:2017/2/17 0017 下午 12:17
 * 包名:    ck.itheima.com.goodleplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    带有进度圈的Adapter
 */

public abstract class BaseLoadmoreAdapter<T> extends BaseListAdapter<T> {
    private static final int ITEM_TYPE_NORMAL = 0;
    private static final int ITEM_TYPE_PROGRESS = 1;


    public BaseLoadmoreAdapter(Context context, List<T> dataList) {
        super(context, dataList);
    }

    @Override
    protected void onBindViewholder(ViewHolder holder, int position) {
         if (getItemViewType(position) == ITEM_TYPE_NORMAL){
             onBindNormalViewHolder(holder, position);
         }

    }

    /**
     * 绑定的封装 进度圈不需要绑定
     * @param holder
     * @param position
     */
    protected abstract void onBindNormalViewHolder(ViewHolder holder, int position);

    @Override
    ViewHolder onCreateViewholder(int position) {
        if (getItemViewType(position) == ITEM_TYPE_PROGRESS){
          return  new ViewHolder(new LoadingMoreProgressView(getContext()));
        }
        return onCreateNormalViewHolder();
    }

    protected abstract ViewHolder onCreateNormalViewHolder();

    @Override
    public int getViewTypeCount() {//返回不同类型的个数
        return 2;
    }

    @Override
    public int getCount() {
        if (getDataList() != null){
            return getDataList().size() + 1;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {//返回不同位置的itme类型
        if (position == getCount() -1){
            return ITEM_TYPE_PROGRESS;//最后一个条目就返回进度圈
        }
        return ITEM_TYPE_NORMAL;
    }
}
