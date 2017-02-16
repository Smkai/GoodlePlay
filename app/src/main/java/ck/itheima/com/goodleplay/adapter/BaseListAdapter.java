package ck.itheima.com.goodleplay.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 类名:    BaseListAdapter
 * 创建者:  ckqu
 * 创建时间:2017/2/16 0016 下午 6:39
 * 包名:    ck.itheima.com.goodleplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    list adapter的基类
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {


    private Context mContext;



    private List<T> mDataList;

    public BaseListAdapter(Context context, List<T> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public int getCount() {
        if (mDataList != null){
            return mDataList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mDataList != null){
            return mDataList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = onCreateViewholder(position);
            holder.mView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //绑定视图
        onBindViewholder(holder,position);

        return holder.mView;
    }



    class ViewHolder{
        View mView;

        public ViewHolder(View view) {
            mView = view;
        }


    }
    /**
     *
     * @param holder 要绑定的viewholder
     * @param position 要绑定viewholder的下标 通过下标获取对应位置的数据，去绑定holder hold住的view
     */
    protected abstract void onBindViewholder(ViewHolder holder, int position);


    abstract ViewHolder onCreateViewholder(int position);//子类去创建一个viewholder

    public Context getContext() {
        return mContext;
    }

    public List<T> getDataList() {
        return mDataList;
    }
}
