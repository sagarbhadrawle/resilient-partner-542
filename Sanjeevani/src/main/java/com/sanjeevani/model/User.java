package com.sanjeevani.model;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

public class User implements UserDetails, CredentialsContainer {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, max = 20)
	private String name;
	
	@Past(message = "Invalid date of birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@NotNull(message = "Gender must be specified")
	private String gender;
	
	@Size(min = 2, max = 80)
	private String address;
	
	@Size(min = 2, max = 40)
	private String city;
	
	@Size(min = 2, max = 40)
	private String state;
	
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid  PIN code")
	private String pincode;
	
	@Email(message = "Provide Email in valid format")
	@Column(unique = true)
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String role;
	@Column(unique = true)
	private String panNo;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Please provide value for addharNo")
	@Pattern(regexp = "^[1-9][0-9]{11}$", message = "Invalid Aadhaar no")
	private String aadharNo;

	@JsonIgnore
	@OneToOne
	private Member member;

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		
		return getAadharNo();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}