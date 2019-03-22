package com.example.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.wanandroid.utils.CommonUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author :created by ${ WYW }
 * 时间：2019/3/20 14
 */
public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity implements IView{

    protected T mPresenter;
    private Unbinder unBinder;
    protected BaseActivity mActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        mActivity = this;
        ActivityCollector.getInstance().addActivity(this);
        onViewCreated();
        initToolbar();
        initEventAndData();
    }


    protected void onViewCreated() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        ActivityCollector.getInstance().removeActivity(this);
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
        super.onDestroy();
    }

    protected abstract T getPresenter();

    @Override
    public void showMsg(String msg) {
        CommonUtils.showMessage(this, msg);
    }



    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolbar();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();



}
