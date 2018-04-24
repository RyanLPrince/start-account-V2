package business;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.List;

import javax.transaction.Transactional;

import com.qa.domain.Account;

public interface AccountImp {

	Account findAccount(Long id);

	List<Account> findAllAccounts();

	String createAccount(Account account);

	String deleteAccount(Account account);

	String updateAccount(long id, String accountAsJSON);

}