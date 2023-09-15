import React, { useState, createContext } from 'react';
import './App.css';

import SignupContainer from './Signup';
import Login from './Login';
import TodoList from './TodoList';

export const ToDoListContext = createContext(); //전역 변수 생성


function App() {
  //회원가입, 로그인, 로그인한 회원의 ToDoList 출력/ 추가/ 제거
  const [signupView, setSignupView] = useState(false);

  //로그인한 회원의 정보를 저장 할 수 있는 변수 
  const [loginMember, setLoginMember] = useState(null);

  //로그인한 회원의 todolist를 저장할 변수 
  const [todoList, setTodoList] = useState([]);



  return (
    <ToDoListContext.Provider value={ {setTodoList, setLoginMember , loginMember, todoList} }>
      <button onClick={()=> {setSignupView(!signupView)}}>
        { signupView ? ('회원 가입 닫기') : ('회원 가입 열기') }
      </button>

      <div className='signup- wrapper'>
        {/* signupView가 true인 경우만 회원가입 컴포넌트가 렌더링 */}
        {/* 조건식 && (true인 경우) */}
        {signupView === true && ( <SignupContainer/> )}
      </div>

      <h1>To Do List</h1>
      <Login/>

      <hr/>
      {/* 로그인 되었을 때만 TodoList 컴포넌트 출력 */}
      {loginMember && (<TodoList/>)}


    </ToDoListContext.Provider>

  );
}

export default App;
