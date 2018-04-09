package com.share.jack.materialdesigndeom;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.share.jack.materialdesigndeom.adapter.MyFragmentPagerAdapter;
import com.share.jack.materialdesigndeom.fragment.FragmentOne;
import com.share.jack.materialdesigndeom.fragment.FragmentThree;
import com.share.jack.materialdesigndeom.fragment.FragmentTwo;
import com.share.jack.materialdesigndeom.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jack on 16/10/27.
 */
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    public static final int TAB_ONE_REFRESH = 0;
    public static final int TAB_TWO_REFRESH = 1;
    public static final int TAB_THREE_REFRESH = 2;

    @BindView(R.id.am_srl_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.lmd_nsp_viewpager)
    NoScrollViewPager noScrollViewPager;
    @BindView(R.id.lmd_app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.lmd_toolbar)
    Toolbar toolbar;
    @BindView(R.id.lmd_tl_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.titlebar_back_textview)
    TextView tvBack;
    @BindView(R.id.titlebar_title_textview)
    TextView tvTitle;
    TabLayout.Tab tabOne;
    TabLayout.Tab tabTwo;
    TabLayout.Tab tabThree;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏掉系统原先的导航栏
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);   //把toolbar作为导航栏
        //设置下拉样式
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light
                , android.R.color.holo_red_light, android.R.color.holo_orange_light
                , android.R.color.holo_green_light);
        tvTitle.setText("24K纯帅");
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        noScrollViewPager.setAdapter(myFragmentPagerAdapter);
        noScrollViewPager.setNoScroll(true);    //控制ViewPager是否可以左右滑动(true表示不可以)

        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        tabLayout.setupWithViewPager(noScrollViewPager);
        //指定Tab的位置
        tabOne = tabLayout.getTabAt(TAB_ONE_REFRESH);
        tabTwo = tabLayout.getTabAt(TAB_TWO_REFRESH);
        tabThree = tabLayout.getTabAt(TAB_THREE_REFRESH);

        initListener();
    }

    private void initListener() {
        swipeRefreshLayout.setOnRefreshListener(this);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >= 0) {
                    swipeRefreshLayout.setEnabled(true);
                } else {
                    swipeRefreshLayout.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        switch (noScrollViewPager.getCurrentItem()) {
            case TAB_ONE_REFRESH:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshTabOneData();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
                break;
            case TAB_TWO_REFRESH:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshTabTwoData();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
                break;
            case TAB_THREE_REFRESH:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshTabThreeData();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
                break;
        }
    }

    private void refreshTabOneData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("我是第一页刷新出来的" + (i + 1));
        }
        ((FragmentOne) myFragmentPagerAdapter.getItem(TAB_ONE_REFRESH)).setDatas(datas);
    }

    private void refreshTabTwoData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("我是第二页刷新出来的" + (i + 1));
        }
        ((FragmentTwo) myFragmentPagerAdapter.getItem(TAB_TWO_REFRESH)).setDatas(datas);
    }

    private void refreshTabThreeData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("我是第三页刷新出来的" + (i + 1));
        }
        ((FragmentThree) myFragmentPagerAdapter.getItem(TAB_THREE_REFRESH)).setDatas(datas);
    }
}
