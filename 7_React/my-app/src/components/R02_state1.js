import React, {useState} from 'react';

//컴포넌트 이름은 대문자로 작성!

// 리액트는 컴포넌트의 상태가 변할 때 마다 리렌더링을 수행 함
const InputTest = () => {
    
    const [inputValue, setInputValue] = useState("초기값")
    //        변수           함수

    // InputValue는 값을 저장하는 변수
    // setInputValue는 InputValue에 값을 대입하는 setter의 역할

    const changeInputValue = (e) => {
        console.log(e.target.value);
        setInputValue(e.target.value);
    }

    return(
    
        // 첫 렌더링 : vlaue = "초기값"
        // -> input 의 값을 변경 (컴포넌트의 상태 변화 -> 리렌더링 진행)
        //      1) onChage(값이 변했을 때)
        //          + onChangeInputValue 함수가 실행되면서
        //          inputValue에 e.target.value(변화된 값 대입)

        //      2) 컴포넌트의 상태 변화 -> 리렌더링 진행

        // 리렌더링 -> value = 변경된 inputValue의 값


        <input type='text' value={inputValue}
        onChange={changeInputValue}
        // onChange={(e)=>{setInputValue(e.target.value)}}
        />
    );
}
export default InputTest;