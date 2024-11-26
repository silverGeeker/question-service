package com.micro.questionservice.mappers;

import com.micro.questionservice.model.Question;
import com.micro.questionservice.model.QuestionWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    public List<Question> getAllQuestions();

    public List<Question> getQuestionsByCategory(Question questionObj);

    public boolean addQuestion(Question questionObj);

    public List<QuestionWrapper> getRandomQuestionListByCategory(String category);

    public boolean insertQuestionIdForQuiz(List<Integer> questionIdList);

    public String getCorrectAnswerByQuestionID(Integer id);

}
