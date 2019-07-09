package com.example.registrationForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="users")
public class userEntity {
	
    public userEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="second_name")
    private String secondName;
	
    @Column(name="number")
    private String phoneNo;
    
    @Column(name="email_id")
    private String emailId;
    
    @Column(name="address")
    private String address;
    
    
    
    public userEntity(String firstName, String secondName, String phoneNo, String emailId, String address) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}
	
    public String getSecondName() {
		return secondName;
	}
	
    public String getPhoneNo() {
		return phoneNo;
	}
	
    public String getEmailId() {
		return emailId;
	}
	
    public String getAddress() {
		return address;
	}

    
   

}
