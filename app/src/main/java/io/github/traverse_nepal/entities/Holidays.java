package io.github.traverse_nepal.entities;

import com.google.gson.annotations.SerializedName;

public class Holidays {

    @SerializedName("id")
    private Integer id;

    @SerializedName("month")
    private String month;

    @SerializedName("date")
    private String date;

    @SerializedName("day")
    private String day;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
