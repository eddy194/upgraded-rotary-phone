package com.altapay.backend.services;

import com.altapay.backend.exceptions.MerchantApiServiceException;
import com.altapay.backend.model.ShopOrder;
import com.altapay.util.HttpUtil;
import com.altapay.util.XpathUtil;

public class MerchantApiService 
{
	private HttpUtil httpUtil;
	private XpathUtil xpathUtil;

	public MerchantApiService(HttpUtil httpUtil, XpathUtil xpathUtil)
	{
		this.httpUtil = httpUtil;
		this.xpathUtil = xpathUtil;
	}

	public CaptureResponse capturePayment(ShopOrder shopORder) throws MerchantApiServiceException
	{
		// We don't need to implement this, write the rest of the code as if this has been implemented by use of the httpUtil and the xpathUtil
		return null;
	}

	public ReleaseResponse releasePayment(ShopOrder shopOrder) throws MerchantApiServiceException
	{
		// We don't need to implement this, write the rest of the code as if this has been implemented by use of the httpUtil and the xpathUtil
		return null;
	}
}
