package composition.entities;

import java.sql.Date;

public class Order extends Product{
	private long orderId;
	private long userid;
	private int quantity;
	private Date date;
	
	public Order() {
	}
	
	public Order(long orderId, long uid, int qunatity, Date date) {
		super();
		this.orderId = orderId;
		this.userid = uid;
		this.quantity = qunatity;
		this.date = date;
	}

	public Order(long uid, int qunatity, Date date) {
		super();
		this.userid = uid;
		this.quantity = qunatity;
		this.date = date;
	}

	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long uid) {
		this.userid = uid;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQunatity(int qunatity) {
		this.quantity = qunatity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
