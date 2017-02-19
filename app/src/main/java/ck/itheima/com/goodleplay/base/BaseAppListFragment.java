package ck.itheima.com.goodleplay.base;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import ck.itheima.com.goodleplay.adapter.BaseApplistAdapter;

/**
 * 类名:    BaseAppListFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/18 0018 下午 12:34
 * 包名:    ck.itheima.com.goodleplay.base
 * 更新者:  $Author$ $Date$
 * 描述:    游戏/应用/首页的baseFragment
 */

public abstract class BaseAppListFragment extends BaseLoadmoreListFragment {

    /**
     * 游戏 应用 首页的item一样 所以Adapter一样  只是传入不同的数据集合
     */

    public List<AppListBean> mDataList= new ArrayList<>();

    @Override
    public BaseAdapter getAdapter() {
        return new BaseApplistAdapter(getContext(),mDataList);
    }

    public List<AppListBean> getDataList() {
        return mDataList;
    }


}
