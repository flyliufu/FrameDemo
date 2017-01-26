package com.lefu.test.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author liufu on 2017/1/24.
 */

public abstract class BaseDialog1 extends DialogFragment {
	
	private Unbinder unbinder;
	
	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		View view = View.inflate(getContext(), getDialogLayoutRes(), null);
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setView(view);
		
		Dialog dialogInterface = createDialog(builder);
		unbinder = ButterKnife.bind(dialogInterface);
		initDialog(view, savedInstanceState);
		return dialogInterface;
	}
	
	protected abstract void initDialog(View view, Bundle savedInstanceState);
	
	protected abstract int getDialogLayoutRes();
	
	protected abstract Dialog createDialog(AlertDialog.Builder builder);
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (unbinder != null) {
			unbinder.unbind();
		}
	}
}
