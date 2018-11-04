package com.tm.codemapping.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.codemapping.bean.ResultBean;
import com.tm.codemapping.execption.ResultException;
import com.tm.codemapping.utils.ResultUtils;

@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultBean handle(Exception e) {
		
		if(e instanceof ResultException) {
			ResultException resultException = (ResultException)e;
			return ResultUtils.error(resultException.getCode(), resultException.getMessage());
		}else {
			return ResultUtils.error(-1, "");
		}			
	}
}
