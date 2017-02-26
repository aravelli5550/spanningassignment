package com.example.atmspanning.entity;
import javax.persistence.*;


@Entity
@Table(name = "account")
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private long accountId;
	
	 @Column(name = "balance", nullable = false)
	 private long balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}
