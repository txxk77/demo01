package com.deepblue.survey.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.deepblue.survey.Dao.PaperDao;
import com.deepblue.survey.Model.Paper;
import com.deepblue.survey.Model.Showpaper;
import com.deepblue.survey.Util.OperationsUtil;

public class PaperDaoImpl extends OperationsUtil implements PaperDao{

	@Override
	public boolean Addpaper(Paper paper) {
		String sql="insert into paper(paperTitle,paperDesc,creatorId,state) value(?,?,?,'未发布')";
		Object[] obj = {paper.getPaperTitle(),paper.getPaperDesc(),paper.getCreatorId()};
		boolean result = executeCUD(sql,obj);
		return result;
	}

	@Override
	public List<Paper> paperManage() {
		String sql="select * from paper";
		List<Paper> paperList=new LinkedList<Paper>();
		Object[] obj= null;
		Paper paper=null;
		ResultSet rs=execute_Read(sql,null);
		 try {
			while(rs.next()) {
			 int paperId=rs.getInt("paperId");
			 String paperTitle=rs.getString("paperTitle");
			 String paperDesc=rs.getString("paperDesc");
			 int creatorId=rs.getInt("creatorId");
			 String state=rs.getString("state");
			 paper=new Paper(paperId,paperTitle,paperDesc,creatorId,state);
			 paperList.add(paper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,null,null);
		}
		return paperList;
	}

	@Override
	public boolean Updatepaper(Paper paper) {
		String sql="update paper set paperTitle=?,paperDesc=? where paperId=?";
		Object[] obj= {paper.getPaperTitle(),paper.getPaperDesc(),paper.getPaperId()};
		boolean result = executeCUD(sql,obj);
		return result;
	}

	@Override
	public Paper getpaperId(int papersId) {
		String sql="select * from paper where paperId=?";
		Paper paper = null;
		Object[] obj = {papersId};
		ResultSet rs=execute_Read(sql,obj);
		  try {
			if(rs.next()) {
				 int paperId=rs.getInt("paperId");
				 String paperTitle=rs.getString("paperTitle");
				 String paperDesc=rs.getString("paperDesc");
				 int creatorId=rs.getInt("creatorId");
				 String state=rs.getString("state");
				 paper=new Paper(paperId,paperTitle,paperDesc,creatorId,state);  
			  }
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			close(rs,null,null);
		}
		return paper;
	}

	@Override
	public boolean Deletepaper(Paper paper) {
		String sql = "delete  from paper where paperId=?";
		Object[] obj= {paper.getPaperId()};
		boolean result = executeCUD(sql,obj);
		return result;
	}

	@Override
	public List<Showpaper> showPaper(Paper paper) {
		List<Showpaper> spList=new LinkedList<Showpaper>();
		Showpaper sp = null;
//String sql="SELECT p.paperId,qu.questionId,p.paperTitle,qu.questionDesc,qu.isChoice,qu.optionA,qu.optionB,qu.optionC,qu.optionD,qu.optionE FROM paperQuestion pq RIGHT JOIN paper p ON pq.paperId=p.paperId RIGHT JOIN question qu ON pq.questionId=qu.questionId WHERE p.paperId=?";
		String sql="SELECT * FROM question WHERE questionId IN (SELECT questionId FROM paperQuestion WHERE paperId=?)";
         Object[] obj= {paper.getPaperId()};
         ResultSet rs = execute_Read(sql,obj);
		try {
			while(rs.next()) {
				//int paperId=rs.getInt("paperId");
				int questionId=rs.getInt("questionId");
				//String paperTitle=rs.getString("paperTitle");
				String questionDesc=rs.getString("questionDesc");
				String isChoice=rs.getString("isChoice");
				String optionA=rs.getString("optionA");
				String optionB=rs.getString("optionB");
				String optionC=rs.getString("optionC");
				String optionD=rs.getString("optionD");
				String optionE=rs.getString("optionE");
		sp= new Showpaper(questionId,questionDesc,isChoice,optionA,optionB,optionC,
						optionD,optionE);
		      spList.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spList;
	}

	@Override
	public boolean publish(Paper paper) {
		String sql="update paper set state='已发布' where paperId=?";
		Object[] obj = {paper.getPaperId()};
		boolean result = executeCUD(sql,obj);
		return result;
	}
	
	public boolean unpublish(Paper paper) {
		String sql="update paper set state='未发布' where paperId=?";
		Object[] obj = {paper.getPaperId()};
		boolean result = executeCUD(sql,obj);
		return result;
	}

}
