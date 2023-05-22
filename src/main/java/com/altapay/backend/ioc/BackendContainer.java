package com.altapay.backend.ioc;

import com.altapay.backend.controllers.BackendController;
import com.altapay.backend.model.IModelFactory;
import com.altapay.backend.model.Inventory;
import com.altapay.backend.model.OrderLine;
import com.altapay.backend.model.Product;
import com.altapay.backend.model.ShopOrder;
import com.altapay.backend.repositories.InventoryRepository;
import com.altapay.backend.repositories.ShopOrderRepository;
import com.altapay.backend.services.InventoryService;
import com.altapay.backend.services.MerchantApiService;
import com.altapay.util.HttpUtil;
import com.altapay.util.XpathUtil;

public class BackendContainer implements IModelFactory {

	private ShopOrderRepository shopOrderRepository;
	private InventoryService inventoryService;
	private MerchantApiService merchantApiService;

	public BackendController getBackendController()
	{
		return new BackendController(getShopOrderRepository());
	}

	// Singleton pattern
	public synchronized ShopOrderRepository getShopOrderRepository()
	{
		if (shopOrderRepository == null) {
			shopOrderRepository = new ShopOrderRepository(this);
		}
		return shopOrderRepository;
	}

	@Override
	public ShopOrder getShopOrder()
	{
		return new ShopOrder(getInventoryService(), getMerchantApiService());
	}

	@Override
	public Inventory getInventory()
	{
		return new Inventory();
	}

	@Override
	public OrderLine getOrderLine()
	{
		return new OrderLine();
	}

	@Override
	public Product getProduct()
	{
		return new Product();
	}

	public synchronized InventoryService getInventoryService()
	{
		if (inventoryService == null) {
			inventoryService = new InventoryService(new InventoryRepository());
		}
		return inventoryService;
	}

	public synchronized MerchantApiService getMerchantApiService()
	{
		if (merchantApiService == null) {
			merchantApiService = new MerchantApiService(new HttpUtil(), new XpathUtil());
		}
		return merchantApiService;
	}

}
