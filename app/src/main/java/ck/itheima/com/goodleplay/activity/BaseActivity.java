package ck.itheima.com.goodleplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 类名:    BaseActivity
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 3:32
 * 包名:    ck.itheima.com.goodleplay.activity
 * 更新者:  $Author$ $Date$
 * 描述:    activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);//加载控件
        init();

    }

    protected  void init(){//初始化方法

    }

    public abstract int getLayoutId();//子类视图
}
