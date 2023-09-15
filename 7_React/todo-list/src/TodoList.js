import React, { useState, useContext } from 'react';
import { ToDoListContext } from './App';



const TodoList = () =>{

    const {setTodoList, loginMember, todoList} = useContext(ToDoListContext)

    const [inputTodo, setInputTodo] = useState('');
    
    let keyIndex =0;

    // 할 일 추가
    const handleAddTodo = () => {

        // 입력 X
        if(inputTodo.trim().length === 0){
            alert('할 일을 입력해 주세요.');
            return;
        }

        fetch("/todo", {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify({
                title : inputTodo,
                todoMemberNo : loginMember.todoMemberNo
            })
        })
        .then(resp => resp.text())
        .then(todoNo => {
            if(Number(todoNo) === 0){ // 실패 시 멈춤
                return;
            }

            // 기존 todoList + 새로 추가된 Todo를 이용해
            // 새 배열을 만들어
            // todoList에 대입
            
            // 새로 추가된 Todo 만들기
            const newTodo = {
                todoNo : todoNo,
                title : inputTodo,
                todoMemberNo : loginMember.todoMemberNo,
                isDone : "X"
            };

            // 기존 todoList + newTodo를 이용해 새 배열 만들기
            const newTodoList = [...todoList, newTodo];

            // todoList에 대입
            setTodoList(newTodoList);
            setInputTodo('');

        })
        .catch(e => console.log(e))
    }

    // O,X 업데이트
    const handleToggleTodo=( todo , index)=>{
        // console.log(todo);
        // console.log(index);
        
        fetch("/todo",{
            method: 'PUT',
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify({
                todoNo: todo.todoNo,
	            isDone : todo.isDone ==='O'? 'X':'O'
            })

        })
        .then(resp => resp.text())
        .then(result =>{
            if(result === '0'){
                console.log("업데이트실패")
                return;
            }
            // 수정 성공 시 todolist의 값을 변경해서 리렌더링
            
            // todolist를 깊은 복사(똑같은 배열을 하나더 만듦)
            const newTodoList = [...todoList]; 
    
            // index번쨰 요소의 O,X를 반대로 변경
            newTodoList[index].isDone 
                = newTodoList[index].isDone==='O'? 'X':'O';
            
            setTodoList(newTodoList);


        })
        .catch( e => console.log(e))
    
    };

    // todoList 삭제하기
    const handleDeleteTodo =(todoNo, index)=>{
        //console.log(todoNo);
        //console.log(index);

        fetch("/todo", {
            method: "delete",
            headers: { 'Content-Type': 'application/json' },
            body: todoNo
        })
        .then(resp => resp.text())
        .then(result => {
            if (result === '0') {
                console.log("삭제 실패");
                return;
            }
        
            // todoList에서 해당 항목을 제거합니다.
            // 배열.slice(인덱스, 몇칸)
            // -> 배열의 인덱스 번째 요소 부터 
            //    몇칸을 잘라서 반환할 지 지정
            // --> 배열에서 잘라난 부분이 사라짐
            const newTodoList = [...todoList];
            newTodoList.splice(index, 1); 
            setTodoList(newTodoList); //리렌더링
        })
        .catch(e => console.log(e));
        
    };

    
    return(
        <>
            <h1>{loginMember.name}의 TodoList</h1>
            <div className="todo-container">

                <h3>할 일(Todo) 입력</h3>
                <div>
                    <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)} />
                    <button onClick={handleAddTodo}>Todo 추가</button>
                </div>

                <ul>
                    {/* 배열.map : 기존 배열을 이용해서 새로운 배열 만들기 */}
                    {todoList.map((todo, index) => (
                        <li key={keyIndex++}>
                            <div>
                                <span className={todo.isDone === 'O' ? 'todo-compleate' : ''}> {todo.title} </span>

                                <span>
                                    <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                    <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                                </span>
                            </div>
                        </li>
                    ))}
                </ul>

            </div>
        </>
    );
};
export default TodoList;
