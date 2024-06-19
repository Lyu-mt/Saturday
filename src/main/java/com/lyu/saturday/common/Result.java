package com.lyu.saturday.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result <T> {

	private String msg;
	private T data;

	public Result(T data) {
		this.data = data;
		this.msg = ResultMessage.Ok.getInfo();
	}

	public Result(String msg) {
		this.msg = msg;
	}

	public static <T> Result<T> Ok() {
		return new Result<>(ResultMessage.Ok.getInfo());
	}

	public static <T> Result<T> ok(T data) {
		return new Result<>(data);
	}

	public static <T> Result<T> fail(String err) {
		return new Result<>(ResultMessage.Err.setInfo(err));
	}
}


