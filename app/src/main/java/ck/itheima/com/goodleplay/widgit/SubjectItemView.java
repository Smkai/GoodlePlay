package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.app.Constans;
import ck.itheima.com.goodleplay.bean.SubjectItemBean;

/**
 * 类名:    SubjectItemView
 * 创建者:  ckqu
 * 创建时间:2017/2/17 0017 下午 12:44
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    专题的条目
 */

public class SubjectItemView extends RelativeLayout {
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.title)
    TextView  mTitle;

    public SubjectItemView(Context context) {
        this(context, null);
    }

    public SubjectItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_subject_view, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(SubjectItemBean subjectItemBean) {
        mTitle.setText(subjectItemBean.getDes());
        String iconUrl = Constans.BASE_IMAGEUR + subjectItemBean.getUrl();
        Glide.with(getContext()).load(iconUrl).centerCrop().into(mIcon);
    }
}
