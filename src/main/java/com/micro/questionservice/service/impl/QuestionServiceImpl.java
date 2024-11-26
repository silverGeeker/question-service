package com.micro.questionservice.service.impl;

import com.micro.questionservice.dao.QuestionDao;
import com.micro.questionservice.model.Question;
import com.micro.questionservice.model.QuestionWrapper;
import com.micro.questionservice.model.Response;
import com.micro.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    @Override
    public Map<String, Object> getQuestionsByCategory(Question questionObj){
        Map<String, Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();

        List<Question> questionList = new ArrayList<>();
         questionList.addAll(questionDao.getQuestionsByCategory(questionObj));

        // boolean categoryExists=true;
        if (errorList.isEmpty() && !questionList.isEmpty()) {
            resultMap.put("status", "success");
            resultMap.put("Questions", questionList);
            resultMap.put("errorList", errorList);
            resultMap.put("message", "Category Found");
        } else {
            resultMap.put("status", "success");
            resultMap.put("errorList", errorList);
            resultMap.put("message", "Category Not Found");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> addQuestion(Question questionObj){
        Map<String, Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();

        boolean questionAdded=false;
        questionAdded = questionDao.addQuestion(questionObj);
        if (questionAdded && errorList.isEmpty()) {
            resultMap.put("status", "success");
            resultMap.put("errorList", errorList);
            resultMap.put("message", "Question Added");
        }
        else {
            resultMap.put("status", "success");
            resultMap.put("errorList", errorList);
            resultMap.put("message", "Question Not Added");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getRandomQuestionListByCategory(Question questionObj){
        Map<String, Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        List<QuestionWrapper> questionList = new ArrayList<>();

        questionList = questionDao.getRandomQuestionListByCategory(questionObj.getCategory());

        if(questionList.isEmpty()){
            errorList.add("Category Not Found");
        }
        if (errorList.isEmpty()) {
            resultMap.put("status", "success");
            resultMap.put("Questions", questionList);
            resultMap.put("errorList", errorList);
            resultMap.put("message", "QuestionID Added");
        }
        else {
            resultMap.put("status", "success");
            resultMap.put("errorList", errorList);
            resultMap.put("message", "Questions Not Added");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getScore(List<Response> responseList){
        Map<String, Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();

        int score = 0;
        for(Response response : responseList){
            String correctAnswer;
            correctAnswer = questionDao.getCorrectAnswerByQuestionID(response.getId());
            if(correctAnswer.equalsIgnoreCase(response.getResponse()))
                score++;
        }
        if (errorList.isEmpty()) {
            resultMap.put("status", "success");
            resultMap.put("score", score);
            resultMap.put("errorList", errorList);
            resultMap.put("message", "Score generated");
        }
        else {
            resultMap.put("status", "success");
            resultMap.put("errorList", errorList);
            resultMap.put("message", "Score Not generated");
        }
        return resultMap;
    }
}
