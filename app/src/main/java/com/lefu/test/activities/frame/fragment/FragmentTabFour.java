package com.lefu.test.activities.frame.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lefu.test.R;
import com.lefu.test.activities.main.NewsActivity;
import com.lefu.test.base.BaseFragment;
import com.lefu.test.bean.NewsBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author liufu on 2017/1/7.
 */

public class FragmentTabFour extends BaseFragment {

	@BindView(R.id.tab_name)
	TextView mTvTabName;

	@Override
	protected void createView(View view, Bundle savedInstanceState) {
		mTvTabName.setText("4");
	}

	@Override
	protected int getFragmentResId() {
		return R.layout.fragment_tab_four;
	}

	@OnClick({R.id.btn_click})
	public void onClick(View v) {
		Intent intent = new Intent(getContext(), NewsActivity.class);
		NewsBean bean = new NewsBean();
		bean.setNewsName("我们的目标");
		bean.setNewsContent("搞事，搞事，搞事");
		intent.putExtra("entity", bean);
		startActivity(intent);
	}
}
