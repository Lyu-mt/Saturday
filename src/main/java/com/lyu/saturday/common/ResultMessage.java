package com.lyu.saturday.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResultMessage {
	Ok {
		@Override
		public String getInfo() {
			return "Ok";
		}

		@Override
		public String setInfo(String info) {
			return info;
		}
	},
	Err {
		@Override
		public String getInfo() {
			return "Error";
		}

		@Override
		public String setInfo(String info) {
			return info;
		}
	};

	public abstract String getInfo();

	public abstract String setInfo(String info);
}
