package com.altapay.backend.exceptions;

public class UnableToLoadPaymentIdForShopOrderException extends RuntimeException {
	private static final long serialVersionUID = -4005748541319236349L;

	public UnableToLoadPaymentIdForShopOrderException(String id) {
		super("Unable to load paymentId for ShopOrder:"+id);
	}
}
