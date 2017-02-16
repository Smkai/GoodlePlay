package ck.itheima.com.goodleplay.bean;

import java.util.List;

/**
 * 类名:    CategoryBean
 * 创建者:  ckqu
 * 创建时间:2017/2/16 0016 下午 7:04
 * 包名:    ck.itheima.com.goodleplay.bean
 * 更新者:  $Author$ $Date$
 * 描述:    分类的bean
 */

public class CategoryBean {

    public String title;
    public List<InfosBean> infos;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<InfosBean> getInfos() {
        return infos;
    }

    public void setInfos(List<InfosBean> infos) {
        this.infos = infos;
    }

    public static class InfosBean {
        public String url1;
        public String url2;
        public String url3;
        public String name1;
        public String name2;
        public String name3;

        public String getUrl1() {
            return url1;
        }

        public void setUrl1(String url1) {
            this.url1 = url1;
        }

        public String getUrl2() {
            return url2;
        }

        public void setUrl2(String url2) {
            this.url2 = url2;
        }

        public String getUrl3() {
            return url3;
        }

        public void setUrl3(String url3) {
            this.url3 = url3;
        }

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        public String getName3() {
            return name3;
        }

        public void setName3(String name3) {
            this.name3 = name3;
        }
    }
}
