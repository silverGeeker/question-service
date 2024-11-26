package com.micro.questionservice.model;

public class Response {
    private Integer id;
    private String response;
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Response(String response, Integer id, Integer score) {
        this.response = response;
        this.id = id;
        this.score = score;
    }
}
