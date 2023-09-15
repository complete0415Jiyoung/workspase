package edu.kh.todo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.dto.TodoMember;
import edu.kh.todo.model.service.TodoService;

@RestController
public class TodoController {
   
   // org.slf4j.Logger : 로그를 작성할 수 있는 객체
   // org.slf4j.LoggerFactory
   private Logger logger = LoggerFactory.getLogger(TodoController.class);
   
   @Autowired
   private TodoService service;   
   
   /** 아이디 중복 검사*/
   @GetMapping("idCheck")
   public int idCheck(String id) {
      logger.info(id);
      return service.idCheck(id);
   }
   
   /** 회원 가입 */
   @PostMapping(value="/signup", produces="application/json; charset=UTF-8" )
   public int signup(@RequestBody TodoMember member) {
      
      logger.info(member.toString());
      return service.signup(member);
   }
   
   
   @PostMapping("/login")
   public Map<String, Object> login(@RequestBody TodoMember member){ 
      return service.login(member);
   }
   
   
   @PostMapping("/todo")
   public int insert(@RequestBody Todo todo) {
      return service.insert(todo);
   }
   
   
   @PutMapping("/todo")
   public int update(@RequestBody Todo todo) {
      return service.update(todo);
   }
   
   
   @DeleteMapping("/todo")
   public int delete(@RequestBody int todoNo) {
      return service.delete(todoNo);
   }
   
   
   @GetMapping("/test")
   public int test() {
      return 100;
   }

}