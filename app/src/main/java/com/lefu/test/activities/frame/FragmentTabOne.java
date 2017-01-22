package com.lefu.test.activities.frame;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;

import com.lefu.test.R;
import com.lefu.test.base.BaseFragment;

import butterknife.BindView;

/**
 * @author liufu on 2017/1/7.
 */

public class FragmentTabOne extends BaseFragment {

	@BindView(R.id.iv_waiting)
	ImageView mIvWaiting;

	@BindView(R.id.tab_name)
	TextView mTvTabName;

	@Override
	protected void onBinderView() {
		mTvTabName.setText("1");

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			((AnimatedVectorDrawable) mIvWaiting.getBackground()).start();
		}
	}

	@Override
	protected int getFragmentResId() {
		return R.layout.fragment_tab_one;
	}
}
