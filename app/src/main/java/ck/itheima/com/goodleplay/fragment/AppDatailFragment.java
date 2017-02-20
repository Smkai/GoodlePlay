package ck.itheima.com.goodleplay.fragment;

import android.view.View;
import android.widget.Toast;

import ck.itheima.com.goodleplay.bean.AppDatailBean;
import ck.itheima.com.goodleplay.network.HeiMaRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 类名:    AppDatailFragment
 * 创建者:  ckqu
 * 创建时间:2017/2/20 0020 上午 10:07
 * 包名:    ck.itheima.com.goodleplay.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class AppDatailFragment extends BaseFragment {
    @Override
    protected void startLoadData() {//加载数据
        String package_name = getActivity().getIntent().getStringExtra("package_name");


        Call<AppDatailBean> appDatail = HeiMaRetrofit.getInstance().getApi().getAppDatail(package_name);
        appDatail.enqueue(new Callback<AppDatailBean>() {
            @Override
            public void onResponse(Call<AppDatailBean> call, Response<AppDatailBean> response) {
                AppDatailBean datas = response.body();
                Toast.makeText(getContext(), datas.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<AppDatailBean> call, Throwable t) {

            }
        });
    }

    @Override
    protected View onCreateContentView() {
        return null;
    }
}
