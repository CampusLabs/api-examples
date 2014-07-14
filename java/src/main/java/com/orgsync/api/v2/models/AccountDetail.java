package com.orgsync.api.v2.models;

import java.util.Date;
import java.util.List;

/**
 * A POJO for the response for an Account.
 *
 * NOTE: This doesn't include the custom profile fields yet.
 */
public class AccountDetail {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;
    private Date lastLogin;
    private String picUrl;
    private List<Integer> orgIds;

    public final String getPicUrl() {
        return picUrl;
    }

    public final List<Integer> getOrgIds() {
        return orgIds;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    @Override
    public String toString() {
        return "AccountDetail{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", lastLogin=" + lastLogin +
                ", picUrl='" + picUrl + '\'' +
                ", orgIds=" + orgIds +
                '}';
    }
}
