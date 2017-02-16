package ck.itheima.com.goodleplay.fragment;

import android.widget.BaseAdapter;

import java.util.List;

import ck.itheima.com.goodleplay.adapter.CategoryAdapter;
import ck.itheima.com.goodleplay.bean.CategoryBean;
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
 * 描述:    分类
 */

public class CategoryFragment extends BaseListFragment {


    private List<CategoryBean> mDataList;

    @Override
    public BaseAdapter getAdapter() {
        return new CategoryAdapter(getContext(), mDataList);
    }

    @Override
    protected void startLoadData() {
        Call<List<CategoryBean>> listCall = HeiMaRetrofit.getInstance().getApi().listCategory();
        listCall.enqueue(new Callback<List<CategoryBean>>() {
            @Override
            public void onResponse(Call<List<CategoryBean>> call, Response<List<CategoryBean>> response) {
                mDataList =  response.body();
                onDataloadSuccess();
            }

            @Override
            public void onFailure(Call<List<CategoryBean>> call, Throwable t) {
                onDataLoadFailed();
            }
        });
    }
}
