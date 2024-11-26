package com.micro.questionservice.dao;

import com.micro.questionservice.mappers.QuestionMapper;
import com.micro.questionservice.model.Question;
import com.micro.questionservice.model.QuestionWrapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {

    @Autowired
    private SqlSession sqlSession;

    public List<Question> getAllQuestions() {
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        return mapper.getAllQuestions();
    }

    public List<Question> getQuestionsByCategory(Question questionObj){
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        return mapper.getQuestionsByCategory(questionObj);
    }

    public boolean addQuestion(Question questionObj){
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        return mapper.addQuestion(questionObj);
    }

    public List<QuestionWrapper> getRandomQuestionListByCategory(String category){
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        return mapper.getRandomQuestionListByCategory(category);
    }

    public boolean insertQuestionIdForQuiz(List<Integer> questionIdList){
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        return mapper.insertQuestionIdForQuiz(questionIdList);
    }

    public String getCorrectAnswerByQuestionID(Integer id){
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        return mapper.getCorrectAnswerByQuestionID(id);
    }

}
