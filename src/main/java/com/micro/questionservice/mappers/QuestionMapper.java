package com.micro.questionservice.mappers;

import com.micro.questionservice.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    public List<Question> getAllQuestions();

}
