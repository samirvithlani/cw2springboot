package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.ExamBean;

@Repository
public class ExamDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addExam(ExamBean examBean) {

		return jdbcTemplate.update("insert into exam(eName,perqueMarks,totalnoquestion,isNag,subid)values(?,?,?,?,?)",
				examBean.geteName(), examBean.getPerQuestionMarks(), examBean.getTotalNoQues(), examBean.isNag(),
				examBean.getSubId());

	}

	public List<ExamBean> getAllExams() {

		return jdbcTemplate.query("select * from exam natural join sibject", new ExamMapper());

	}

	private class ExamMapper implements RowMapper<ExamBean> {

		@Override
		public ExamBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			//
			ExamBean examBean = new ExamBean();
			examBean.seteId(rs.getInt("eid"));
			examBean.seteName(rs.getString("ename"));
			examBean.setPerQuestionMarks(rs.getInt("perqueMarks"));
			examBean.setTotalNoQues(rs.getInt("totalnoquestion"));
			examBean.setSubId(rs.getInt("subid"));
			examBean.setSubName(rs.getString("subname"));

			return examBean;
		}

	}

}
