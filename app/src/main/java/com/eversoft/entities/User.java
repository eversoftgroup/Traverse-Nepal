package com.eversoft.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("visaId")
    @Expose
    private Integer visaId;
    @SerializedName("loginId")
    @Expose
    private Integer loginId;
    @SerializedName("avatarUrl")
    @Expose
    private String avatarUrl;
    @SerializedName("visaInformation")
    @Expose
    private Object visaInformation;
    @SerializedName("loginInformation")
    @Expose
    private UserLogin loginInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getVisaId() {
        return visaId;
    }

    public void setVisaId(Integer visaId) {
        this.visaId = visaId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Object getVisaInformation() {
        return visaInformation;
    }

    public void setVisaInformation(Object visaInformation) {
        this.visaInformation = visaInformation;
    }

    public UserLogin getLoginInformation() {
        return loginInformation;
    }

    public void setLoginInformation(UserLogin loginInformation) {
        this.loginInformation = loginInformation;
    }

}