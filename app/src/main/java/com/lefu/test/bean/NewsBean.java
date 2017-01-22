package com.lefu.test.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author liufu on 2017/1/10.
 */

public class NewsBean implements Parcelable {

	private String newsName;
	private String newsContent;

	public NewsBean() {
	}

	protected NewsBean(Parcel in) {
		newsName = in.readString();
		newsContent = in.readString();
	}

	public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
		@Override
		public NewsBean createFromParcel(Parcel in) {
			return new NewsBean(in);
		}

		@Override
		public NewsBean[] newArray(int size) {
			return new NewsBean[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(newsName);
		dest.writeString(newsContent);
	}

	public String getNewsName() {
		return newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
}
