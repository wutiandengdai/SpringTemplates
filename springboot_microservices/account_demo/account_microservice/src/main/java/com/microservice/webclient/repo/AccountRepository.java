package com.microservice.webclient.repo;

import java.util.List;

import com.microservice.webclient.entity.Account;

public interface AccountRepository {

	List<Account> listAllAccounts();
	
	Account getAccount(String number);
}
