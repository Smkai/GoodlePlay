package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.app.Constans;
import ck.itheima.com.goodleplay.base.AppListBean;

/**
 * 类名:    AppItemView
 * 创建者:  ckqu
 * 创建时间:2017/2/18 0018 下午 1:01
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    appitmeView
 */

public class AppItemView extends RelativeLayout {


    @BindView(R.id.iv_app_icon)
    ImageView mIvAppIcon;
    @BindView(R.id.tv_app_name)
    TextView  mTvAppName;
    @BindView(R.id.rb_app_xing)
    RatingBar mRbAppXing;
    @BindView(R.id.tv_app_big)
    TextView  mTvAppBig;
    @BindView(R.id.tv_app_present)
    TextView  mTvAppPresent;

    public AppItemView(Context context) {
        this(context, null);
    }

    public AppItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.app_item_view, this);
        ButterKnife.bind(this, this);
    }

    public void bingView(AppListBean appListBean) {
        mTvAppName.setText(appListBean.name);
        String iconUrl = Constans.BASE_IMAGEUR + appListBean.getIconUrl();

        Glide.with(getContext()).load(iconUrl).placeholder(R.drawable.ic_default).into(mIvAppIcon);

        mTvAppPresent.setText(appListBean.des);

        mTvAppBig.setText(Formatter.formatFileSize(getContext(),appListBean.size));

        mRbAppXing.setRating((float) appListBean.stars);



    }
}
