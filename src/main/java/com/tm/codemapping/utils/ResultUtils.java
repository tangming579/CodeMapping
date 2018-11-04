package com.tm.codemapping.utils;

import com.tm.codemapping.bean.ResultBean;

public class ResultUtils {

	public static ResultBean success(Object obj) {
		ResultBean result=new ResultBean();
		result.setCode(0);
		result.setMsg("成功");
		result.setContent(obj);
		return result;
	}
	
	public static ResultBean error(int code, String msg) {
		ResultBean result=new ResultBean();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	public static ResultBean success() {
		return success(null);
	}
}
