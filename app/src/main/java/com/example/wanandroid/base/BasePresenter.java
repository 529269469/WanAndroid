package com.example.wanandroid.base;

import com.example.wanandroid.net.APIService;
import com.example.wanandroid.net.ApiClient;
import com.example.wanandroid.net.SubscriberCallBack;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author :created by ${ WYW }
 * 时间：2019/3/20 14
 */
public class BasePresenter<T extends IView> implements IPresenter<T> {
    protected WeakReference<T> weakReference;
    private CompositeSubscription compositeDisposable;
    public APIService apiStores = ApiClient.retrofit().create(APIService.class);

    public T mView;

    public BasePresenter(T view) {
        mView = view;
    }

    @Override
    public void attachView(T view) {
        weakReference = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.weakReference = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    protected void addSubscribe(Observable observable, final SubscriberCallBack subscriber) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeSubscription();
        }
        try {
            compositeDisposable.add(observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .onErrorReturn(new Func1() {
                        @Override
                        public Object call(Object o) {
                            subscriber.onError((Throwable) o);
                            return null;
                        }
                    })
                    .subscribe(subscriber));
        } catch (Exception e) {
        }
    }
}
