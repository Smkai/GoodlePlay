package ck.itheima.com.goodleplay.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.bean.AppDatailBean;
import ck.itheima.com.goodleplay.network.HeiMaRetrofit;
import ck.itheima.com.goodleplay.widgit.AppDatailInfoView;
import ck.itheima.com.goodleplay.widgit.AppDetailSecurityView;
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

    private AppDatailBean mDatas;

    @Override
    protected void startLoadData() {//加载数据
        String package_name = getActivity().getIntent().getStringExtra("package_name");


        Call<AppDatailBean> appDatail = HeiMaRetrofit.getInstance().getApi().getAppDatail(package_name);
        appDatail.enqueue(new Callback<AppDatailBean>() {
            @Override
            public void onResponse(Call<AppDatailBean> call, Response<AppDatailBean> response) {
                mDatas = response.body();
                Toast.makeText(getContext(), mDatas.getName(), Toast.LENGTH_SHORT).show();
                onDataloadSuccess();
            }

            @Override
            public void onFailure(Call<AppDatailBean> call, Throwable t) {
                onDataLoadFailed();
            }
        });
    }

    @Override
    protected View onCreateContentView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(getContext());



        LinearLayout linearlayoutInfoScrollView = new LinearLayout(getContext());
        linearlayoutInfoScrollView.setOrientation(LinearLayout.VERTICAL);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.padding);


        AppDatailInfoView appDatailInfoView = new AppDatailInfoView(getContext());//加app信息
        appDatailInfoView.bindView(mDatas);
        linearlayoutInfoScrollView.addView(appDatailInfoView);

        AppDetailSecurityView appDetailSecurityView = new AppDetailSecurityView(getContext());//加安全的信息
        appDetailSecurityView.bindView(mDatas);
        appDetailSecurityView.setLayoutParams(layoutParams);
        linearlayoutInfoScrollView.addView(appDetailSecurityView);




        scrollView.addView(linearlayoutInfoScrollView);
        linearLayout.addView(scrollView);

        return linearLayout;
    }
}
