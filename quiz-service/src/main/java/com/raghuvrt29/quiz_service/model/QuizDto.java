package com.raghuvrt29.quiz_service.model;

public class QuizDto {

    private String title;
    private String category;
    private int numQ;

    public QuizDto(String title, String category, int numQ) {
        this.title = title;
        this.category = category;
        this.numQ = numQ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumQ() {
        return numQ;
    }

    public void setNumQ(int numQ) {
        this.numQ = numQ;
    }
}
