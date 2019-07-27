package com.eversoft.ViewObjects;

import android.widget.ImageView;

public class Help_List_Item {

    private String question;
    private ImageView image;

    public Help_List_Item(String ques){
        question = ques;
    }
    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}






