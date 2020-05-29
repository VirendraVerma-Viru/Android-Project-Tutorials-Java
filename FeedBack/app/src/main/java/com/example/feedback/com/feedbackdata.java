package com.example.feedback.com;

import java.io.Serializable;

public class feedbackdata implements Serializable {

    private String name,feedback;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public feedbackdata(String name, String feedback) {
        this.name = name;
        this.feedback = feedback;
    }
}
