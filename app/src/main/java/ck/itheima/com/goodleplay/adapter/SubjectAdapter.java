package ck.itheima.com.goodleplay.adapter;

import android.content.Context;

import java.util.List;

import ck.itheima.com.goodleplay.bean.SubjectItemBean;
import ck.itheima.com.goodleplay.widgit.SubjectItemView;

/**
 * 类名:    SubjectAdapter
 * 创建者:  ckqu
 * 创建时间:2017/2/17 0017 下午 12:38
 * 包名:    ck.itheima.com.goodleplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    专题的适配器
 */

public class SubjectAdapter extends BaseLoadmoreAdapter<SubjectItemBean> {

    public SubjectAdapter(Context context, List<SubjectItemBean> dataList) {
        super(context, dataList);
    }

    @Override
    protected void onBindNormalViewHolder(ViewHolder holder, int position) {
        ((SubjectItemView)holder.mView).bindView(getDataList().get(position));

    }

    @Override
    protected ViewHolder onCreateNormalViewHolder() {
        return new ViewHolder(new SubjectItemView(getContext()));
    }
}
