package com.deepblue.survey.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.deepblue.survey.Dao.QuestionDao;
import com.deepblue.survey.Model.Question;
import com.deepblue.survey.Util.OperationsUtil;

public class QuestionDaoImpl extends OperationsUtil implements QuestionDao{

	@Override
	public boolean Addquestion(Question question) {
		String sql="insert into question(questionId,questionType,questionDesc,isChoice,optionA,optionB,optionC,optionD,optionE) value(?,?,?,?,?,?,?,?,?)";
		Object[] obj= {question.getQuestionId(),question.getQuestionType(),question.getQuestionDesc(),question.getIsChoice(),question.getOptionA(),question.getOptionB(),question.getOptionC(),
				question.getOptionD(),question.getOptionE()};
		boolean result = executeCUD(sql,obj);
		return result;
	}

	@Override
	public List<Question> QuestionManage() {
		List<Question> questionList = new LinkedList();
		Question question=null;
		String sql="select * from question";
		ResultSet rs = execute_Read(sql,null);
		try {
			while(rs.next()) {
			 int questionId = rs.getInt("questionId"); 
			 String questionType=rs.getString("questionType"); 
			 String questionDesc=rs.getString("questionDesc");  
			 String isChoice=rs.getString("isChoice"); 
			 String optionA=rs.getString("optionA");			 
			 String optionB=rs.getString("optionB");
			 String optionC=rs.getString("optionC");
			 String optionD=rs.getString("optionD");
			 String optionE=rs.getString("optionE");
			 question=new Question(questionId,questionType,questionDesc,isChoice,optionA,
					 optionB,optionC,optionD,optionE);
			 questionList.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionList;
	}

	@Override
	public boolean Deletequestion(Question question) {
		String sql="delete from question where questionId=?";
		Object[] obj= {question.getQuestionId()};
		boolean result=executeCUD(sql,obj);
		return result;
	}

	@Override
	public boolean Updatequestion(Question question) {
		String sql="update question set questionType=?,questionDesc=?,isChoice=?,optionA=?,optionB=?,optionC=?,optionD=?,optionE=? where questionId=?";
		Object[] obj= {question.getQuestionType(),question.getQuestionDesc(),question.getIsChoice(),
				question.getOptionA(),question.getOptionB(),question.getOptionC(),question.getOptionD(),
				question.getOptionE(),question.getQuestionId()};
		boolean result=executeCUD(sql,obj);
		return result;
	}

	@Override
	public Question getQuestionId(int questionid) {
		Question question=null;
		String sql="select * from question where questionId=?";
		Object[] obj= {questionid};
		ResultSet rs = execute_Read(sql,obj);
		try {
			if(rs.next()) {
				 int questionId = rs.getInt("questionId"); 
				 String questionType=rs.getString("questionType"); 
				 String questionDesc=rs.getString("questionDesc");  
				 String isChoice=rs.getString("isChoice"); 
				 String optionA=rs.getString("optionA");			 
				 String optionB=rs.getString("optionB");
				 String optionC=rs.getString("optionC");
				 String optionD=rs.getString("optionD");
				 String optionE=rs.getString("optionE");
			   question=new Question(questionId,questionType,questionDesc,isChoice,optionA,
						 optionB,optionC,optionD,optionE);	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return question;
	}

}
