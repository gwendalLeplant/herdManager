package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {

	private String names;
	@Column(name = "breeding_name")
	private String breedingName;
	@Column(name = "email_address")
	private String emailAddress;
	private String address;
	private String city;
	@Column(name = "zip_code")
	private Integer zipCode;
	private String country;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "home_number")
	private String homeNumber;
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;

}
