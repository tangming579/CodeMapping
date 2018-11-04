package com.tm.codemapping.utils;

import com.tm.codemapping.bean.Result;

public class ResultUtils {

	public static Result success(Object obj) {
		Result result=new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setContent(obj);
		return result;
	}
	
	public static Result error(int code, String msg) {
		Result result=new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	public static Result success() {
		return success(null);
	}
}
