package com.microservice.webclient.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.webclient.entity.Account;
import com.microservice.webclient.repo.AccountRepository;

@RestController
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping("/accounts")
	public Account[] all(){
		List<Account> accounts = accountRepository.listAllAccounts();
		return accounts.toArray(new Account[accounts.size()]);
	}
	
	@RequestMapping("/accounts/{id}")
	public Account byId(@PathVariable("id") String id){
		return accountRepository.getAccount(id);
	}
}
