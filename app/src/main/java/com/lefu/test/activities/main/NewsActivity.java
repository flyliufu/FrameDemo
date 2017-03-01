package com.lefu.test.activities.main;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import com.lefu.test.R;
import com.lefu.test.base.BaseActivity;
import com.lefu.test.bean.JSONEntity;
import com.lefu.test.bean.NewsBean;
import com.lefu.test.common.A;
import com.lefu.test.utils.Tools;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsActivity extends BaseActivity {
	@BindView(R.id.tv_news_content)
	TextView mTvContent;

	@Override
	public int layoutResId() {
		return R.layout.activity_main;
	}

	@Override
	public void initViews() {
		NewsBean content = getIntent().getParcelableExtra("entity");
		if (content != null) {
			setTitle(content.getNewsName());
			mTvContent.setText(content.getNewsContent());
		}
	}

	@OnClick({R.id.tv_news_content})
	public void onClick(View v) {
		super.onClick(v);
	}
}
