package ck.itheima.com.goodleplay.fragment;

import android.view.View;
import android.widget.Toast;

import java.util.List;

import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.adapter.RecommendAdapter;
import ck.itheima.com.goodleplay.network.HeiMaRetrofit;
import ck.itheima.com.goodleplay.widgit.StellarMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 类名:    HomeFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 9:09
 * 包名:    ck.itheima.com.goodleplay.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    推荐
 */

public class RecommendFragment extends BaseFragment {
    private List<String> mDataList;

    @Override
    protected void startLoadData() {
        Call<List<String>> listCall = HeiMaRetrofit.getInstance().getApi().listReconmend();
        listCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

                mDataList =  response.body();

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
        StellarMap stellarMap = new StellarMap(getContext());
        stellarMap.setAdapter(new RecommendAdapter(getContext(),mDataList));
        int padding = getResources().getDimensionPixelSize(R.dimen.padding);
        //设置星状图内部padding
        stellarMap.setInnerPadding(padding, padding, padding, padding);
        //设置布局网格15*20，越大分布越平均
        stellarMap.setRegularity(15, 20);
        //设置初始化组
        stellarMap.setGroup(0, false);
        return stellarMap;

    }
}
