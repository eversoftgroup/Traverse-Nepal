package com.eversoft.ViewObjects;

import android.widget.ImageView;

public class Help_List_Item {

    private String question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String answer;
    private ImageView image;

    public Help_List_Item(String ques, String ans){
        question = ques;
        answer = ans;
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






