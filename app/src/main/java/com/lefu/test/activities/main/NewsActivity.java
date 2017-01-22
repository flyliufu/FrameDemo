package com.lefu.test.activities.main;

import android.widget.TextView;

import com.lefu.test.R;
import com.lefu.test.base.BaseActivity;
import com.lefu.test.bean.JSONEntity;
import com.lefu.test.bean.NewsBean;

import butterknife.BindView;

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

	@Override
	public void destroy() {

	}
}
