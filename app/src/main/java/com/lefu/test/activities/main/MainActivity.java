package com.lefu.test.activities.main;

import com.lefu.test.R;
import com.lefu.test.base.BaseActivity;

public class MainActivity extends BaseActivity {
	@Override
	public int layoutResId() {
		return R.layout.activity_main;
	}

	@Override
	public void initViews() {
		setTitle("基础界面");
	}

	@Override
	public void destroy() {

	}
}
