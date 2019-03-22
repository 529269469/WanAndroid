package com.example.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author :created by ${ WYW }
 * 时间：2019/3/22 10
 */
public abstract class BaseFragment<T extends IPresenter> extends Fragment implements IView {

    private Unbinder mUnBinder;
    protected View mRootView;
    protected T mPresenter;
    private boolean isPrepared;
    protected boolean isVisible;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mPresenter == null) {
            mPresenter = getPresenter();
        }
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), null);
            mUnBinder = ButterKnife.bind(this, mRootView);
            initEventAndData();
            isPrepared = true;
            lazyLoad();
        }

        return mRootView;
    }


    protected void lazyLoad() {
        if (!isVisible || isPrepared) {
            return;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected void onInvisible() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != null && mUnBinder != Unbinder.EMPTY) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
    }

    /**
     * 有些初始化必须在onCreateView中，例如setAdapter,
     * 否则，会弹出 No adapter attached; skipping layout
     */
    protected void initView() {

    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

    protected abstract T getPresenter();

}
