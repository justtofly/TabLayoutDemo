package com.fi.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/8/15 0015 0:00
 * 作用	      ${TODO}
 * <p/>
 * 版本       $$Rev$$
 * 更新者     $$Author$$
 * 更新时间   $$Date$$
 * 更新描述   ${TODO}
 */
public class MyFragment extends Fragment {
    private       Context mContext;
    /**
     * 标题数据
     */
    private final String  title;
    /**
     * 文本数据
     */
    private final String  content;
    private TextView mTextView;

    /**
     * 得到内容
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 得到标题
     * @return
     */
    public String getTitle() {
        return title;
    }

    public MyFragment(String content, String title) {
        this.content = content;
        this.title = title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    /**
     * 创建视图
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTextView = new TextView(mContext);
        mTextView.setTextColor(Color.BLACK);
        mTextView.setTextSize(30);
        mTextView.setGravity(Gravity.CENTER);
        return mTextView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置内容,这里可以替换成View布局，显示不同的效果（可以替换成ListView,再写适配器）
        mTextView.setText(content);
    }
}
