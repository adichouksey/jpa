package com.capg;

import java.io.*;
import java.math.BigInteger;

import javax.*;
import javax.persistence.*;

	@Entity
	@Table(name="author1")
	public class Author implements Serializable {
	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue
	    private int authorId;
	    private String firstName;
	    private String lastName;
	    private String middleName;
	    private BigInteger phoneNo;
		public int getAuthorId() {
			return authorId;
		}
		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public BigInteger getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(BigInteger phoneNo) {
			this.phoneNo = phoneNo;
		}
		
		
	    
	}

