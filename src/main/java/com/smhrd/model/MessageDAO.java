package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MessageDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	public int insertMsg(Message messages) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		
		int cnt = sqlSession.insert("insertMsg", messages);

		sqlSession.close();

		return cnt;
	}
	
	ArrayList<Message> list = new ArrayList<>();
	
	public ArrayList<Message> showMessage(String email) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		list = (ArrayList) sqlSession.selectList("selectAll", email);
		
		sqlSession.close();
		
		return list;
	}
	
	public int deleteOne(int num) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		
		int cnt = sqlSession.delete("deleteOne", num);

		sqlSession.close();

		return cnt;
	}
	
	public void deleteAll() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		
		sqlSession.delete("deleteAll");

		sqlSession.close();

	}
}
