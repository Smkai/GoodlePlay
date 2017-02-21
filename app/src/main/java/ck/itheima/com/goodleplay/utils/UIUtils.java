package ck.itheima.com.goodleplay.utils;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类名:    UIUtils
 * 创建者:  ckqu
 * 创建时间:2017/2/21 0021 下午 6:47
 * 包名:    ck.itheima.com.goodleplay.utils
 * 更新者:  $Author$ $Date$
 * 描述:    展开动画的工具类
 */

public class UIUtils {

    public static void animationViewHeight(final View view, int start, int end ){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(start,end);//生成动画需要的数据序列
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (int)animation.getAnimatedValue();
                view.setLayoutParams(layoutParams);//改变高度
            }
        });
        valueAnimator.start();
    }

    public static void rotateView(View view, float start, float end ){
        //旋转箭头
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "rotation", start, end);
        objectAnimator.start();
    }
}
