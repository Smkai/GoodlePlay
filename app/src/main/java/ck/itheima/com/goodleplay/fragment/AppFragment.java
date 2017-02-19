package ck.itheima.com.goodleplay.fragment;

import java.util.List;

import ck.itheima.com.goodleplay.base.AppListBean;
import ck.itheima.com.goodleplay.base.BaseAppListFragment;
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
 * 描述:    应用
 */

public class AppFragment extends BaseAppListFragment {

    @Override
    protected void starLoadMoreData() {
        Call<List<AppListBean>> listCall = HeiMaRetrofit.getInstance().getApi().listApp(mDataList.size());
        listCall.enqueue(new Callback<List<AppListBean>>() {
            @Override
            public void onResponse(Call<List<AppListBean>> call, Response<List<AppListBean>> response) {
                getDataList().addAll(response.body());
                getAdatpe().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AppListBean>> call, Throwable t) {

            }
        });

    }

    @Override
    protected void startLoadData() {
        Call<List<AppListBean>> listCall = HeiMaRetrofit.getInstance().getApi().listApp(0);
        listCall.enqueue(new Callback<List<AppListBean>>() {
            @Override
            public void onResponse(Call<List<AppListBean>> call, Response<List<AppListBean>> response) {
                getDataList().addAll(response.body());
                onDataloadSuccess();
            }

            @Override
            public void onFailure(Call<List<AppListBean>> call, Throwable t) {
               onDataLoadFailed();
            }
        });
    }
}
