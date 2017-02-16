package ck.itheima.com.goodleplay.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ck.itheima.com.goodleplay.factory.FragmentFactory;

/**
 * 类名:    MainViewPagerAdapter
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 8:24
 * 包名:    ck.itheima.com.goodleplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitle;

    public MainViewPagerAdapter(FragmentManager fm, String[] title) {
        super(fm);
        mTitle = title;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getInstance().getFragment(position);
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    /**
     * 返回tablayout的对应位置的标题
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
