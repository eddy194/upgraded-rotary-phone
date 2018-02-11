package com.altapay.backend.services;

import com.altapay.backend.model.Product;
import com.altapay.backend.repositories.InventoryRepository;

public class InventoryService 
{
	private InventoryRepository repository;

	public InventoryService(InventoryRepository repository)
	{
		this.repository = repository;
	}
	
	public boolean checkInventory(Product product, int quantity)
	{
		// TODO: implement check inventory, as you see fit
		return false;
	}
	
	public boolean takeFromInventory(Product product, int quantity)
	{
		// TODO: implement take from inventory, as you see fit
		return false;
	}
}
