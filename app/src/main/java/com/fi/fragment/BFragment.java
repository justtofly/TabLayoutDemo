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
 * 更新者     $$Author$$
 * 更新时间   $$Date$$
 * 更新描述   ${TODO}
 */
public class BFragment extends BaseFragment {

    private static String TITLE = "title";
    private TextView mTextView;

    //创建Fragment实例
    public static BFragment newInstance(String title) {
        BFragment aFragment = new BFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Override
    public View initView() {
        Log.e("TAG", "BFragment UI被初始化");
        mTextView = new TextView(mContext);
        return mTextView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG", "BFragment 数据加载");

        mTextView.setText("ContentB");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e("TAG", "BFragment被销毁了");
    }
}
