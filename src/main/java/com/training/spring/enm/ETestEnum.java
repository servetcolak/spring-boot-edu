package com.training.spring.enm;

public enum ETestEnum implements ITestEnum {
	STATE1(1, "SERVET"), STATE2(2, "COLAK");

	private int index;
	private String value;

	private ETestEnum(int index, String value) {
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getRealName() {
		return this.value;
	}
}
