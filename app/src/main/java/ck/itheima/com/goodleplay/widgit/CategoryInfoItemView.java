package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.app.Constans;

/**
 * 类名:    CategoryInfoItemView
 * 创建者:  ckqu
 * 创建时间:2017/2/16 0016 下午 7:57
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    分类Item里面的Item
 */

public class CategoryInfoItemView extends LinearLayout {
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.title)
    TextView  mTitle;

    public CategoryInfoItemView(Context context) {
        this(context, null);
    }

    public CategoryInfoItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_category_info, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(String name, String url) {
        mTitle.setText(name);
        String iconUrl = Constans.BASE_IMAGEUR + url;
        Glide.with(getContext()).load(iconUrl).placeholder(R.drawable.ic_default).into(mIcon);

    }
}
