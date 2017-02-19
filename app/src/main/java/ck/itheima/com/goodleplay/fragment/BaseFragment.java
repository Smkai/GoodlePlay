package ck.itheima.com.goodleplay.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ck.itheima.com.goodleplay.R;

/**
 * 类名:    BaseFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 8:34
 * 包名:    ck.itheima.com.goodleplay.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    fragment 基类
 */

public abstract class BaseFragment extends Fragment {
    @BindView(R.id.pb_fragment)
    ProgressBar  mPbFragment;
    @BindView(R.id.load_retry)
    Button       mLoadRetry;
    @BindView(R.id.load_failed_container)
    LinearLayout mLoadFailedContainer;
    @BindView(R.id.layout_container)
    FrameLayout  mLayoutContainer;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_base, null);
        ButterKnife.bind(this, root);
        init();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        startLoadData();//加载数据
    }

    public void init() {

    }

    /**
     * 子类去实现该方法加载各自的数据
     */
    protected abstract void startLoadData();


    protected void onDataloadSuccess() {
        //隐藏进度条
        mPbFragment.setVisibility(View.GONE);
        //加载各个页面的布局
        mLayoutContainer.addView(onCreateContentView());
    }

    /**
     * 创建页面内容的视图，子类去实现各自的布局
     */
    protected abstract View onCreateContentView();

    protected void onDataLoadFailed() {
        //隐藏进度条
        mPbFragment.setVisibility(View.GONE);
        //显示错误布局
        mLoadFailedContainer.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.load_retry)
    public void retry() {
        //隐藏错误视图
        mLoadFailedContainer.setVisibility(View.GONE);
        //显示进度条
        mPbFragment.setVisibility(View.VISIBLE);
        //重新加载数据
        startLoadData();
    }
}


