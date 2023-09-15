package edu.kh.todo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.dto.TodoMember;

@Repository
public class TodoDao {
   
   @Autowired
   private SqlSessionTemplate sqlSession;

   public int idCheck(String id) {
      return sqlSession.selectOne("todoMapper.idCheck", id);
   }
   
   public int signup(TodoMember member) {
      return sqlSession.insert("todoMapper.signup", member);
   }

   public TodoMember login(TodoMember member) {
      return sqlSession.selectOne("todoMapper.login", member);
   }

   public List<Todo> selectTodoLst(int todoMemberNo){
      return sqlSession.selectList("todoMapper.selectTodoLst", todoMemberNo);
   }

   public int insert(Todo todo) {
      return sqlSession.insert("todoMapper.insert", todo);
   }

   public int update(Todo todo) {
      return sqlSession.update("todoMapper.update", todo);
   }

   public int delete(int todoNo) {
      return sqlSession.delete("todoMapper.delete", todoNo);
   }
   

}