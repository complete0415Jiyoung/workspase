import './App.css';

// components 폴더의Exam1.js 를 가져와서 사용
// 사용 할때 이름을 Ex1으로 지정
import Ex1 from './components/Exam1';
import Ex2 from './components/Exam2';

function App() {
  // 리엑트의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다
  // -> 여러 요소를 반환하고 싶을 때는 부모 요소로 묶어 준다! 
  return (
    /*fragment(<></>) : 반환요소를 감쌀 때 사용, 해석 X*/
    <>
      {/* jsx 주석 */}
      <h1>Hello React!!</h1>
  
      <div>리엑트 배운다~~</div>

      <Ex1/>

      <Ex2/>
    </>
  );
}

export default App;
