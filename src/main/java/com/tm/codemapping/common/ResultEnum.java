package com.tm.codemapping.common;

public enum ResultEnum {

	UNKONW_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	NOTNULL_ERROR(100,"值不能为空"),
	LIMIT_ERROR(101,"值不在约定范围内"),
	IDNOTFOUND_ERROR(102,"id不存在")
	;
	private Integer code;
	
	private String msg;
	
	ResultEnum(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
