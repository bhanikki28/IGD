package com.nikki.jpa.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EMPLOYEE_DETAILS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Data
@Getter
@Setter

public class EmployeeDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID")
	private String employeeId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	public EmployeeDetails() {
		
	}
	
	

	public EmployeeDetails(String employeeId, String firstName, String lastName, String designation,
			String emailAddress) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.emailAddress = emailAddress;
	}



	@Override
	public int hashCode() {
		return Objects.hash(designation, emailAddress, employeeId, firstName, lastName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDetails other = (EmployeeDetails) obj;
		return Objects.equals(designation, other.designation) && Objects.equals(emailAddress, other.emailAddress)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}



	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", emailAddress=" + emailAddress + "]";
	}
	
	


	
}
