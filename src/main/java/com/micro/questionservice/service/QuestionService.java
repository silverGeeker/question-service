package com.micro.questionservice.service;

import com.micro.questionservice.model.Question;
import com.micro.questionservice.model.Response;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    public List<Question> getAllQuestions();

    public Map<String, Object> getQuestionsByCategory(Question questionObj);

    public Map<String, Object> addQuestion(Question questionObj);

    public Map<String, Object> getRandomQuestionListByCategory(Question questionObj);

    public Map<String, Object> getScore(List<Response> responseList);

}
