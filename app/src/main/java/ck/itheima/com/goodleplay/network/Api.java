package ck.itheima.com.goodleplay.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 类名:    Api
 * 创建者:  ckqu
 * 创建时间:2017/2/15 0015 下午 9:50
 * 包名:    ck.itheima.com.goodleplay.network
 * 更新者:  $Author$ $Date$
 * 描述:    网络请求
 */

public interface Api {
    @GET("hot")
    Call<List<String>> listHot();

    @GET("recommend")
    Call<List<String>> listReconmend();
}
