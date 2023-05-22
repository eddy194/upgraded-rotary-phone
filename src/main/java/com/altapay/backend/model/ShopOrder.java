package com.altapay.backend.model;

import com.altapay.backend.exceptions.MerchantApiServiceException;
import com.altapay.backend.services.CaptureResponse;
import com.altapay.backend.services.InventoryService;
import com.altapay.backend.services.MerchantApiService;
import com.altapay.backend.services.ReleaseResponse;

import java.util.List;


public class ShopOrder 
{
	String id;
	String paymentId;
	List<OrderLine> orderLines;
	private InventoryService inventoryService;
	private MerchantApiService merchantApiService;

	public ShopOrder() {}

	public ShopOrder(InventoryService inventoryService, MerchantApiService merchantApiService)
	{
		this.inventoryService = inventoryService;
		this.merchantApiService = merchantApiService;
	}

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

	public void capture() throws Exception {
		for (OrderLine orderLine : orderLines) {
			Product product = orderLine.getProduct();
			int quantity = orderLine.getQuantity();
			if (inventoryService.checkInventory(product, quantity)) {
				try {
					CaptureResponse response = merchantApiService.capturePayment(this);
					if (response.wasSuccessful()) {
						inventoryService.takeFromInventory(product, quantity);
					} else {
						// Handle unsuccessful capture
						throw new Exception("Capture payment failed for product: " + product.getId());
					}
				} catch (MerchantApiServiceException e) {
					// Handle MerchantApiServiceException
					throw new Exception("MerchantApiServiceException occurred while capturing payment for product: " + product.getId(), e);
				}
			} else {
				// Handle out of stock situation
				throw new Exception("Product is out of stock: " + product.getId());
			}
		}
	}

	// Release is a synonym for canceling a payment
	public void release() throws MerchantApiServiceException {
		try {
			ReleaseResponse response = merchantApiService.releasePayment(this);
			if (!response.wasSuccessful()) {
				// Handle unsuccessful release
				throw new MerchantApiServiceException("Payment release was unsuccessful for Order ID: " + this.id);
			}
		} catch (MerchantApiServiceException ex) {
			// Log the exception or handle it as needed
			throw ex;
		}
	}
}
