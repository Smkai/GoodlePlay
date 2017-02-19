package ck.itheima.com.goodleplay.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import ck.itheima.com.goodleplay.widgit.StellarMap;

/**
 * 类名:    RecommendAdapter
 * 创建者:  ckqu
 * 创建时间:2017/2/16 0016 下午 4:52
 * 包名:    ck.itheima.com.goodleplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    推荐页面的Adapter   StellarMap
 */

public class RecommendAdapter implements StellarMap.Adapter {
    private Context mContext;
    private List<String> mMDataList;
    private static final int PAGE_SIZE = 15;
    private int mRandomColor;
    private final Random mRandom;


    public RecommendAdapter(Context context, List<String> mDataList) {
        mContext = context;
        mMDataList = mDataList;
        mRandom = new Random();
    }

    @Override
    public int getGroupCount() {
        int pageCount = mMDataList.size() / PAGE_SIZE;
        if (mMDataList.size() % PAGE_SIZE != 0){
            pageCount++;
        }

        return pageCount;
    }

    @Override
    public int getCount(int group) {
        if (mMDataList.size() % PAGE_SIZE != 0){
            if (group == getGroupCount() -1 ){
                return mMDataList.size() % PAGE_SIZE;
            }
        }
        return PAGE_SIZE;
    }

    @Override
    public View getView(int group, int position, View convertView) {
        if (convertView == null) {
            convertView = new TextView(mContext);
        }
        TextView textView = (TextView) convertView;//强转
        int index = group * PAGE_SIZE + position;//获取对应数据
        textView.setText(mMDataList.get(index));
        textView.setTextColor(getRandomColor());//设置颜色
        float size = 12 + mRandom.nextInt(8);//字体大小
        textView.setTextSize(size);//设置字体大小
        return convertView;
    }

    @Override
    public int getNextGroupOnPan(int group, float degree) {
        return 0;
    }

    @Override
    public int getNextGroupOnZoom(int group, boolean isZoomIn) {
        if (isZoomIn){
            return (group + 1) % getGroupCount();
        }else {//缩小
            return  (group - 1 + getGroupCount()) % getGroupCount();
        }

    }

    public int getRandomColor() {
        int alpha = 255;
        int red = 30 + mRandom.nextInt(190);//30 - 220
        int green = 30 + mRandom.nextInt(190);//30 - 220
        int blue = 30 + mRandom.nextInt(190);//30 - 220
        return Color.argb(alpha, red, green, blue);
    }
}
