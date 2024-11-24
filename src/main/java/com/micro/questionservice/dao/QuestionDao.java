package com.micro.questionservice.dao;

import com.micro.questionservice.mappers.QuestionMapper;
import com.micro.questionservice.model.Question;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {

    @Autowired
    private SqlSession sqlSession;

    public List<Question> getAllQuestions() {
        System.out.println("insideDao");
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        return mapper.getAllQuestions();

    }
}
