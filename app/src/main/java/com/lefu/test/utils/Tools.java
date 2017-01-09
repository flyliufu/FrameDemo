package com.lefu.test.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.content.LocalBroadcastManager;

import com.lefu.test.R;
import com.lefu.test.common.A;

/**
 * @author liufu on 2017/1/7.
 */

public class Tools {

	/**
	 * @param context
	 * @param index
	 */
	public static void jumpTab(Context context, int index) {
		Intent intent = new Intent(A.string.BROADCAST_RECEIVER_TAB_CHANGE);
		switch (index) {
			case 1:
				intent.putExtra(A.string.EXTRA_TAB_INDEX, R.id.rb_frame_item_one);
				break;
			case 2:
				intent.putExtra(A.string.EXTRA_TAB_INDEX, R.id.rb_frame_item_two);
				break;
			case 3:
				intent.putExtra(A.string.EXTRA_TAB_INDEX, R.id.rb_frame_item_three);
				break;
			case 4:
				intent.putExtra(A.string.EXTRA_TAB_INDEX, R.id.rb_frame_item_four);
				break;
			default:
				intent.putExtra(A.string.EXTRA_TAB_INDEX, R.id.rb_frame_item_one);
				break;
		}
		LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
	}
}