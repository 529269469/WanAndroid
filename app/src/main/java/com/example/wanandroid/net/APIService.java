package com.example.wanandroid.net;


import com.example.wanandroid.bean.UserBean;

import retrofit2.http.GET;
import rx.Observable;


public interface APIService {

    @GET(Urls.USERINFO)
    Observable<UserBean> getUser();


}
