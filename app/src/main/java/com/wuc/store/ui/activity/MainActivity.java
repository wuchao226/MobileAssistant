package com.wuc.store.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.wuc.store.R;
import com.wuc.store.base.BaseActivity;
import com.wuc.store.bean.User;
import com.wuc.store.common.Constant;
import com.wuc.store.factory.FragmentFactory;
import com.wuc.store.ui.adapter.FixPageAdapter;
import com.wuc.store.util.GlideUtils;
import com.wuc.store.util.PermissionUtils;
import com.wuc.store.util.SpUtils;
import com.wuc.store.util.UiUtils;
import com.wuc.store.widgets.BadgeActionProvider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * @author: wuchao
 * @date: 2018/10/26 13:05
 * @desciption:
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    /**
     * 抽屉头部view
     */
    private View headerView;
    /**
     * 用户头像
     */
    private ImageView mUserAvator;
    /**
     * 用户名称
     */
    private AppCompatTextView mTvUserName;

    private FixPageAdapter mAdapter;
    private String[] titles = {"推荐", "排行", "游戏", "分类",};
    private List<Fragment> fragments;

    private BadgeActionProvider mBadgeActionProvider;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initDrawerLayout();
        initViewPagerFragment();
        initObserver();
        initToolBar();
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                PermissionUtils.requestPermission(this, Manifest.permission.READ_PHONE_STATE)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean aBoolean) throws Exception {

                            }
                        }));

    }

    private void initToolBar() {
        //ToolBar 初始化 menu
        mToolBar.inflateMenu(R.menu.toolbar_menu);
        MenuItem menuItem = mToolBar.getMenu().findItem(R.id.action_download);
        mBadgeActionProvider = (BadgeActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mBadgeActionProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("下载管理");
            }
        });
        mBadgeActionProvider.setBadge(3);
    }

    private void initDrawerLayout() {
        headerView = mNavigationView.getHeaderView(0);
        mUserAvator = headerView.findViewById(R.id.img_avator);
        mTvUserName = headerView.findViewById(R.id.tv_name);
        initUser();
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_download:
                        Toast.makeText(MainActivity.this, "下载", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_update:
                        Toast.makeText(MainActivity.this, "更新", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_message:
                        Toast.makeText(MainActivity.this, "消息", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_settings:
                        SpUtils.remove(Constant.KEY_SP_TOKEN);
                        SpUtils.remove(Constant.USER);
                        initUser();
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
                return false;
            }
        });
        // 参数：开启抽屉的activity、DrawerLayout的对象、toolbar按钮打开关闭的对象、描述open drawer、描述close drawer
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //添加抽屉按钮，通过点击按钮实现打开和关闭功能; 如果不想要抽屉按钮，只允许在侧边边界拉出侧边栏，可以不写此行代码
        drawerToggle.syncState();
        //设置按钮的动画效果; 如果不想要打开关闭抽屉时的箭头动画效果，可以不写此行代码
        mDrawerLayout.addDrawerListener(drawerToggle);
    }

    private void initViewPagerFragment() {
        mAdapter = new FixPageAdapter(getSupportFragmentManager());
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            fragments.add(FragmentFactory.crerateFragment(i));
        }
        mAdapter.setTitles(titles);
        mAdapter.setFragments(fragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    /**
     * 监听用户登录数据
     */
    private void initObserver() {
        mRxBus.register(User.class, new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                if (user != null) {
                    initUserHeaderView(user);
                    initUser();
                }
            }
        });
    }

    private void initUser() {
        User user = SpUtils.getObject(Constant.USER, User.class);
        initUserHeaderView(user);
        if (user == null) {
            headerView.findViewById(R.id.nav_header).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity(LoginActivity.class);
                }
            });
        }
    }

    private void initUserHeaderView(User user) {
        if (user != null) {
            GlideUtils.loadImage(this, user.getLogo_url(), mUserAvator);
            mTvUserName.setText(user.getUsername());
        } else {
            mUserAvator.setImageResource(R.mipmap.ic_avatar);
            mTvUserName.setText(UiUtils.getString(R.string.click_login));
        }
    }

}
