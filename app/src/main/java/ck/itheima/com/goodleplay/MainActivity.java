package ck.itheima.com.goodleplay;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rom4ek.arcnavigationview.ArcNavigationView;

import butterknife.BindView;
import ck.itheima.com.goodleplay.activity.BaseActivity;
import ck.itheima.com.goodleplay.adapter.MainViewPagerAdapter;

public class MainActivity extends BaseActivity {


    @BindView(R.id.nav_view)
    ArcNavigationView mNavView;
    @BindView(R.id.drawerLayout)
    DrawerLayout      mDrawerLayout;
    @BindView(R.id.tool_bar)
    Toolbar           mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout         mTabLayout;
    @BindView(R.id.vp)
    ViewPager         mViewPager;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        initActionBar();
        String[] titles = getResources().getStringArray(R.array.main_titles);
        mViewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(),titles));
        mTabLayout.setupWithViewPager(mViewPager);


    }

    private void initActionBar() {
        setSupportActionBar(mToolBar);

        ActionBar supportActionBar = getSupportActionBar();

        supportActionBar.setDisplayHomeAsUpEnabled(true);//设置back是否可见

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);//监听返回按钮
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mActionBarDrawerToggle.onOptionsItemSelected(item);//将抽屉点击事件传递给ActionBarToggle
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
