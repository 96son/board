package com.msoffice.work.board;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
//	Mybatis 사용방식

//	1. sqlSessionTemplate : MyBatis3.0 이전
//	- Mybatis 쿼리문을 수행해주는 역할
//	- Mybatis3.0 이전에 사용하던 방식이며 DAO클래스에 직접 SqlSession객체를 선언하고 
//	  @Autowired로 의존주입하여 쿼리문을 수행 하는 방식.
//	- 
//	
//	2. MapperInterface : Mybatis 3.0버전
//	- DAO클래스를 쿼리문을 수행해주는 Mapper xml에서 구현합니다.
//	- SqlSessionTemplate방식을 사용할때 작성하는 DAO클래스는 Controller->Service 로 부터 
//	  DAO 인터페이스에 선언된 추상메서드를 호출받았을때 추상메서드의 기능을 구현해 주는 클래스.
//
//	- DAO클래스에서는 메서드를 통해 쿼리문을 실행하여 DB정보수행 까지 도달하기위한 쿼리문 수행 메서드를 구현.
//	- MapperInterface는 DAO클래스를 생략하고 Mapper xml파일과 DAO인터페이스를 직접 연결해주는 방식.
//	- root-context.xml에 <mybatis-spring:scan basepacage="인터페이스의 패키지경로" />를 등록.
	
	
	
	//회원가입
	@Override
	public void regJoin(BoardVO boardVO) {

//		String pw = passwordEncoder.encode(memberVO.getMemberPw());
//		BoardVO.setMemberPw(pw);
		
		if ( boardVO.getRepeatMemberPw().equals(boardVO.getMemberPw()) 
				&& !boardVO.getRepeatMemberPw().equals("")) {
				sqlSessionTemplate.insert("boardMapper.regJoin", boardVO);
		}
		
	}
	
	//로그인 확인
	public BoardVO loginCheck(BoardVO boardVO) {
		return sqlSessionTemplate.selectOne("boardMapper.loginCheck", boardVO);
	}
	
	
	//게시판 조회
	@Override
	public List<BoardVO> selectBoardList(Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectList("boardMapper.selectBoardList",paramMap);
	}

	//게시판 상세조회
	@Override
	public BoardVO selectBoardDtl(Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectOne("boardMapper.selectBoardDtl",paramMap);
	}

















}
