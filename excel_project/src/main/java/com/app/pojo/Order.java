package com.app.pojo;

public class Order {

	private String order_num;
	private int sale_amount;
	private int cost_price;
	private int transferred_amt;
	private int comm,pay_gateway;
	private int pic_pack;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String order_num, int sale_amount, int cost_price, int transferred_amt, int comm, int pay_gateway,
			int pic_pack) {
		super();
		this.order_num = order_num;
		this.sale_amount = sale_amount;
		this.cost_price = cost_price;
		this.transferred_amt = transferred_amt;
		this.comm = comm;
		this.pay_gateway = pay_gateway;
		this.pic_pack = pic_pack;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public int getSale_amount() {
		return sale_amount;
	}
	public void setSale_amount(int sale_amount) {
		this.sale_amount = sale_amount;
	}
	public int getCost_price() {
		return cost_price;
	}
	public void setCost_price(int cost_price) {
		this.cost_price = cost_price;
	}
	public int getTransferred_amt() {
		return transferred_amt;
	}
	public void setTransferred_amt(int transferred_amt) {
		this.transferred_amt = transferred_amt;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getPay_gateway() {
		return pay_gateway;
	}
	public void setPay_gateway(int pay_gateway) {
		this.pay_gateway = pay_gateway;
	}
	public int getPic_pack() {
		return pic_pack;
	}
	public void setPic_pack(int pic_pack) {
		this.pic_pack = pic_pack;
	}
	@Override
	public String toString() {
		return "Order [order_num=" + order_num + ", sale_amount=" + sale_amount + ", cost_price=" + cost_price
				+ ", transferred_amt=" + transferred_amt + ", comm=" + comm + ", pay_gateway=" + pay_gateway
				+ ", pic_pack=" + pic_pack + "]";
	}
	
	
}
