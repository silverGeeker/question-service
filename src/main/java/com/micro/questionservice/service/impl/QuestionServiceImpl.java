package com.micro.questionservice.service.impl;

import com.micro.questionservice.dao.QuestionDao;
import com.micro.questionservice.model.Question;
import com.micro.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }
}
