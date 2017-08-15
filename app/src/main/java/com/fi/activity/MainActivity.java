package com.fi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.fi.adapter.ViewPagerAdapter;
import com.fi.fragment.MyFragment;
import com.fi.tablayoutdemo.R;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    //声明控件
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    //声明集合元素
    private ArrayList<MyFragment> fragments;

    //声明适配器对象
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        //初始化数据
        fragments=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fragments.add(new MyFragment("标题"+i,"显示内容:"+i));
        }

        //设置适配器
        mViewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mViewPagerAdapter);

        //关联ViewPager
        mTabLayout.setupWithViewPager(mViewPager);
        //设置滑动的
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initView() {
        mViewPager= (ViewPager) findViewById(R.id.viewpager);
        mTabLayout= (TabLayout) findViewById(R.id.tablayout);
    }
}
