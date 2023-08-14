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

	public int updateInfo(Member updateMember) {

		//return sqlSession.update("namespace.id", 전달할 );
		return sqlSession.update("myPageMapper.updateInfo", updateMember);
	}
	

}
