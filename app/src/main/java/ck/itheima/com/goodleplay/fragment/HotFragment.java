package ck.itheima.com.goodleplay.fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.network.Api;
import ck.itheima.com.goodleplay.network.HeiMaRetrofit;
import ck.itheima.com.goodleplay.widgit.FlowLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 类名:    HomeFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 9:09
 * 包名:    ck.itheima.com.goodleplay.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    首页
 */

public class HotFragment extends BaseFragment {

    private List<String> mDataList;



    @Override
    protected void startLoadData() {
        Api api = HeiMaRetrofit.getInstance().getApi();
        Call<List<String>> listCall = api.listHot();
//        listCall.execute(); 同步网络请求
        listCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                mDataList = response.body();
                onDataloadSuccess();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                onDataLoadFailed();
            }
        });
    }

    @Override
    protected View onCreateContentView() {
        ScrollView scrollView = new ScrollView(getContext());

        FlowLayout flowLayout = new FlowLayout(getContext());//创建一个流式布局

        int padding = getResources().getDimensionPixelSize(R.dimen.padding);

        int textSize = getResources().getDimensionPixelSize(R.dimen.text_size);

        flowLayout.setPadding(padding,padding,padding,padding);//设置padding

        for (int i = 0; i < mDataList.size(); i++) {//循环添加内容(textView)

            TextView textView = getTextView(textSize,padding,i);

            final String s = mDataList.get(i);//点击对应的String

            GradientDrawable normalBg = new GradientDrawable();//设置圆角背景

            normalBg.setCornerRadius(10);//设置圆角

            Random random = new Random();//设置随机颜色
            int alpha = 255;
            int red = random.nextInt(190) + 30;//30-220
            int green = random.nextInt(190) + 30;//30-220
            int blue = random.nextInt(190) + 30;//30-220
            int argb = Color.argb(alpha, red, green, blue);
            normalBg.setColor(argb);

            GradientDrawable pressedBg = new GradientDrawable();//按下去的背景

            pressedBg.setColor(Color.DKGRAY);
            pressedBg.setCornerRadius(10);

            StateListDrawable selectBg = new StateListDrawable();


            selectBg.addState(new int[]{android.R.attr.state_pressed}, pressedBg);//按下去的状态

            selectBg.addState(new int[]{},normalBg);//默认状态

            textView.setBackgroundDrawable(selectBg);

            flowLayout.addView(textView);//添加到流布局

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), s , Toast.LENGTH_SHORT).show();
                }
            });
        }
          scrollView.addView(flowLayout);
        return scrollView;

    }

    public TextView getTextView(float textSize, int padding,int i) {
        TextView textview = new TextView(getContext());
        String mData =  mDataList.get(i);
        textview.setText(mData);
        textview.setTextSize(textSize);
        textview.setTextColor(Color.WHITE);
        textview.setPadding(padding, padding, padding, padding);//设置padding
        textview.setGravity(Gravity.CENTER);
        textview.setClickable(true);

        return textview;
    }
}
