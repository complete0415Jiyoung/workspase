package edu.kh.project.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // 저장소(DB)와 관련된 클래스 + Bean등록(IOC, 스프링이 객체를 관리)
public class MyPageDAO {
	
	// 등록된 Bean 중에서 타입이 SqkSessionTemplate을 찾아서 Bean를 주입(DI)
	// -> root-context.xml에 <Bean> 작성됨
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 회원 정보 수정
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember) {

		//return sqlSession.update("namespace.id", 전달할 );
		return sqlSession.update("myPageMapper.updateInfo", updateMember);
	}

	
	
	/** 회원의 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	public String selectEncPw(int memberNo) {
		return sqlSession.selectOne("myPageMapper.selectEncPw", memberNo);
	}



	/** 비밀번호 변경
	 * @param encode
	 * @param memberNo
	 * @return result
	 */
	public int changePw(String newPw, int memberNo) {
		
		// Mybatis에서는 SQL 수행시 
		// 전달할 수 있는 파라미터는 딱 하나!
		// 여러 파라미터를 전달해야 하는경우
		// Map 또는 DTO로 묶어서 전달
		
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberPw(newPw);
		
		return sqlSession.update("myPageMapper.changePw", member);
	}



	/** 회원 탈퇴
	 * @param memberNo
	 * @return result
	 */
	public int secession(int memberNo) {
		
		//sqlSessionTemplate : 마이바티스 + DBCP + close자동 + 트렌젝션처리
		return sqlSession.update("myPageMapper.secession", memberNo);
	}
	

}