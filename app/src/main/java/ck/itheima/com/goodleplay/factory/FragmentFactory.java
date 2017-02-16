package ck.itheima.com.goodleplay.factory;

import android.support.v4.app.Fragment;

import ck.itheima.com.goodleplay.fragment.AppFragment;
import ck.itheima.com.goodleplay.fragment.CategoryFragment;
import ck.itheima.com.goodleplay.fragment.GameFragment;
import ck.itheima.com.goodleplay.fragment.HomeFragment;
import ck.itheima.com.goodleplay.fragment.HotFragment;
import ck.itheima.com.goodleplay.fragment.RecommendFragment;
import ck.itheima.com.goodleplay.fragment.SubjectFragment;

/**
 * 类名:    FragmentFactory
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 8:28
 * 包名:    ck.itheima.com.goodleplay.factory
 * 更新者:  $Author$ $Date$
 * 描述:    fragment工厂
 */

public class FragmentFactory {


    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_APP = 1;
    private static final int FRAGMENT_GAME = 2;
    private static final int FRAGMENT_SUBJECT = 3;
    private static final int FRAGMENT_RECOMMEND = 4;
    private static final int FRAGMENT_CATEGORY = 5;
    private static final int FRAGMENT_HOT = 6;

    private static FragmentFactory mFragmentFactory;

    private FragmentFactory(){};

    public static FragmentFactory getInstance(){
        if (mFragmentFactory == null){
            synchronized (FragmentFactory.class){
                if (mFragmentFactory == null){
                  mFragmentFactory = new FragmentFactory();
                }
            }
        }

        return mFragmentFactory;
    }

    public Fragment getFragment(int pos){
        switch (pos) {
            case FRAGMENT_HOME:
                return new HomeFragment();
            case FRAGMENT_APP:
                return new AppFragment();
            case FRAGMENT_GAME:
                return new GameFragment();
            case FRAGMENT_CATEGORY:
                return new CategoryFragment();
            case FRAGMENT_HOT:
                return new HotFragment();
            case FRAGMENT_RECOMMEND:
                return new RecommendFragment();
            case FRAGMENT_SUBJECT:
                return new SubjectFragment();
        }
        return null;
    }
}
