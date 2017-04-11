package com.ele.system.model.enu;

public enum ELEResultEnum implements IEnum{
	SUCCESS(200,"操作成功"),
	REQUIRED_PARAMETER_NOT_FOUND(201,"必输字段为空"),
	ILLEGAL_PARAMETER(202,"参数值不正确"),
	UNKNOWN_ERROR(203,"未知错误");
	
	
	ELEResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private int code;
	private String msg;
	public int getCode() {
		// TODO Auto-generated method stub
		return code;
	}
	public String getMsg() {
		// TODO Auto-generated method stub
		return msg;
	}
	
}
