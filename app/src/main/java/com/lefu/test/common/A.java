package com.lefu.test.common;

/**
 * @author liufu on 2017/1/7.
 */

public class A {

	public static class code {
		public static final String REQUEST_SUCCESS = "0000";
		public static final String REQUEST_FAILED = "0001";
		public static final String LOGIN_TIMEOUT = "0004";
	}

	public static class string {
		/**
		 * 主界面TAB切换时候广播
		 */
		public static final String BROADCAST_RECEIVER_TAB_CHANGE = "com.lefu.test.broadcast_receiver_tab_change";
		public static final String BROADCAST_RECEIVER_TIMEOUT= "com.lefu.test.broadcast_receiver_timeout";

		public static final String EXTRA_TAB_INDEX = "extra_tab_index";
	}

	public static final class url {

		public static final String NEWS_URL = "";
	}
}
