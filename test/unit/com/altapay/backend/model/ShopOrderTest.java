package com.altapay.backend.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class ShopOrderTest {

	private static final String ID = "orderid";
	private static final String PAYMENTID = "paymentid";
	private ShopOrder order;

	@Before
	public void setUp() throws Exception 
	{
		order = new ShopOrder();
		order.setId(ID);
		order.setPaymentId(PAYMENTID);
	}

	@Test
	public void executeCapture_inventoryIsChecked() 
	{
		// TODO: Implement test
		fail("Not yet implemented");
	}

	@Test
	public void executeCapture_paymentIsCapturedThroughApiService() 
	{
		// TODO: Implement test
		fail("Not yet implemented");
	}
		
	@Test
	public void executeRelease_paymentIsReleasedThroughApiService() 
	{
		// TODO: Implement test
		fail("Not yet implemented");
	}
	
	// TODO: Add more tests you think is relevant
}
