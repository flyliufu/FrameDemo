package com.lefu.test.activities.frame.fragment;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.lefu.test.R;
import com.lefu.test.base.BaseFragment;

import butterknife.BindView;
import com.squareup.picasso.Picasso;

/**
 * @author liufu on 2017/1/7.
 */

public class FragmentTabThree extends BaseFragment {

  @BindView(R.id.iv_load_image) AppCompatImageView mIvLoadImage;

  @BindView(R.id.tab_name) TextView mTvTabName;

  @Override protected void createView(View view, Bundle savedInstanceState) {
    mTvTabName.setText("3");
    Picasso.with(getContext())
        .load("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
        .fit()
        .centerCrop()
        .into(mIvLoadImage);
  }

  @Override protected int getFragmentResId() {
    return R.layout.fragment_tab_three;
  }
}
