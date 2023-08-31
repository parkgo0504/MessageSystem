package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	public int insertWirte(Board board) {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		int cnt = sqlSession.insert("boardWirte", board);

		sqlSession.close();

		return cnt;
	}
	ArrayList<Board> list = new ArrayList<>();
	public ArrayList<Board> showBoard() {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		list = (ArrayList) sqlSession.selectList("selectBoard");

		sqlSession.close();

		return list;
	}

}
