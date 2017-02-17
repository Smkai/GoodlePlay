package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import ck.itheima.com.goodleplay.R;

/**
 * 类名:    LoadingMoreProgressView
 * 创建者:  ckqu
 * 创建时间:2017/2/17 0017 下午 12:26
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    进度圈的条目布局
 */

public class LoadingMoreProgressView extends LinearLayout {
    public LoadingMoreProgressView(Context context) {
        this(context, null);
    }

    public LoadingMoreProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_progress,this);

    }
}
