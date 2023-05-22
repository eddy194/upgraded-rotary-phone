package com.altapay.backend.controllers;

import com.altapay.backend.exceptions.MerchantApiServiceException;
import com.altapay.backend.model.ShopOrder;
import com.altapay.backend.repositories.ShopOrderRepository;

public class BackendController {
	
	private ShopOrderRepository shopOrderRepository;

	public BackendController(ShopOrderRepository shopOrderRepository)
	{
		this.shopOrderRepository = shopOrderRepository;
	}

	public void capturePayment(String shopOrderId) throws Exception {
		ShopOrder order = shopOrderRepository.loadShopOrder(shopOrderId);

		order.capture();

		// Save the model after capturing
		shopOrderRepository.saveShopOrder(order);
	}

	public void releasePayment(String shopOrderId) throws MerchantApiServiceException {
		ShopOrder order = shopOrderRepository.loadShopOrder(shopOrderId);

		order.release();

		// Save the model after releasing
		shopOrderRepository.saveShopOrder(order);
	}

}