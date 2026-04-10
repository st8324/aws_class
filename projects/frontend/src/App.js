import logo from './logo.svg';
import './App.css';

function App() {
  async function test(msg){

    const response = await fetch(`/api/v1/test?msg=${msg}`)
    
    if(!response.ok){
      console.log('연결 실패')
      return;
    }

    const res = await response.text()
    console.log(res)

  }
  test('hi')

  async function testPost(msg){

    const response = await fetch(`/api/v1/test`,{
      method : 'post',
      headers :{
        'Content-type' : 'application/json'
      },
      body : JSON.stringify({'msg' : msg})
    })
    
    if(!response.ok){
      console.log('연결 실패')
      return;
    }

    const res = await response.text()
    console.log(res)

  }
  testPost('hi')
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          챗봇으로
        </a>
      </header>
    </div>
  );
}

export default App;
