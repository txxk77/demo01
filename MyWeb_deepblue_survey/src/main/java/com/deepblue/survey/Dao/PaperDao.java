package com.deepblue.survey.Dao;

import java.util.List;

import com.deepblue.survey.Model.Paper;
import com.deepblue.survey.Model.Showpaper;

public interface PaperDao {
public boolean Addpaper(Paper paper);
public List<Paper> paperManage();
public boolean Updatepaper(Paper paper);
public Paper getpaperId(int paperId);
public boolean Deletepaper(Paper paper);
public List<Showpaper> showPaper(Paper paper);
public boolean publish(Paper paper);
public boolean unpublish(Paper paper);
}
