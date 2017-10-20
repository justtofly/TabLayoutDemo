package com.fi.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/10/20 0020 13:28
 * 作用	      ${TODO}
 * <p/>
 * 版本       $$Rev$$
 * 更新者     $$Author$$
 * 更新时间   $$Date$$
 * 更新描述   ${TODO}
 */
public abstract class BaseFragment extends Fragment {

    public Context mContext;

    /**
     * Fragment的View加载完毕的标记
     */
    private boolean isViewCreated;
    /**
     * Fragment对用户可见的标记
     */
    private boolean isUiVisible;

    /**
     * 系统创建该类的时候回调
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    /**
     * Fragment的UI的创建
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }

    /**
     * Fragment的View被创建后回调这个方法
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        isViewCreated=true;
        lazyLoad();
    }

    /**
     * Fragment对用户可见、不可见回调这个方法
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser){
            isUiVisible=true;
            lazyLoad();
        }else {
            isUiVisible=false;
        }
    }

    private void lazyLoad(){
        //在这里进行多重标记判断，这是因为setUserVisibleHint会回调多次，并且会在onCreateView执行前回调
        //必须确保onCreateView加载完毕后且页面可见，才加载数据
        if (isViewCreated&&isUiVisible){
            initData();
            //数据加载完毕之后，恢复标记，防止重复加载
            isViewCreated=false;
            isUiVisible=false;
        }
    }

    /**
     * 抽象类，由孩子实现，实现不同的效果
     * @return
     */
    public abstract View initView();

    /**
     * 负责得到数据
     * @param savedInstanceState
     */
    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }*/

    /**
     * 需要联网请求数据的时候，重写该方法
     */
    public void initData(){

    }
}
