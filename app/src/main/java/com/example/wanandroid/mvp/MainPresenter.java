package com.example.wanandroid.mvp;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.UserBean;
import com.example.wanandroid.net.ApiCallback;
import com.example.wanandroid.net.SubscriberCallBack;

import org.apache.commons.lang.StringUtils;

/**
 * @author :created by ${ WYW }
 * 时间：2019/3/22 10
 */
public class MainPresenter extends BasePresenter<IMain> {


    public MainPresenter(IMain view) {
        super(view);
    }

    public void setUser() {
       addSubscribe(apiStores.getUser(),new SubscriberCallBack<>(new ApiCallback<UserBean>() {
           @Override
           public void onSuccess(UserBean model) {
                mView.showMsg(model.toString());
           }

           @Override
           public void onFailure(String code, String msg) {

           }

           @Override
           public void onFailure(int code, String msg) {

           }
       }));



    }


}
