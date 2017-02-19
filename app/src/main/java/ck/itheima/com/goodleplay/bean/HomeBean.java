package ck.itheima.com.goodleplay.bean;

import java.util.List;

import ck.itheima.com.goodleplay.base.AppListBean;

/**
 * 类名:    HomeBean
 * 创建者:  ckqu
 * 创建时间:2017/2/19 0019 下午 8:20
 * 包名:    ck.itheima.com.goodleplay.bean
 * 更新者:  $Author$ $Date$
 * 描述:    homeBean
 */

public class HomeBean {

    private List<String> picture;
    private List<AppListBean> list;

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public List<AppListBean> getList() {
        return list;
    }

    public void setList(List<AppListBean> list) {
        this.list = list;
    }


}

