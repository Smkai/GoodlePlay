package ck.itheima.com.goodleplay.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ck.itheima.com.goodleplay.app.Constans;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类名:    HeiMaRetrofit
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 9:55
 * 包名:    ck.itheima.com.goodleplay.network
 * 更新者:  $Author$ $Date$
 * 描述:
 */

public class HeiMaRetrofit {

    private static HeiMaRetrofit sHeimaRetrofit;

    Gson mGson = new GsonBuilder().setLenient().create();//宽大处理

    private final Api mApi;

    private HeiMaRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(mGson))//转换器
                .build();
        mApi = retrofit.create(Api.class);

    }



    public static HeiMaRetrofit getInstance() {
        if (sHeimaRetrofit == null) {
            synchronized (HeiMaRetrofit.class) {
                if (sHeimaRetrofit == null) {
                    sHeimaRetrofit = new HeiMaRetrofit();
                }
            }
        }
        return sHeimaRetrofit;
    }


    public Api getApi() {
        return mApi;
    }
}
