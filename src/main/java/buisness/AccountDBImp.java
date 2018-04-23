package buisness;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.*;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;


public class AccountDBImp {
	
	@PersistenceContext(unitName = "primary")
    private EntityManager em;

	@Inject
	JSONUtil ju;
	
    public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }
    
    public List<Account> findAllAccounts(){
    	TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.firstName DESC", Account.class);
    	return query.getResultList();
    }

    public void createAccount(Account account) {
    	em.persist(account);
    }
    
    //@Transactional(REQUIRED)
    public void deleteAccount(Account account) {
    	em.remove(account);
    }
    
    public void updateAccount(long id, String accountAsJSON) {
    	Account original=em.find(Account.class,id);
    	Account updated=ju.getObjectForJSON(accountAsJSON,Account.class);
    	em.merge(updated);
    }
    
 



}
