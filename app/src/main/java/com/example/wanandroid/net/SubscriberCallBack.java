package com.example.wanandroid.net;

import okhttp3.internal.http2.ErrorCode;
import retrofit2.HttpException;
import rx.Subscriber;

/**
 * Created by Administrator
 * on 2016/5/18.
 */
public class SubscriberCallBack<T> extends Subscriber<T> {
    private ApiCallback<T> apiCallback;

    public SubscriberCallBack(ApiCallback<T> apiCallback) {
        this.apiCallback = apiCallback;
    }

    @Override
    public void onCompleted() {
        //apiCallbaCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不给力";
            }
            apiCallback.onFailure(code, msg);
        } else {
            apiCallback.onFailure(301, e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        if (t == null) {
            apiCallback.onFailure("", "网络错误");
            return;
        }
        apiCallback.onSuccess(t);
//        String code = t.getCode();
//        if (ErrorCode.SUCCESS.getCode().equals(code)) {
//
//        } else {
//            // 单点登陆，只能在一个设备上登陆 暂时放开
//            if (ErrorCode.TOKEN_ERROR.getCode().equals(code) || ErrorCode.TOKEN_NULL.getCode().equals(code)) {
////                SynchronizationObserver.getInstance().onSynchronizationUpdate(Constant.SYNC_TYPE_LOGOUT,code);
//            }
//            apiCallback.onFailure(code, t.getMessage());
//        }
    }
}
