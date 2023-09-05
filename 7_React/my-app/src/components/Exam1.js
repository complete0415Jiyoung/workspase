import React, { Component } from 'react';
// node-moduls 폴더에 있는 react 패키지를 가져옴 


//클래스형 컴포넌트 만들기 
// 1. Component 상속 받기
// 2. render() 함수 작성하기(필수)
// 3. 만든 class를 export default 지정하기 -> 다른 곳에서 import 받을 수 있음
class Exam1 extends Component{

    constructor(props){
        super(props);
        this.state = { count : 0 };
    }

    handleClick = () => {
        this.setState({ count : this.state.count + 1 });
    }

    // 화면 렌더링 시 
    // render() 함수에서 반환된 값이 화면에 출력됨
    render(){
        return(
            <>
                <h2>클래스형 컴포넌트</h2>
                <h1>Count : {this.state.count}</h1>
                <button onClick = {this.handleClick}>Increment</button>
            </>
        );
    }

    /*
    document.getElementById(버튼).addEventListener("click", (=>{

        const count = document.getElementById(카운트);
        count.innerText = Number(count,innerText)+1;
    })) 
    ->> React는 미리 사용할 함수를 변수로 지정해 두고 화면을 만들어 준다 이전 스타일과 다름!
    */

}

export default Exam1;