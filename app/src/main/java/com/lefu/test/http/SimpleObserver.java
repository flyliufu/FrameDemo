package com.lefu.test.http;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.gson.Gson;
import com.lefu.test.App;
import com.lefu.test.bean.JSONEntity;
import com.lefu.test.common.A;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import rx.Observer;

/**
 * @author liufu on 2016/12/13.
 */

public abstract class SimpleObserver<T extends JSONEntity<?>> implements Observer<String> {

	private static final String TAG = "SimpleObserver";

	@Override
	public void onCompleted() {

	}

	/**
	 * 程序错误
	 *
	 * @param e
	 */
	@Override
	public void onError(Throwable e) {
		// 出现在这里面的错误多数都是不可修复的程序问题。
	}

	@Override
	public void onNext(String json) {
		try {
			Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			T unknown = new Gson().fromJson(json, type);
			String code = unknown.getCode();
			if (A.code.REQUEST_SUCCESS.equals(code)) {
				onSuccess(unknown);
			} else if (A.code.REQUEST_FAILED.equals(code)) {
				onFailed(unknown);
			} else if (A.code.LOGIN_TIMEOUT.equals(code)) {
				LocalBroadcastManager.getInstance(App.getContext())
						.sendBroadcast(new Intent(A.string.BROADCAST_RECEIVER_TIMEOUT));
			}
		} catch (Exception e) {
			Log.d(TAG, "onNext: " + e.getMessage());
			onError(e);
		}
	}

	/**
	 * 逻辑错误回调方法
	 *
	 * @param unknown 请求返回
	 */
	public void onFailed(T unknown) {

	}

	/**
	 * 成功回调
	 *
	 * @param t 成功返回
	 */
	public abstract void onSuccess(T t);
}
