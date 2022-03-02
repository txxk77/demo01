package com.deepblue.survey.Dao.Impl;

import com.deepblue.survey.Dao.SurveyDao;
import com.deepblue.survey.Model.Survey;
import com.deepblue.survey.Util.OperationsUtil;

public class SurveyDaoImpl extends OperationsUtil implements SurveyDao{

	@Override
	public boolean Addanswer(Survey survey) {
		String sql="insert into survey(surveyId,paperId,questionId,answer,surveyTime) value(?,?,?,?,now())";
		Object[] obj= {survey.getSurveyId(),survey.getPaperId(),survey.getQuestionId(),survey.getAnswer()};
		boolean result = executeCUD(sql,obj);
		return result;
	}

}
