package com.example.lenovo.ag_wcx;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.lenovo.ag_wcx.adapter.Vp_Adapter;
import com.example.lenovo.ag_wcx.fragment.CollectFragment;
import com.example.lenovo.ag_wcx.fragment.HomeFragment;

import java.util.ArrayList;

//卫晨旭 1808c
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    /**
     * 首页
     */
    private TextView mTvTl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTvTl = (TextView) findViewById(R.id.tv_tl);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        fragments = new ArrayList<>();
        titles = new ArrayList<>();

        titles.add("首页");
        titles.add("收藏");

        fragments.add(new HomeFragment());
        fragments.add(new CollectFragment());

        Vp_Adapter vp_adapter = new Vp_Adapter(getSupportFragmentManager(), fragments, titles);
        mVp.setAdapter(vp_adapter);

        mTab.setupWithViewPager(mVp);

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTvTl.setText(titles.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
