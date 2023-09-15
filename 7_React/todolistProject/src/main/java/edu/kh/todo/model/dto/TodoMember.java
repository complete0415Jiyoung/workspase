package edu.kh.todo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class TodoMember {
	private int todoMemberNo;
	private String id;
	private String pw;
	private String name;
}
