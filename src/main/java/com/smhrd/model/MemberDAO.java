package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {
	// 자바와 DB의 연결을 위한 작업 -> 어떤 작업을 처리할 것인지 연결!

	// 0. SqlSessionManger(클래스 이름) 기능 불러오기
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// 회원가입을 진행할 수 있는 메소드!
	public int join(Member member) {
		// 1. 데이터베이스 연결 -> 연결 객체 대여!
		// true == auto commit과 같은 기능
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		// 2. sql문장 선택
		// 실행하고자 하는 문장은 MemberMapper.xml에 정의되어 있어야 한다.
		int cnt = sqlSession.insert("join", member);

		// 3. 결과값 처리 -> 성공시 main.jsp / 실패시 join.jsp

		// 4. 데이터베이스 종료
		sqlSession.close();

		return cnt;

	}

	public Member login(Member member) {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		Member info = sqlSession.selectOne("login", member);

		sqlSession.close();

		return info;

	}

}
