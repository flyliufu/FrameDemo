package com.lefu.test.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;

import com.lefu.test.AppManager;
import com.lefu.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author liufu on 2017/1/7.
 */

public abstract class BaseActivity extends AppCompatActivity {

	private Unbinder unbinder;

	@BindView(R.id.tv_header_left_btn)
	protected View mBtnLeft;
	@BindView(R.id.tv_header_title)
	protected TextView mTvTitle;
	@BindView(R.id.v_header_line)
	protected View mVLine;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setBackgroundDrawableResource(R.color._E5E5E5);

		setContentView(layoutResId());
		AppManager.getInstance().putActivity(this);
		unbinder = ButterKnife.bind(this);

		initViews();
	}

	static {
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}

	/**
	 * 获取 color
	 *
	 * @param colorId color resource id
	 * @return A color int
	 */
	@ColorInt
	public int color(@ColorRes int colorId) {
		return ContextCompat.getColor(getBaseContext(), colorId);
	}

	@OnClick({R.id.tv_header_left_btn})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.tv_header_left_btn:
				finish();
				break;
		}
	}

	/**
	 * 设置界面layout res id
	 *
	 * @return id
	 */
	@LayoutRes
	public abstract int layoutResId();

	/**
	 * 初始化界面方法
	 */
	public abstract void initViews();

	public void setTitle(String title) {
		mTvTitle.setText(title);
	}

	public void setTitle(@StringRes int title) {
		mTvTitle.setText(title);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		AppManager.getInstance().remove(this);
		if (unbinder != null) {
			unbinder.unbind();
		}
	}
}
