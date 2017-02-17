package ck.itheima.com.goodleplay.base;

import android.widget.AbsListView;

import ck.itheima.com.goodleplay.fragment.BaseListFragment;

/**
 * 类名:    BaseLoadmoreListFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/17 0017 上午 10:44
 * 包名:    ck.itheima.com.goodleplay.base
 * 更新者:  $Author$ $Date$
 * 描述:    带有下拉刷新功能的fragment
 */

public abstract class BaseLoadmoreListFragment extends BaseListFragment {
    @Override
    protected void initListView() {
        super.initListView();
        getListView().setOnScrollListener(mOnScrollListener);
    }

    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (getListView().getLastVisiblePosition() == getAdatpe().getCount() - 1){
                starLoadMoreData();//加载更多数据 让子类自行完成
            }

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    };

    protected abstract void starLoadMoreData();
}
