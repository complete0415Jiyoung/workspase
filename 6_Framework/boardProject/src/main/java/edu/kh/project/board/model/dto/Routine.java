package edu.kh.project.board.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Routine {

	private int RoutionNo;
	private String RoutineTitle;
	private String RoutineContent;
	private int boardNo;
	private int RoutineLevel;
}
