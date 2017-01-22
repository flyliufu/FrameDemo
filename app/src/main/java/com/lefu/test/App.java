package com.lefu.test;

import android.app.Application;
import android.content.Context;

import com.lefu.test.api.NewsApi;
import com.lefu.test.common.A;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;

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

	@Override
	public void onCreate() {
		super.onCreate();
		mAppContext = getApplicationContext();
	}

	public static OkHttpClient buildOKHTTP() {
		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
		httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		return new OkHttpClient.Builder().connectTimeout(58000L, TimeUnit.MILLISECONDS)
					   .readTimeout(58000L, TimeUnit.MILLISECONDS).addInterceptor(httpLoggingInterceptor)
					   .hostnameVerifier((hostname, session) -> true).build();
	}

	private static Retrofit.Builder retrofitBuilder =
			new Retrofit.Builder()
					.client(buildOKHTTP())
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJavaCallAdapterFactory.create());

	public static NewsApi getNewsApi() {
		if (mNewsApi == null) {
			mNewsApi = retrofitBuilder.baseUrl(A.url.NEWS_URL).build().create(NewsApi.class);
		}
		return mNewsApi;
	}
}
