package ck.itheima.com.goodleplay.fragment;

import android.view.View;

import com.leon.loopviewpagerlib.FunBanner;

import java.util.List;

import ck.itheima.com.goodleplay.app.Constans;
import ck.itheima.com.goodleplay.base.BaseAppListFragment;
import ck.itheima.com.goodleplay.bean.HomeBean;
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
 * 描述:    首页
 */

public class HomeFragment extends BaseAppListFragment {

    private List<String> mPicture;

    @Override
    protected void starLoadMoreData() {
        Call<HomeBean> homeBeanCall = HeiMaRetrofit.getInstance().getApi().listHome(getDataList().size());
        homeBeanCall.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {

                getDataList().addAll(response.body().getList());

                getAdatpe().notifyDataSetChanged();//更新界面
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {

            }
        });

    }

    @Override
    protected void startLoadData() {
        Call<HomeBean> homeBeanCall = HeiMaRetrofit.getInstance().getApi().listHome(0);
        homeBeanCall.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                mPicture =  response.body().getPicture();//轮播图的集合
                getDataList().addAll(response.body().getList());
                onDataloadSuccess();
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                onDataLoadFailed();
            }
        });
    }

    @Override
    public View AddHead() {
        FunBanner banner = new FunBanner(getContext());

        banner.setRatio(0.377f);//设置宽高比

        banner.setEnableAutoLoop(true);//设置自动轮播

        banner.setImageUrlHost(Constans.BASE_IMAGEUR);//拼接url

        banner.setImageUrls(mPicture);//图片的集合

        return banner;
    }
}
