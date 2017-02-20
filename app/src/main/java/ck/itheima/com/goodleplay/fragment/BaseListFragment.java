package ck.itheima.com.goodleplay.fragment;

import android.view.View;
import android.widget.AdapterView;
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

        View view = AddHead();//给listView添加一个头
        if (view != null){
            mListView.addHeaderView(view);
        }

        mListView.setAdapter(mBaseAdatper);
        mListView.setDivider(null);//去掉分割线

        mListView.setOnItemClickListener(mListener);//listView Item的点击事件

        initListView();
        return mListView;
    }

    private AdapterView.OnItemClickListener mListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              onListItemClick(position);
        }
    };

    /**
     * 点击事件 子类可以自己去实现
     * @param position
     */

    protected void onListItemClick(int position) {
    }


    protected void initListView(){}

    public abstract BaseAdapter getAdapter();

    public ListView getListView() {
        return mListView;
    }

    public BaseAdapter getAdatpe() {
        return mBaseAdatper;
    }
    public View AddHead(){
        return null;
    }


}
