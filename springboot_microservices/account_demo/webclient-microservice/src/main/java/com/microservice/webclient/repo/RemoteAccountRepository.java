package com.microservice.webclient.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.microservice.webclient.entity.Account;

public class RemoteAccountRepository implements AccountRepository {
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteAccountRepository(String serviceUrl){
		this.serviceUrl = serviceUrl.startsWith("http")?serviceUrl:"http://"+serviceUrl;
	}
	
	@Override
	public List<Account> listAllAccounts() {
		Account[] accounts = restTemplate.getForObject(serviceUrl+ "/accounts", Account[].class);
		return Arrays.asList(accounts);
	}

	@Override
	public Account getAccount(String number) {
		return restTemplate.getForObject(serviceUrl + "/accounts/{id}", Account.class, number);
	}

}
