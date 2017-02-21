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
import ck.itheima.com.goodleplay.bean.AppDatailBean;

/**
 * 类名:    AppDatailInfoView
 * 创建者:  ckqu
 * 创建时间:2017/2/20 0020 上午 11:38
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:
 */

public class AppDatailInfoView extends RelativeLayout {
    @BindView(R.id.datail_icon)
    ImageView mDatailIcon;
    @BindView(R.id.datail_name)
    TextView  mDatailName;
    @BindView(R.id.datal_rating_bar)
    RatingBar mDatalRatingBar;
    @BindView(R.id.download_count)
    TextView  mDownloadCount;
    @BindView(R.id.app_timestamp)
    TextView  mAppTimestamp;
    @BindView(R.id.version_code)
    TextView  mVersionCode;
    @BindView(R.id.app_size)
    TextView  mAppSize;

    public AppDatailInfoView(Context context) {
        this(context, null);
    }

    public AppDatailInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_app_datail_info, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppDatailBean datas) {//赋值
         mDatailName.setText(datas.getName());
         mDatalRatingBar.setRating((float) datas.getStars());//星星

        String iconUrl = Constans.BASE_IMAGEUR + datas.getIconUrl();
        Glide.with(getContext()).load(iconUrl).placeholder(R.drawable.ic_default).into(mDatailIcon);

        String downloadcount = String.format(getResources().getString(R.string.download_count),datas.getDownloadNum());
        mDownloadCount.setText(downloadcount);

        String dates = String.format(getResources().getString(R.string.time),datas.getDate());
        mAppTimestamp.setText(dates);

        String size = String.format(getResources().getString(R.string.app_size),Formatter.formatFileSize(getContext(),datas.getSize()));
        mAppSize.setText(size);

        String versionCode = String.format(getResources().getString(R.string.version_code), datas.getVersion());
        mVersionCode.setText(versionCode);


    }
}
