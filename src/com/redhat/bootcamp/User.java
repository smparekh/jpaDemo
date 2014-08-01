/**
 * 
 */
package com.redhat.bootcamp;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author sparekh
 *
 */
@Entity
@Table(name="\"User\"")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"ID\"")
	private int id;

	@Column(name="\"fName\"")
	private String fName;

	@Column(name="\"lName\"")
	private String lName;
	
	
	public User() {
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfirstName() {
		return this.fName;
	}

	public void setfirstName(String fName) {
		this.fName = fName;
	}

	public String getlastName() {
		return this.lName;
	}

	public void setlastName(String lName) {
		this.lName = lName;
	}

}
