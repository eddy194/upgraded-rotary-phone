package com.altapay.backend.model;

import java.util.List;


public class ShopOrder 
{
	String id;
	String paymentId;
	List<OrderLine> orderLines;
	
	public void setId(String id) 
	{
		this.id = id;
	}

	public void setPaymentId(String paymentId) 
	{
		this.paymentId = paymentId;
	}
	
	public void setOrderLines(List<OrderLine> orderLines)
	{
		this.orderLines = orderLines;
	}

	public void capture() 
	{
		// TODO: use the InventoryService to check inventory before capturing
		// TODO: Use the MerchantApiService to capture the payment. 
		// TODO: use the InventoryService to take from inventory after capturing 
	}

	// Release is a synonym for canceling a payment
	public void release() 
	{
		// TODO: Use the MerchantApiService to release the payment. 
	}
}
