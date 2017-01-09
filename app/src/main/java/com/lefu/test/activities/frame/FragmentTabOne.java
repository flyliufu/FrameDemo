package com.lefu.test.activities.frame;

import android.widget.TextView;

import com.lefu.test.R;
import com.lefu.test.base.BaseFragment;

import butterknife.BindView;

/**
 * @author liufu on 2017/1/7.
 */

public class FragmentTabOne extends BaseFragment {

	@BindView(R.id.tab_name)
	TextView mTvTabName;

	@Override
	protected void onBinderView() {
		mTvTabName.setText("1");
	}

	@Override
	protected int getFragmentResId() {
		return R.layout.fragment_tab_one;
	}
}
