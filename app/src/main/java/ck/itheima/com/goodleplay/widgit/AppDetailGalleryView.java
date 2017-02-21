package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.app.Constans;
import ck.itheima.com.goodleplay.bean.AppDatailBean;

/**
 * 类名:    AppDetailGalleryView
 * 创建者:  ckqu
 * 创建时间:2017/2/21 0021 下午 7:16
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    Gallery 图片
 */

public class AppDetailGalleryView extends RelativeLayout {
    @BindView(R.id.ll_gallery)
    LinearLayout mLlGallery;

    public AppDetailGalleryView(Context context) {
        this(context, null);
    }

    public AppDetailGalleryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_app_detail_gallery, this);
        ButterKnife.bind(this, this);

    }

    public void bindView(AppDatailBean datas) {
        for (int i = 0; i < datas.getScreen().size(); i++) {
            String url = datas.getScreen().get(i);
            String iconUrl = Constans.BASE_IMAGEUR + url;
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup
                    .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i != 0){
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.padding);
            }

            imageView.setLayoutParams(layoutParams);
            mLlGallery.addView(imageView);

            Glide.with(getContext()).load(iconUrl).override(Target.SIZE_ORIGINAL,Target
                    .SIZE_ORIGINAL).into(imageView);


        }

    }
}
