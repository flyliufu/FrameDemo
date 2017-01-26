package com.lefu.test.dialog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.lefu.test.R;
import com.lefu.test.base.BaseDialog;

import butterknife.OnClick;

/**
 * @author liufu on 2017/1/25.
 */

public class TimeoutDialog extends BaseDialog {

	private static TimeoutDialog mTimeoutDialog;

	private boolean isShowing;

	public static TimeoutDialog getInstance() {
		if (mTimeoutDialog == null) {
			mTimeoutDialog = new TimeoutDialog();
		}
		return mTimeoutDialog;
	}

	public void show(FragmentManager fm) {
		if (!isShowing) {
			isShowing = true;
			FragmentTransaction fragmentTransaction = fm.beginTransaction();
			Fragment timeout = fm.findFragmentByTag("timeout");
			if (timeout != null) {
				//为了不重复显示dialog，在显示对话框之前移除正在显示的对话框
				fragmentTransaction.remove(timeout);
			}
			mTimeoutDialog.show(fm, "timeout");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		isShowing = false;
	}

	@Override
	protected void initDialog(View view, Bundle savedInstanceState) {

	}

	@Override
	protected int getDialogLayoutRes() {
		return R.layout.dialog_common_timeout;
	}


	@OnClick({R.id.btn_confirm})
	public void onClick(View v) {
		dismiss();
	}

	public void hide() {
		if (isShowing) mTimeoutDialog.dismiss();
	}
}
