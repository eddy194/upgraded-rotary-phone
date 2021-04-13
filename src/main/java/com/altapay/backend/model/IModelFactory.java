package com.altapay.backend.model;

public interface IModelFactory 
{
	ShopOrder getShopOrder();

	Inventory getInventory();
	
	OrderLine getOrderLine();
	
	Product getProduct();
}
