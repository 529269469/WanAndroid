package com.example.wanandroid.net;


import com.example.wanandroid.utils.MLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by yangjingsong on 16/7/12.
 */
public class ApiClient {
    public static Retrofit mRetrofit;

    private final static String REQUEST_TOKEN = "token";
    private final static String REQUEST_TIMESTAMP = "timeStamp";
    private final static String REQUEST_DEVICE_ID = "deviceId";
    private final static String OS_TYPE = "os";
    private final static String SIGN = "sign";
    private final static String VERSION = "version";

//    private final static String LANGUAGE = "language";


    public static Retrofit retrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Urls.HTTP)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getClient())
                .validateEagerly(true)
                .build();
        return mRetrofit;
    }

    public static OkHttpClient getClient() {
        //声明日志类
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //设定日志级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        try {
            return new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(
                            new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request srcRequest = chain.request();
                                    HttpUrl.Builder urlBuilder = srcRequest.url()
                                            .newBuilder()
                                            .scheme(srcRequest.url().scheme())
                                            .host(srcRequest.url().host())
//                                            .addQueryParameter(REQUEST_TOKEN, DataCacheManager.getToken())
                                            .addQueryParameter(REQUEST_TIMESTAMP, System.currentTimeMillis()+"")
//                                            .addQueryParameter(REQUEST_DEVICE_ID, AppLike.self().getDeviceId())
//                                            .addQueryParameter(VERSION, Util.getVersionName())
                                            .addQueryParameter(OS_TYPE, "1")
                                            .addQueryParameter(SIGN,"");
                                    Request dstRequest = srcRequest.newBuilder()
                                            .method(srcRequest.method(), srcRequest.body())
                                            .url(urlBuilder.build())
                                            .build();
                                    MLog.e("====wyw====>url<"+ srcRequest.url());
                                    return chain.proceed(dstRequest);
                                }
                            }
                    )
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

        } catch (Exception e) {
            return null;
        }
    }
}
