package com.safety.Model;

public class OrderDetails {
	
	private int orderId;
	private int industryId;
	private int productId;
	private String productName;
	private int quantity;
	private int totalAmount;
	private String status;

	public OrderDetails() {
		
	}
	

	
	public OrderDetails(int industryId, int productId, String productName, int quantity, int totalAmount,
			String status) {
		super();
		this.industryId = industryId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.status = status;
	}


	public OrderDetails(int orderId, int industryId, int productId, String productName, int quantity, int totalAmount,
			String status) {
		super();
		this.orderId = orderId;
		this.industryId = industryId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", industryId=" + industryId + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", totalAmount=" + totalAmount
				+ ", status=" + status + "]";
	}
	
	
	

}
