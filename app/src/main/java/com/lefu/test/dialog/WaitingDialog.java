package com.lefu.test.dialog;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.lefu.test.R;
import com.lefu.test.base.BaseDialog;

import butterknife.BindView;

/**
 * @author liufu on 2017/1/23.
 */

public class WaitingDialog extends BaseDialog {

	private static WaitingDialog mWaitingDialog;

	private boolean isShowing;

	public static WaitingDialog getInstance() {
		if (mWaitingDialog == null) {
			mWaitingDialog = new WaitingDialog();
		}
		return mWaitingDialog;
	}

	public void show(FragmentManager fm) {
		if (!isShowing) {
			isShowing = true;
			FragmentTransaction fragmentTransaction = fm.beginTransaction();
			Fragment waiting = fm.findFragmentByTag("waiting");
			if (waiting != null) {
				//为了不重复显示dialog，在显示对话框之前移除正在显示的对话框
				fragmentTransaction.remove(waiting);
			}
			mWaitingDialog.show(fragmentTransaction, "waiting");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		isShowing = false;
	}

	public void hide() {
		if (isShowing) mWaitingDialog.dismiss();
	}

	@BindView(R.id.iv_circle_img)
	ImageView mIvCircle;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setStyle(STYLE_NO_TITLE, 0);
		setCancelable(false);
	}

	/**
	 * 是否在显示状态
	 */
	public boolean isShowing() {
		return isShowing;
	}

	@Override
	protected void initDialog(View view, Bundle savedInstanceState) {

	}

	@Override
	public void onResume() {
		super.onResume();
		((Animatable) mIvCircle.getDrawable()).start();
	}

	@Override
	public void onStop() {
		super.onStop();
		((Animatable) mIvCircle.getDrawable()).stop();
	}

	@Override
	protected int getDialogLayoutRes() {
		return R.layout.dialog_common_loading;
	}
}
