package com.lefu.test.activities.frame.fragment;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lefu.test.R;
import com.lefu.test.base.BaseFragment;
import com.lefu.test.common.A;
import com.lefu.test.dialog.TimeoutDialog;
import com.lefu.test.dialog.WaitingDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author liufu on 2017/1/7.
 */

public class FragmentTabOne extends BaseFragment {

	@BindView(R.id.iv_waiting)
	ImageView mIvWaiting;

	@BindView(R.id.tab_name)
	TextView mTvTabName;

	@Override
	protected void createView(View view, Bundle savedInstanceState) {
		mTvTabName.setText("1");

		((Animatable) mIvWaiting.getDrawable()).start();
	}

	@Override
	protected int getFragmentResId() {
		return R.layout.fragment_tab_one;
	}

	@OnClick(R.id.tab_name)
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.tab_name:
				LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent(A.string.BROADCAST_RECEIVER_TIMEOUT));
				break;
		}
	}
}
