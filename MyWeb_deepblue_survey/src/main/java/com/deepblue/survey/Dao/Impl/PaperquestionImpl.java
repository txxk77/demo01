package com.deepblue.survey.Dao.Impl;

import com.deepblue.survey.Dao.PaperquestionDao;
import com.deepblue.survey.Model.Paperquestion;
import com.deepblue.survey.Model.Question;
import com.deepblue.survey.Util.OperationsUtil;

public class PaperquestionImpl extends OperationsUtil implements PaperquestionDao{

	@Override
	public boolean AddPaperquestion(Paperquestion paperquestion) {
		String sql="insert into paperQuestion(paperQuestionId,paperId,questionId) value(?,?,?)";
		Object[] obj= {paperquestion.getPaperQuestionId(),paperquestion.getPaperId(),paperquestion.getQuestionId()};
		boolean result=executeCUD(sql,obj);
		return result;
	}

}
