package buisness;

import java.util.List;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
//import javax.transaction.*;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
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
    
    @Transactional(REQUIRED)
    public String createAccount(Account account) {
    	em.persist(account);
    	return "Account has been created";
    }
    
    @Transactional(REQUIRED)
    public String deleteAccount(Account account) {
    	em.remove(account);
    	return "Account has been deleted";
    }
    @Transactional(REQUIRED)
    public String updateAccount(long id, String accountAsJSON) {
    	Account original=em.find(Account.class,id);
    	Account updated=ju.getObjectForJSON(accountAsJSON,Account.class);
    	if (original!=null) {
    		em.merge(updated);
    		return "Account has been updated";
    	}
    	
    	return "Account has not been updated";
    }
    
 



}
