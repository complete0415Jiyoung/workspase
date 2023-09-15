package edu.kh.todo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.dto.TodoMember;
import edu.kh.todo.model.dao.TodoDao;

@Service
public class TodoServiceImpl implements TodoService{

   @Autowired
   private TodoDao dao;
   
   @Override
   public int idCheck(String id) {
      return dao.idCheck(id);
   }
   
   @Transactional(rollbackFor = Exception.class)
   @Override
   public int signup(TodoMember member) {
      return dao.signup(member);
   }

   @Override
   public Map<String, Object> login(TodoMember member) {
      
      TodoMember loginMember = dao.login(member);
      
      Map<String, Object> map = new HashMap<>();
      map.put("loginMember", loginMember);

      if(loginMember != null) {
         List<Todo> todoList = dao.selectTodoLst(loginMember.getTodoMemberNo());
         map.put("todoList", todoList);
      }
      
      return map;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public int insert(Todo todo) {
      int result = dao.insert(todo);
      return result > 0 ? todo.getTodoNo() : 0;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public int update(Todo todo) {
      return dao.update(todo);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public int delete(int todoNo) {
      return dao.delete(todoNo);
   }
   
}