package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import ck.itheima.com.goodleplay.R;

/**
 * 类名:    CircleDownloadView
 * 创建者:  ckqu
 * 创建时间:2017/2/19 0019 下午 9:52
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    下载的按钮
 */

public class CircleDownloadView extends RelativeLayout {
    public CircleDownloadView(Context context) {
        this(context, null);
    }

    public CircleDownloadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_cirle_download,this);
    }
}
