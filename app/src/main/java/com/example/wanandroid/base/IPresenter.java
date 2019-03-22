package com.example.wanandroid.base;

/**
 * @author :created by ${ WYW }
 * 时间：2019/3/20 14
 */
public interface IPresenter <T extends IView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();




}
