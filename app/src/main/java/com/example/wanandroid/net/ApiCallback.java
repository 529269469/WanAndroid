package com.example.wanandroid.net;


/**
 * Created by oliver on 16/5/7.
 */
public interface ApiCallback<T> {

    void onSuccess(T model);

    /**
     * 处理接口返回的错误code
     * @param code
     * @param msg
     */
    void onFailure(String code, String msg);

/*    void onCompleted();*/

    /**
     * 处理网络错误
     * @param code
     * @param msg
     */
    void onFailure(int code, String msg);

}
