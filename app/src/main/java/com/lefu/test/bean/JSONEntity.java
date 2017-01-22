package com.lefu.test.bean;

import java.io.Serializable;

/**
 * @author liufu on 2017/1/10.
 */

public class JSONEntity<T> implements Serializable {

	private String code;
	private String msg;
	private T content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
