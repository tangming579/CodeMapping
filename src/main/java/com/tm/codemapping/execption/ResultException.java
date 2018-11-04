package com.tm.codemapping.execption;

import com.tm.codemapping.common.ResultEnum;

public class ResultException extends RuntimeException {

	public Integer code;
	
	public ResultException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code=resultEnum.getCode();		
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
