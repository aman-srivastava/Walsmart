package com.aman.model;

import javax.persistence.*;

/**
 * Created by asriva26 on 04/25/18.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long userId;

    private String firstName;

    private String lastName;

    private String userGroup;

    public User(String firstName, String lastName, String userGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userGroup = userGroup;
    }

    public User() {
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

}
