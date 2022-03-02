package Test.deepblue.survey.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deepblue.survey.Dao.QuestionDao;
import com.deepblue.survey.Dao.Impl.QuestionDaoImpl;
import com.deepblue.survey.Model.Question;

class questiondaoImplTest {
  private static QuestionDao questiondao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		questiondao = new QuestionDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		questiondao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Ignore
	void testAddquestion() {
		fail("Not yet implemented");
	}

	@Ignore
	void testQuestionManage() {
		fail("Not yet implemented");
	}

	@Ignore
	void testDeletequestion() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatequestion() {
		//fail("Not yet implemented");
		Question que = new Question();
		que.setQuestionId(14);
		que.setQuestionType("测试");
		que.setQuestionDesc("进行测试");
		que.setIsChoice("是");
		que.setOptionA("测");
		que.setOptionB("试");
	    que.setOptionC("单");
	    que.setOptionD("元");
	    que.setOptionE("!");
	    boolean result = questiondao.Updatequestion(que);
	    assertTrue(result);
		
	}

}
