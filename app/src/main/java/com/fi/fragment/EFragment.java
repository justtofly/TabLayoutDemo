package com.fi.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fi.base.BaseFragment;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/10/20 0020 13:44
 * 作用	      ${TODO}
 * <p/>
 * 版本       $$Rev$$
 * 更新者     $$Euthor$$
 * 更新时间   $$Date$$
 * 更新描述   ${TODO}
 */
public class EFragment extends BaseFragment {

    private static String TITLE = "title";
    private TextView mTextView;

    //创建Fragment实例
    public static EFragment newInstance(String title) {
        EFragment aFragment = new EFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG","EFragment:onResume被回调");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("TAG", "EFragment:onPause被回调");
    }

    @Override
    public View initView() {
        Log.e("TAG", "EFragment UI被初始化");
        mTextView = new TextView(mContext);
        return mTextView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG", "EFragment 数据加载");

        mTextView.setText("ContentE");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e("TAG", "EFragment被销毁了");
    }
}
