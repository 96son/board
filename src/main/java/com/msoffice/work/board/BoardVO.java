package com.msoffice.work.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	
	//회원
	@NotBlank(message = "ID는 필수입력입니다.")
	private String memberId;
	@NotBlank
	private String memberPw;
	//비밀번호재확인
	@NotBlank
	private String repeatMemberPw;
	
	
	@NotBlank(message = "이름은 필수입력입니다.")
	@Size(max = 5, message = "이름의 길이를 초과했습니다") //max = 5 글자 길이 5개까지 가능(영어 숫자 관계없이)
	private String memberName;
	private String email;
	private String nickName;
	@NotBlank(message = "성별확인은 필수입력입니다.")
	private String genderYn;
	@NotBlank
	private String adminYn;
	private String memberCreateDate;
	
	//게시판
	private int boardSeq;
	private String boardTitle;
	private String boardContent;
	private String boardRegDate;
	//private String memberId; 중복으로 주석처리
	private String securYn;
	private int readCnt;
	
}
