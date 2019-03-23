package com.microservice.webclient.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.microservice.webclient.entity.Account;

/**
 * 此处仓库标注必不可少
 * @author ucs_yelei
 *
 */
@Repository
public class StubAccountRepository implements AccountRepository {
	
	private Map<String, Account> accountByNumber = new HashMap<String, Account>();
	
	public StubAccountRepository(){
		accountByNumber.put("11111", new Account(1122233l, "Jackson", "11111"));
		accountByNumber.put("11112", new Account(1122213l, "Marial", "11112"));
		accountByNumber.put("11113", new Account(1122223l, "Denish", "11113"));
		accountByNumber.put("11114", new Account(1122293l, "Anamieka", "11114"));
		accountByNumber.put("11115", new Account(1122283l, "Milody", "11115"));
		
	}
	
	@Override
	public List<Account> listAllAccounts() {
		return new ArrayList<Account>(accountByNumber.values());
	}

	@Override
	public Account getAccount(String number) {
		return accountByNumber.get(number);
	}

}
