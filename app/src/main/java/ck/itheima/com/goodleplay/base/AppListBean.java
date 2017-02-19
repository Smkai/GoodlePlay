package ck.itheima.com.goodleplay.base;

/**
 * 类名:    AppListBean
 * 创建者:  ckqu
 * 创建时间:2017/2/18 0018 下午 12:42
 * 包名:    ck.itheima.com.goodleplay.base
 * 更新者:  $Author$ $Date$
 * 描述:    游戏 应用 首页的baen
 */

public class AppListBean {

    public int id;
    public String name;
    public String packageName;
    public String iconUrl;
    public double stars;
    public int    size;
    public String downloadUrl;
    public String des;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
