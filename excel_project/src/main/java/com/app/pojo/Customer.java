package com.app.pojo;

public class Customer {

	private int custId;
	private String custName;
	private String custCity;
	private int pinCode;
	private String stateCode;

	public Customer() {
	}

	public Customer(int custId, String custName, String custCity, int pinCode, String stateCode) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custCity = custCity;
		this.pinCode = pinCode;
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custCity=" + custCity + ", pinCode="
				+ pinCode + ", stateCode=" + stateCode + "]";
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
}
