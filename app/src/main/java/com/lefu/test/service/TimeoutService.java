package com.lefu.test.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;

import com.lefu.test.R;
import com.lefu.test.common.A;

/**
 * @author liufu on 2017/1/26.
 */

public class TimeoutService extends Service {
	AlertDialog dialog;

	private BroadcastReceiver mTimeoutReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			dialog.show();
		}
	};


	@Override
	@SuppressLint("PrivateResource")
	public void onCreate() {
		super.onCreate();
		View view = View.inflate(getBaseContext(), R.layout.dialog_common_timeout, null);
		dialog = new AlertDialog.Builder(getBaseContext(), android.support.v7.appcompat.R.style.Theme_AppCompat_Light_NoActionBar)
						 .create();
		dialog.setView(view);
		// dialog.setCancelable(false);
		dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

		LocalBroadcastManager.getInstance(getBaseContext()).registerReceiver(mTimeoutReceiver,
				new IntentFilter(A.string.BROADCAST_RECEIVER_TIMEOUT));
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		LocalBroadcastManager.getInstance(getBaseContext()).unregisterReceiver(mTimeoutReceiver);
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
			dialog = null;
		}
	}

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
