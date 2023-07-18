package edu.kh.community.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor

public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String memberNickname;
	private String createDate;
	private int readCount;
	private String thumbnail;
	

}
