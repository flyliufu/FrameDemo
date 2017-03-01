package com.lefu.test;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.app.Activity;

import com.lefu.test.base.BaseActivity;

/**
 * @author yaoguangdong 2014-4-14
 */
public class AppManager {

	private static HashMap<String, SoftReference<Activity>> map = new HashMap<>();
	private static AppManager instance;

	private AppManager() {
	}

	public static AppManager getInstance() {
		if (null == instance) {
			instance = new AppManager();
		}
		return instance;
	}

	/**
	 * 添加activity 方法
	 */
	public void putActivity(Activity activity) {
		map.put(activity.getClass().getName(), new SoftReference<>(activity));
	}

	public void remove(Activity activity) {
		map.remove(activity.getClass().getName());
	}

	/**
	 */
	public void exit() {
		for (String key : map.keySet()) {
			SoftReference<Activity> sr = map.get(key);
			if (sr != null) {
				Activity act = sr.get();
				if (act != null) {
					act.finish();
				}
			}
		}
	}
}
