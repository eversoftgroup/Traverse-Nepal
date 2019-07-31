package com.eversoft.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class VisaInformation {

    @SerializedName("id")
    private int id;

    @SerializedName("documentType")
    private String documentType;

    @SerializedName("documentNumber")
    private String documentNumber;

    @SerializedName("expiryDate")
    private Date expiryDate;

    @SerializedName("visaType")
    private String visaType;

    @SerializedName("visaPeriod")
    private int visaPeriod;

    public VisaInformation() {
    }

    public VisaInformation(int id, String documentType, String documentNumber, Date expiryDate, String visaType, int visaPeriod) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.expiryDate = expiryDate;
        this.visaType = visaType;
        this.visaPeriod = visaPeriod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public int getVisaPeriod() {
        return visaPeriod;
    }

    public void setVisaPeriod(int visaPeriod) {
        this.visaPeriod = visaPeriod;
    }

}
