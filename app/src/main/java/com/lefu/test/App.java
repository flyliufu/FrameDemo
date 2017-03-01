package com.lefu.test;

import android.app.Application;
import android.content.Context;

import com.lefu.test.api.NewsApi;
import com.lefu.test.common.A;

import com.squareup.picasso.Picasso;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author liufu on 2017/1/10.
 */

public class App extends Application {
  public static Context mAppContext;
  private static NewsApi mNewsApi;

  public static Context getContext() {
    return App.mAppContext;
  }

  @Override public void onCreate() {
    super.onCreate();
    mAppContext = getApplicationContext();

    initPicasso();
  }

  public static OkHttpClient buildOKHTTP() {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    return new OkHttpClient.Builder().connectTimeout(58000L, TimeUnit.MILLISECONDS)
        .readTimeout(58000L, TimeUnit.MILLISECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .hostnameVerifier((hostname, session) -> true)
        .build();
  }

  private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().client(buildOKHTTP())
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

  private void initPicasso() {
    Picasso.Builder builder = new Picasso.Builder(this);
    //配置下载器
    // builder.downloader(new CustomDownloader());
    //配置缓存
    // LruCache cache = new LruCache(5 * 1024 * 1024);// 设置缓存大小
    // builder.memoryCache(cache);
    //配置线程池
    ExecutorService executorService = Executors.newFixedThreadPool(8);
    builder.executor(executorService);

    //构造一个Picasso
    Picasso picasso = builder.build();
    // 设置全局单列instance
    Picasso.setSingletonInstance(picasso);
  }

  public static NewsApi getNewsApi() {
    if (mNewsApi == null) {
      mNewsApi = retrofitBuilder.baseUrl(A.url.NEWS_URL).build().create(NewsApi.class);
    }
    return mNewsApi;
  }
}
