package com.mambu.apisdk.services;

import org.junit.Test;
import org.mockito.Mockito;

import com.mambu.apisdk.ServiceTestBase;
import com.mambu.apisdk.exception.MambuApiException;
import com.mambu.apisdk.util.APIData;
import com.mambu.apisdk.util.ParamsMap;
import com.mambu.apisdk.util.RequestExecutor.ContentType;
import com.mambu.apisdk.util.RequestExecutor.Method;

/**
 * @author ipenciuc
 * 
 */
public class RepaymentsServiceTest extends ServiceTestBase {

	private RepaymentsService service;

	@Override
	public void setUp() throws MambuApiException {
		super.setUp();

		service = new RepaymentsService(super.mambuApiService);
	}

	@Test
	public void testGetLoanRapayments() throws MambuApiException {

		// execute

		final String accountId = "accountId_1234";
		service.getLoanAccountRepayments(accountId, null, null);

		// verify
		ParamsMap paramsMap = new ParamsMap();
		paramsMap.put(APIData.OFFSET, null);
		paramsMap.put(APIData.LIMIT, null);
		Mockito.verify(executor).executeRequest("https://demo.mambutest.com/api/loans/" + accountId + "/repayments",
				paramsMap, Method.GET, ContentType.WWW_FORM);
	}

	@Test
	public void testGetRapaymentsDueFromTo() throws MambuApiException {

		// execute
		final String dueFromString = "2014-02-01";
		final String dueToString = "2014-07-05";
		service.getRapaymentsDueFromTo(dueFromString, dueToString, null, null);

		// verify
		ParamsMap paramsMap = new ParamsMap();
		paramsMap.put(APIData.DUE_FROM, dueFromString);
		paramsMap.put(APIData.DUE_TO, dueToString);
		paramsMap.put(APIData.OFFSET, null);
		paramsMap.put(APIData.LIMIT, null);
		Mockito.verify(executor).executeRequest("https://demo.mambutest.com/api/repayments", paramsMap, Method.GET,
				ContentType.WWW_FORM);
	}

}
