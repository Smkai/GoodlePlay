package ck.itheima.com.goodleplay.fragment;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * 类名:    BaseListFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/16 0016 下午 6:25
 * 包名:    ck.itheima.com.goodleplay.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    listview fragment
 */

public abstract class BaseListFragment extends BaseFragment {
    private ListView    mListView;
    private BaseAdapter mBaseAdatper;


    @Override
    protected View onCreateContentView() {
        mListView = new ListView(getContext());
        mBaseAdatper = getAdapter();
        mListView.setAdapter(mBaseAdatper);
        mListView.setDivider(null);//去掉分割线
        initListView();
        return mListView;
    }

    protected void initListView(){}

    public abstract BaseAdapter getAdapter();

    public ListView getListView() {
        return mListView;
    }

    public BaseAdapter getBaseAdatper() {
        return mBaseAdatper;
    }

}
