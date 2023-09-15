import React, { useState, useContext } from 'react';
import { ToDoListContext } from './App';



const LoginComponent =() =>{

    //전역 변수 Context를 사용
    const { setTodoList, setLoginMember, loginMember  } = useContext(ToDoListContext);

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');


    const login =() =>{

        fetch('/login', {
            method: 'POST',
            headers : {
                //전달되는 데이터 타입
                'Content-Type': 'application/json',

                //응답데이터 타입
                'Accept': 'application/json'
            },  
            body : JSON.stringify({
                id : id,
                pw : pw
            })  
        })
        .then(resp => resp.json())
        .then(map => {
            console.log(map);

            // 로그인이 실패 했을 떄
            if(map.loginMember === null){
                alert('아이디 또는 비밀번호가 일치하지 않습니다.')
                return;
            }
            
            setId('')
            setPw('')
            //로그인 성공시 
            setLoginMember(map.loginMember);
            setTodoList(map.todoList)

        })
        .catch( e => console.log(e))


    }
    const logout =() =>{
        setLoginMember(null);
    }


    return (
        <div className="login-container">
            <table>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td>
                            <input type="text" onChange={e => setId(e.target.value)} value={id} />
                        </td>
                    </tr>

                    <tr>
                        <th>PW</th>
                        <td>
                            <input type="password" onChange={e => setPw(e.target.value)} value={pw} />
                        </td>
                        <td>
                            <button onClick={login} >Login</button>
                        </td>
                    </tr>
                </tbody>
            </table>

            {loginMember && (
                <button onClick={logout}>로그아웃</button>
            )}
        </div>        
    );

}
export default LoginComponent;
