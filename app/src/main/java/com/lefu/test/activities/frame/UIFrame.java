package com.lefu.test.activities.frame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.lefu.test.R;
import com.lefu.test.activities.frame.fragment.FragmentTabFour;
import com.lefu.test.activities.frame.fragment.FragmentTabOne;
import com.lefu.test.activities.frame.fragment.FragmentTabThree;
import com.lefu.test.activities.frame.fragment.FragmentTabTwo;
import com.lefu.test.base.BaseActivity;
import com.lefu.test.common.A;
import com.lefu.test.service.TimeoutService;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

/**
 * @author liufu on 2017/1/7.
 */

public class UIFrame extends BaseActivity {
  @BindView(R.id.rl_frame_root) RelativeLayout mRlFrameRoot;
  @BindView(R.id.rg_bottom_navigator) RadioGroup mRgNavigator;

  private BroadcastReceiver mTabChangeReceiver = new BroadcastReceiver() {
    @Override public void onReceive(Context context, Intent intent) {
      mRgNavigator.check(intent.getIntExtra(A.string.EXTRA_TAB_INDEX, R.id.rb_frame_item_one));
    }
  };

  private FragmentTabOne mFrgOne;
  private FragmentManager mFrgManager;
  private FragmentTabTwo mFrgTwo;
  private FragmentTabThree mFrgThree;
  private FragmentTabFour mFrgFour;

  @Override public int layoutResId() {
    return R.layout.activity_frame;
  }

  @Override public void initViews() {

    LocalBroadcastManager.getInstance(getBaseContext())
        .registerReceiver(mTabChangeReceiver,
            new IntentFilter(A.string.BROADCAST_RECEIVER_TAB_CHANGE));
    mBtnLeft.setVisibility(View.GONE);
    mFrgManager = getSupportFragmentManager();
    mFrgOne = new FragmentTabOne();
    mFrgTwo = new FragmentTabTwo();
    mFrgThree = new FragmentTabThree();
    mFrgFour = new FragmentTabFour();
    startService(new Intent(getApplicationContext(), TimeoutService.class));

    mRgNavigator.check(R.id.rb_frame_item_one);
  }

  @OnCheckedChanged({
      R.id.rb_frame_item_one, R.id.rb_frame_item_two, R.id.rb_frame_item_three,
      R.id.rb_frame_item_four
  }) public void onCheckedChanged(CompoundButton button, boolean isChecked) {
    if (isChecked) {
      switch (button.getId()) {
        case R.id.rb_frame_item_one:
          mFrgManager.beginTransaction().replace(R.id.fl_fragment_container, mFrgOne).commit();
          break;
        case R.id.rb_frame_item_two:
          mFrgManager.beginTransaction().replace(R.id.fl_fragment_container, mFrgTwo).commit();
          break;
        case R.id.rb_frame_item_three:
          mFrgManager.beginTransaction().replace(R.id.fl_fragment_container, mFrgThree).commit();
          break;
        case R.id.rb_frame_item_four:
          mFrgManager.beginTransaction().replace(R.id.fl_fragment_container, mFrgFour).commit();
          break;
        default:
          mFrgManager.beginTransaction().replace(R.id.fl_fragment_container, mFrgOne).commit();
          break;
      }
    }
  }

  @Override public void onDestroy() {

    LocalBroadcastManager.getInstance(getBaseContext()).unregisterReceiver(mTabChangeReceiver);
  }
}
