package com.deepblue.survey.Dao;

import java.util.List;

import com.deepblue.survey.Model.Question;

public interface QuestionDao {
public boolean Addquestion(Question question);
public List<Question> QuestionManage();
public boolean Deletequestion(Question question);
public boolean Updatequestion(Question question);
public Question getQuestionId(int qeustionId);
}
