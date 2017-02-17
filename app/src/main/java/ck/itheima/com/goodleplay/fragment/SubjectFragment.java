package ck.itheima.com.goodleplay.fragment;

import android.widget.BaseAdapter;

import java.util.List;

import ck.itheima.com.goodleplay.adapter.SubjectAdapter;
import ck.itheima.com.goodleplay.base.BaseLoadmoreListFragment;
import ck.itheima.com.goodleplay.bean.SubjectItemBean;
import ck.itheima.com.goodleplay.network.HeiMaRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 类名:    HomeFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 9:09
 * 包名:    ck.itheima.com.goodleplay.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    专题
 */

public class SubjectFragment extends BaseLoadmoreListFragment {

    private List<SubjectItemBean> mDataList;


    @Override
    protected void starLoadMoreData() {
        Call<List<SubjectItemBean>> listCall = HeiMaRetrofit.getInstance().getApi().listSubject(mDataList.size());
        listCall.enqueue(new Callback<List<SubjectItemBean>>() {
            @Override
            public void onResponse(Call<List<SubjectItemBean>> call, Response<List<SubjectItemBean>> response) {
                mDataList.addAll(response.body());
                getAdatpe().notifyDataSetChanged();//刷新界面
            }

            @Override
            public void onFailure(Call<List<SubjectItemBean>> call, Throwable t) {

            }
        });


    }

    @Override
    public BaseAdapter getAdapter() {
        return new SubjectAdapter(getContext(),mDataList);
    }

    @Override
    protected void startLoadData() {
        Call<List<SubjectItemBean>> listCall = HeiMaRetrofit.getInstance().getApi().listSubject(0);
        listCall.enqueue(new Callback<List<SubjectItemBean>>() {
            @Override
            public void onResponse(Call<List<SubjectItemBean>> call, Response<List<SubjectItemBean>> response) {
                mDataList = response.body();
                onDataloadSuccess();
            }

            @Override
            public void onFailure(Call<List<SubjectItemBean>> call, Throwable t) {
               onDataLoadFailed();
            }
        });
    }
}
