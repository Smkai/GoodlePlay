package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.app.Constans;
import ck.itheima.com.goodleplay.bean.AppDatailBean;
import ck.itheima.com.goodleplay.utils.UIUtils;

/**
 * 类名:    AppDetailSecurityView
 * 创建者:  ckqu
 * 创建时间:2017/2/20 0020 下午 3:42
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:
 */

public class AppDetailSecurityView extends RelativeLayout {
    @BindView(R.id.tags_container)
    LinearLayout mTagsContainer;
    @BindView(R.id.des_container)
    LinearLayout mDesContainer;
    @BindView(R.id.iv_secerity)
    ImageView    mIvSecerity;
    private boolean isOpen = false;

    public AppDetailSecurityView(Context context) {
        this(context, null);
    }

    public AppDetailSecurityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_app_detail_security, this);
        ButterKnife.bind(this, this);

    }

    public void bindView(AppDatailBean datas) {
        for (int i = 0; i < datas.getSafe().size(); i++) {
            /*---------------------------加安全 无广告-------------------------*/
            AppDatailBean.SafeBean safeBean = datas.getSafe().get(i);
            String iconUrl = Constans.BASE_IMAGEUR + safeBean.getSafeUrl();

            ImageView tag = new ImageView(getContext());
            Glide.with(getContext()).load(iconUrl).override(Target.SIZE_ORIGINAL, Target
                    .SIZE_ORIGINAL).into(tag);

            mTagsContainer.addView(tag);
            /*----------------------------加描述------------------------------*/

            LinearLayout ll = new LinearLayout(getContext());
            ll.setOrientation(LinearLayout.HORIZONTAL);
            String desUrl = Constans.BASE_IMAGEUR + safeBean.getSafeDesUrl();

            ImageView des = new ImageView(getContext());
            Glide.with(getContext()).load(desUrl).override(Target.SIZE_ORIGINAL, Target
                    .SIZE_ORIGINAL).into(des);//图片

            ll.addView(des);//加图片

            TextView desTv = new TextView(getContext());
            desTv.setText(safeBean.getSafeDes());
            ll.addView(desTv);//加文本

            mDesContainer.addView(ll);//添加到容器中


        }
    }

    @OnClick(R.id.iv_secerity)
    public void onClick() {
        if(isOpen){
            //关闭
            int measuredHeight = mDesContainer.getMeasuredHeight();
            UIUtils.animationViewHeight(mDesContainer, measuredHeight, 0);
            UIUtils.rotateView(mIvSecerity, 180f, 0);
        }else {
            //打开  高度从0到展开高度
            mDesContainer.measure(0,0);//
            int measuredHeight = mDesContainer.getMeasuredHeight();
            UIUtils.animationViewHeight(mDesContainer, 0, measuredHeight);
            UIUtils.rotateView(mIvSecerity, 0, 180f);
        }

        isOpen = !isOpen;
    }
}
