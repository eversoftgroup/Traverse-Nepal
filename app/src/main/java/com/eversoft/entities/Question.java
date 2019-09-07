package com.eversoft.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("question")
    @Expose
    private String question;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("votes")
    @Expose
    private Integer votes;

    @SerializedName("userId")
    @Expose
    private Integer userId;

    @SerializedName("insertDate")
    @Expose
    private String insertDate;

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getDescription() {
        return description;
    }

    public Integer getVotes() {
        return votes;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
}
