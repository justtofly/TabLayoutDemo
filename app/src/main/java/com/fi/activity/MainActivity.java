package com.fi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.fi.adapter.ViewPagerAdapter;
import com.fi.base.BaseFragment;
import com.fi.fragment.AFragment;
import com.fi.fragment.BFragment;
import com.fi.fragment.CFragment;
import com.fi.fragment.DFragment;
import com.fi.fragment.EFragment;
import com.fi.tablayoutdemo.R;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    //声明控件
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    //声明集合元素
    private ArrayList<BaseFragment> fragments;

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
        fragments = new ArrayList<>();
        /*for (int i = 0; i < 10; i++) {
            fragments.add(new MyFragment("标题"+i,"显示内容:"+i));
        }*/
        fragments.add(AFragment.newInstance("标题A"));
        fragments.add(BFragment.newInstance("标题B"));
        fragments.add(CFragment.newInstance("标题C"));
        fragments.add(DFragment.newInstance("标题D"));
        fragments.add(EFragment.newInstance("标题E"));

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
