package com.msoffice.work.board;

import java.util.List;
import java.util.Map;

public interface BoardService {

	//회원가입
	public void regJoin(BoardVO boardVO);

	//로그인 확인
	public BoardVO loginCheck(BoardVO boardVO);
	
	//게시판 조회
	public List<BoardVO> selectBoardList(Map<String, Object> paramMap);
	
	//게시판 상세조회
	public BoardVO selectBoardDtl(Map<String, Object> paramMap);
	

}
