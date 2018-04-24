package com.qa.buisness;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.stubbing.Answer;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

import buisness.AccountDBImp;

@RunWith(MockitoJUnitRunner.class)
public class AccountDBImpTest {
	
	@InjectMocks
	private AccountDBImp accDBImp = new AccountDBImp();
	
	@Mock
	private EntityManager em;
	
	
	@Mock 
	private Account account=new Account("Ryan","Prince",123);
	
	
	@Mock 
	JSONUtil ju;
	

	
	@Test
	public void createUsertest() {
		assertEquals(accDBImp.createAccount(account),account);
	}
	
	/*@Test 
	public void delete
	*/
}


