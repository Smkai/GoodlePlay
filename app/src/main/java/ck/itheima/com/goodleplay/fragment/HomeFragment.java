package ck.itheima.com.goodleplay.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * 类名:    HomeFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 9:09
 * 包名:    ck.itheima.com.goodleplay.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    首页
 */

public class HomeFragment extends BaseFragment {
    @Override
    protected void startLoadData() {

    }

    @Override
    protected View onCreateContentView() {
        TextView tv = new TextView(getActivity());
                tv.setGravity(Gravity.CENTER);
                tv.setTextColor(Color.BLUE);
                tv.setText(this.getClass()
                        .getSimpleName());
                return tv;

    }
}
