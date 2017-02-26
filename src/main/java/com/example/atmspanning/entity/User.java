package com.example.atmspanning.entity;
import javax.persistence.*;

@Entity
@Table(name = "user", indexes = {
        @Index(name = "unq_userName_pin", columnList = "user_name, pin", unique = true)
})
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "pin", nullable = false)
    private Integer pin;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    
    

}
