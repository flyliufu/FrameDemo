package com.lefu.test.activities.frame;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lefu.test.App;
import com.lefu.test.R;
import com.lefu.test.base.BaseFragment;
import com.lefu.test.bean.NewsBean;
import com.lefu.test.utils.Tools;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author liufu on 2017/1/7.
 */

public class FragmentTabTwo extends BaseFragment {

	@BindView(R.id.tab_name)
	TextView mTvTabName;
	@BindView(R.id.btn_jump_other)
	TextView mBtnJump;
	private Observer<NewsBean> observer = new Observer<NewsBean>() {
		@Override
		public void onCompleted() {

		}

		@Override
		public void onError(Throwable e) {
			Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
		}

		@Override
		public void onNext(NewsBean newsBean) {

			Toast.makeText(getContext(), newsBean.toString(), Toast.LENGTH_LONG).show();
		}
	};

	@Override
	protected void onBinderView() {

		mTvTabName.setText("2");
	}

	@Override
	protected int getFragmentResId() {
		return R.layout.fragment_tab_two;
	}

	@OnClick({R.id.btn_jump_other})
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_jump_other:
				Tools.jumpTab(getContext(), 4);
				break;
		}
	}
}
