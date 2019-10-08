package com.codegym.cms.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
//import java.util.regex.Pattern;

@Entity
@Table(name = "customers_validate")
@Component
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min=5,max=45)
    private String firstName;
    @NotEmpty
    @Size(min=5,max=45)
    private String lastName;

    @Size(min=10,max=10)
    @Pattern(regexp = "(^$|[0-9]*$)")
    private String phoneNumber;
    @Min(18)
    private Long age;
    @Pattern(regexp = "(^[A-Za-z0-9+_.-]+@(.+)$)")
    private String email;

    public Customer() {}

    public Customer(@NotEmpty @Size(min = 5, max = 45) String firstName, @NotEmpty @Size(min = 5, max = 45) String lastName, @Size(min=9,max=10) @Pattern(regexp = "(^$|[0-9]*$)") String phoneNumber, @Min(18) Long age, @Pattern(regexp = "(^[A-Za-z0-9+_.-]+@(.+)$)") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s', age='%d' ,email='%s']", id, firstName, lastName ,age,email);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

