package com.orgsync.api.v2.models;

/**
 * A simple POJO that describes the account attribute map used in the AccountCreateRequest
 */
public class AccountAttributes {
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;

    public AccountAttributes(String emailAddress, String firstName, String lastName,
                             String middleInitial, String phoneNumber, String address,
                             String city, String state, String zip) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
