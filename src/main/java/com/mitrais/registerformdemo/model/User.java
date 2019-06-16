package com.mitrais.registerformdemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Email(message = "Your email address is not valid")
    @NotEmpty(message = "You have to enter your email")
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    @NotEmpty(message = "You have to enter your mobile number")
    @Pattern(regexp = "(0)+([0-9]{9})", message = "Your mobile number is not valid")
    private String mobileNumber;
    
    @NotEmpty(message = "You have to enter your first name")
    private String firstName;
    
    @NotEmpty(message = "You have to enter your last name")
    private String lastName;
    
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = true)
    private Date dateOfBirth;
    
    @Column(nullable = true)
    private int gender;
    
}
