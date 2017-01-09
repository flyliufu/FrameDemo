package com.lefu.test.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author liufu on 2017/1/7.
 */

public abstract class BaseFragment extends Fragment {

	private Unbinder unbinder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(getFragmentResId(), container, false);
		unbinder = ButterKnife.bind(this, view);
		onBinderView();
		return view;
	}

	/**
	 * After inflater fragment view
	 */
	protected abstract void onBinderView();
	

	/**
	 * Fragment layout resource id
	 *
	 * @return resource id
	 */
	@LayoutRes
	protected abstract int getFragmentResId();
}
