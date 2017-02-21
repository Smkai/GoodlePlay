package ck.itheima.com.goodleplay.widgit;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.bean.AppDatailBean;
import ck.itheima.com.goodleplay.utils.UIUtils;

/**
 * 类名:    AppDetailDesView
 * 创建者:  ckqu
 * 创建时间:2017/2/21 0021 下午 7:50
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    App简介
 */

public class AppDetailDesView extends RelativeLayout {
    @BindView(R.id.app_des)
    TextView mAppDes;
    @BindView(R.id.app_name)
    TextView mAppName;
    @BindView(R.id.arrow)
    ImageView mArrow;
    private static final int DEFAULT_LINE_COUNT = 7;
    private int mMeasuredHeight;
    private boolean isOpen = false;

    public AppDetailDesView(Context context) {
        this(context, null);
    }

    public AppDetailDesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_app_detail_des, this);
        ButterKnife.bind(this, this);
    }

    public void bingView(AppDatailBean datas) {
        mAppDes.setText(datas.getDes());
        mAppName.setText(datas.getName());

        /*----------------------------得监听布局完成------------------------------*/
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {


            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int lineCount = mAppDes.getLineCount();
                mMeasuredHeight = mAppDes.getMeasuredHeight();

                if (lineCount > DEFAULT_LINE_COUNT) {
                    mAppDes.setLines(DEFAULT_LINE_COUNT);
                }


            }
        });

    }

    @OnClick(R.id.arrow)
    public void onClick() {
        if (isOpen){
            if (mAppDes.getLineCount() > DEFAULT_LINE_COUNT){
                mAppDes.setLines(7);
                mAppDes.measure(0, 0);
            }

            int end = mAppDes.getMeasuredHeight();

            UIUtils.animationViewHeight(mAppDes, mMeasuredHeight, end);
            UIUtils.rotateView(mArrow, 0, 180f);
        }else {
            int start = mAppDes.getHeight();

            UIUtils.animationViewHeight(mAppDes, start, mMeasuredHeight);
            UIUtils.rotateView(mArrow, 180f, 0);
        }

        isOpen = !isOpen;

    }
}
