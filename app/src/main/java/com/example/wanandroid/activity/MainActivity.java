package com.example.wanandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseActivity;
import com.example.wanandroid.mvp.IMain;
import com.example.wanandroid.mvp.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements IMain {


    @BindView(R.id.text)
    TextView text;

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initEventAndData() {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.setUser();
            }
        });

    }


}
