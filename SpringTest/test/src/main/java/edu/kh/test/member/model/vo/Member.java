package edu.kh.test.member.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private Date memberEnrollDate; // (import : java.sql.Date)

}
