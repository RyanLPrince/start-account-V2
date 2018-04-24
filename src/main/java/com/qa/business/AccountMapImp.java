package com.qa.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapImp implements AccountImp{

	private Map<Long,Account> accountMap;
	private JSONUtil ju;
	
	public AccountMapImp() {
		accountMap=new HashMap<Long,Account>();
	}
	
	@Override
	public Account findAccount(Long id) {
		return accountMap.get(id);
	}

	@Override
	public List<Account> findAllAccounts() {
		List list = null;
		for (Account a: accountMap.values()) {
			list.add(a);
		}
		return list;
	}

	@Override
	public String createAccount(Account account) {
		if (!accountMap.containsValue(account)) {
			accountMap.put(account.getId(), account);
			return ("Account created");
		}
		return "Account already exists";
	}

	@Override
	public String deleteAccount(Account account) {
		
		if (accountMap.containsValue(account)) {
			accountMap.remove(account.getId());
			return "Account removed";
		}
		return "Account does not exist";
				
	}

	@Override
	public String updateAccount(long id, String accountAsJSON) {
		if(accountMap.containsKey(id)) {
			accountMap.remove(id);
			Account updatedAccount=ju.getObjectForJSON(accountAsJSON,Account.class); 
			accountMap.put(updatedAccount.getId(), updatedAccount);
		}
		return accountAsJSON;
	}

}
