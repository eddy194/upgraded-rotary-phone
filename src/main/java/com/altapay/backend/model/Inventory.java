package com.altapay.backend.model;

public class Inventory 
{
	private Product product;
	private int inventory;
	
	public Product getProduct() 
	{
		return product;
	}
	
	public void setProduct(Product product) 
	{
		this.product = product;
	}
	
	public int getInventory() 
	{
		return inventory;
	}
	
	public void setInventory(int inventory) 
	{
		this.inventory = inventory;
	}
}
