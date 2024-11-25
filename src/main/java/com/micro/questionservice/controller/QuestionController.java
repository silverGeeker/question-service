package com.micro.questionservice.controller;

import com.micro.questionservice.model.Question;
import com.micro.questionservice.service.QuestionService;
import com.micro.questionservice.service.impl.QuestionServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("question")
public class QuestionController {

    private static final Logger LOGGER = LogManager.getLogger(QuestionServiceImpl.class.getName());

    @Autowired
    private QuestionService questionService;

    @GetMapping("getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping ("getQuestionsByCategory")
    public Map<String, Object> getQuestionsByCategory(@RequestBody Question questionObj, HttpServletRequest req) {
        Map<String, Object> resultMap = new HashMap<>();
        try{
            resultMap=questionService.getQuestionsByCategory(questionObj);
        }catch(Exception e){
            LOGGER.error("Exception"+e.getCause());
        }
        return resultMap;
    }

    @PostMapping ("addQuestion")
    public Map<String, Object> addQuestion(@RequestBody Question questionObj, HttpServletRequest req) {
        Map<String, Object> resultMap = new HashMap<>();
        try{
            resultMap=questionService.addQuestion(questionObj);
        }catch(Exception e){
            LOGGER.error("Exception"+e.getCause());
        }
        return resultMap;
    }

    @PostMapping ("generateQuestionIdList")
    public Map<String, Object> getRandomQuestionIdListByCategory(@RequestBody Question questionObj, HttpServletRequest req) {
        Map<String, Object> resultMap = new HashMap<>();
        try{
            resultMap=questionService.getRandomQuestionIdListByCategory(questionObj);
        }catch(Exception e){
            LOGGER.error("Exception"+e.getCause());
            e.printStackTrace();
        }
        return resultMap;
    }

}
