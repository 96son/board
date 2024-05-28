package com.msoffice.work.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name = "boardService")// bean에서 끌어다 쓴 BoardServiceImpl객체
	private BoardServiceImpl boardServiceImpl;
	
	
	//view
	
	//로그인 페이지
	@GetMapping("/viewLoginPage")
	public String viewLoginPage() {
		return "pages/board/viewLoginPage";
	}
	
	// 회원가입 페이지
	@GetMapping("/viewJoinPage") 
	public String viewJoinPage() {
		return "pages/board/viewJoinPage"; 
	}
	 
	
	//메인 페이지
	@RequestMapping("/viewMainPage")
	public String viewMainPage() {
		return "pages/board/viewMainPage";
	}

	

	
	
	
	//기능
	
	// 회원가입 
	@PostMapping("/regJoin") 
	public String regJoin(BoardVO boardVO) {
		boardServiceImpl.regJoin(boardVO);
		return "redirect:/board/viewMainPage";
	}
	// 로그인 
	@RequestMapping("/loginProcess") 
	public String loginProcess(BoardVO boardVO, HttpSession httpSession) {
		
		String loginCheck = boardServiceImpl.loginCheck(boardVO).getMemberName();
		
		if (loginCheck != null) {
			httpSession.setAttribute("memberId", boardVO.getMemberId());
			httpSession.setAttribute("nickName", boardVO.getNickName());
		
			//세션 유지기간 30분
			httpSession.setMaxInactiveInterval(60*30);
			return"redirect:/board/viewMainPage";
		}
		else {
			return "redirect:/board/viewLoginPage";
		}
	}
	
	
	
	
	
	
	// 테스트용 데이터테이블 페이지
	@RequestMapping("/tables")
	public String tables(Model model) {
		
		List<BoardVO> boardList = new ArrayList<>();
		boardList.add(new BoardVO());
		boardList.get(0).setBoardTitle("dkfjksdjfklsdjfkljsd");
		boardList.add(new BoardVO());
		boardList.get(1).setBoardTitle("11111");
		boardList.add(new BoardVO());
		boardList.get(2).setBoardTitle("2222222");
		
		model.addAttribute("boardList", boardList);
		
		
		return "pages/board/tables";
	}
	
	
	//게시판 조회(임시)
	@RequestMapping("/selectBoardList") 
	public String selectBoardList(Model model, Map<String, Object> paramMap) {
		//model.addAttribute("boardList", boardServiceImpl.selectBoardList(paramMap));
		
		
		return "redirect:/board/tables";
	}
	
	
	
	
	
	
	
	
	
	//게시판 페이지
	@RequestMapping("/viewBoardPage")
	public String viewBoardPage() {
		return "pages/board/viewBoardPage";
	}
	
	
	
	
}
