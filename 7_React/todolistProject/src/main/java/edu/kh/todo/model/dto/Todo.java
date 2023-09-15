package edu.kh.todo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Todo {
	private int todoNo;
	private String title;
	private String isDone;
	private int todoMemberNo;

}
