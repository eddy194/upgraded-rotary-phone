package com.altapay.backend.ioc;

import com.altapay.backend.controllers.BackendController;
import com.altapay.backend.model.IModelFactory;
import com.altapay.backend.model.Inventory;
import com.altapay.backend.model.OrderLine;
import com.altapay.backend.model.Product;
import com.altapay.backend.model.ShopOrder;
import com.altapay.backend.repositories.ShopOrderRepository;

public class BackendContainer implements IModelFactory {

	public BackendController getBackendController() 
	{
		return new BackendController(getShopOrderRepository());
	}

	// TODO: should be a singleton
	public ShopOrderRepository getShopOrderRepository() 
	{
		return new ShopOrderRepository(this);
	}
	
	@Override
	public ShopOrder getShopOrder() 
	{
		// TODO: initialize a new ShopOrder with it's dependencies
		return null;
	}

	@Override
	public Inventory getInventory() 
	{
		// TODO: initialize a new Inventory with it's dependencies
		return null;
	}

	@Override
	public OrderLine getOrderLine() 
	{
		// TODO: initialize a new OrderLine with it's dependencies
		return null;
	}

	@Override
	public Product getProduct() 
	{
		// TODO: initialize a new Product with it's dependencies
		return null;
	}

}
