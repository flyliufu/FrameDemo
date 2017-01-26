package com.lefu.test.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author liufu on 2017/1/24.
 */

public abstract class BaseDialog extends DialogFragment {

	private Unbinder unbinder;

	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(getDialogLayoutRes(), container);
		unbinder = ButterKnife.bind(this, view);
		initDialog(view, savedInstanceState);
		return view;
	}


	/**
	 * 初始化 dialog 相关方法
	 *
	 * @param view
	 * @param savedInstanceState
	 */
	protected abstract void initDialog(View view, Bundle savedInstanceState);

	/**
	 * 需要返回 dialog 的 layout id
	 *
	 * @return layout id
	 */
	@LayoutRes
	protected abstract int getDialogLayoutRes();

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (unbinder != null) {
			unbinder.unbind();
		}
	}
}
