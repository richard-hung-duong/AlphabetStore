package mum.edu.alphabetstore.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;

@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = 2284040482222162898L;
	@Id
	private Long customerId;

	@NotEmpty(message="{NotEmpty}")
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	@Valid
	private Address billingAddress;
	private String phoneNumber;
	
	public Customer() {
		this.billingAddress = new Address();
	}
	
	public Customer(Long customerId, String name) {
		this();
		this.customerId = customerId;
		this.name = name;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
