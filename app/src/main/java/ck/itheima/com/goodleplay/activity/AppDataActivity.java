package ck.itheima.com.goodleplay.activity;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import butterknife.BindView;
import ck.itheima.com.goodleplay.R;

/**
 * 类名:    AppDataActivity
 * 创建者:  ckqu
 * 创建时间:2017/2/20 0020 上午 9:58
 * 包名:    ck.itheima.com.goodleplay.activity
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class AppDataActivity extends BaseActivity {
    @BindView(R.id.App_toolbar)
    Toolbar           mAppToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_datail;
    }

    @Override
    protected void init() {
        super.init();

        setSupportActionBar(mAppToolbar);

        setStatusBarColor();//顶部颜色

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle(R.string.app_datail);

        actionBar.setDisplayHomeAsUpEnabled(true);

//        String package_name = getIntent().getStringExtra("package_name");

//        Toast.makeText(this, package_name, Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
    }
}
