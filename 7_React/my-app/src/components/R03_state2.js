import React, {useState} from 'react'

const State2= (props) =>{

    //props : 부모로부터 값을 전달 받은 객체
    // props.init
    //const [conut , setConut] = useState(0);
    const [conut , setConut] = useState(props.init);
    

    // useState :컴포넌트의 상태를 관리할 때 사용하는 Hook
    // const [변수, 값을 변경하는 함수 (setter)] = useState(초기값);
    
    return(

        <div>
            <h3>{conut}</h3>
            <button onClick={()=>setConut(conut +1)}>클릭하면 1증가</button>
        </div>
    );

}

export default State2;