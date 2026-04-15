import Ask from "./Ask";
import List from "./List";
import Main from "./Main";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Translate from "./Translate";


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" exact element={<Main/>} />
        <Route path="/list" element={<List/>} />
        <Route path="/ask" element={<Ask/>} />
        <Route path="/translate" element={<Translate/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
