package com.altapay.backend.controllers;

import com.altapay.backend.model.ShopOrder;
import com.altapay.backend.repositories.ShopOrderRepository;

public class BackendController {
	
	private ShopOrderRepository shopOrderRepository;

	public BackendController(ShopOrderRepository shopOrderRepository) 
	{
		this.shopOrderRepository = shopOrderRepository;
	}

	public void capturePayment(String shopOrderId) 
	{
		ShopOrder order = shopOrderRepository.loadShopOrder(shopOrderId);
		
		order.capture();
		
		// TODO: Save the model after capturing
	}

	public void releasePayment(String shopOrderId) 
	{
		ShopOrder order = null; // TODO: load the shop order  
		
		order.release();
		
		// TODO: Save the model after releasing
	}

}
