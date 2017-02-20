package ck.itheima.com.goodleplay.base;

import android.content.Intent;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import ck.itheima.com.goodleplay.activity.AppDataActivity;
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

    /**
     * 首页 应用 游戏  都有一样的Item点击事件 所以在父类里面实现
     * @param position
     */
    @Override
    protected void onListItemClick(int position) {
        Intent intent = new Intent(getContext(), AppDataActivity.class);
        intent.putExtra("package_name", getPackageName(position));
        startActivity(intent);
    }

    protected String getPackageName(int position) {
        return getDataList().get(position).getPackageName();
    }
}
