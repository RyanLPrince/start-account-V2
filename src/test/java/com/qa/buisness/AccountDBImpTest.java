package com.qa.buisness;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

//import org.junit.Before;
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
	private Account account;
	
	
	@Mock 
	JSONUtil ju;
	
	
	
	
	@Test
	public void createAccountTest() {
		assertEquals(accDBImp.createAccount(account),"Account has been created");
	}
	
	@Test 
	public void deleteAccountTest() {
		assertEquals(accDBImp.deleteAccount(account),"Account has been deleted");
	}
	@Test
	public void findAccountTest() {
		//EntityManager em = Mockito.mock(EntityManager.class);
		Mockito.when(em.find((Account.class),1L)).thenReturn(account);
		assertEquals(accDBImp.findAccount(1L),account);
	}
	
	/*
	@Test
	public void updateAccountTest() {
		Mockito.when(accDBImp.updateAccount(1L,Mockito.anyString())).thenReturn("Account has been updated");
		
		String actual = accDBImp.updateAccount(1L,"");
		assertEquals("Account has been updated",actual);
	}*/
}

