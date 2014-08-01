/**
 * 
 */
package com.redhat.bootcamp;

import com.redhat.bootcamp.User;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.transaction.UserTransaction;

/**
 * @author sparekh
 * 
 */
public class UserController {

	@javax.persistence.PersistenceUnit private EntityManagerFactory emf;
	@Resource private UserTransaction utx;
	@PersistenceContext(unitName = "jpaDemo")
	private EntityManager em;
	private User aUser = new User();
	private String firstName;
	private String lastName;
	private java.lang.Integer id;

	/**
	 * 
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return aUser.getfirstName();
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		aUser.setfirstName(this.firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return aUser.getlastName();
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
		aUser.setlastName(this.lastName);
	}

	/**
	 * @return the id
	 */
	public java.lang.Integer getId() {
		return aUser.getId();
		//return aUser.getId();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(java.lang.Integer id) {
		this.id = 0;
		aUser.setId(this.id);
	}
	
	public String persistToDB() throws Exception {
		em = emf.createEntityManager();
		aUser.setId(0);
		try {
			if (aUser.getfirstName().isEmpty() || aUser.getlastName().isEmpty()) {
				throw new Exception("No First Name or Last Name.");
			}
			utx.begin();
			em.joinTransaction();
			em.persist(aUser);
			//em.flush();
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				return "error";
			} catch (Exception f) {
				
			}
		} finally {
			em.close();
		}
		return "persisted";
	}

}
