import Detail from "./pages/Detail";
import Home from "./pages/Home";
import List from "./pages/List";
import Update from "./pages/Update";
import Write from "./pages/Write";
import Header from "./component/Header";
import { Routes, Route} from 'react-router-dom';
function App() {
  return (
    <div className="App">
      <Header/>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/articles" element={<List/>}/>
          <Route path="/writeForm" element={<Write/>}/>
          <Route path="/articles/:id" element={<Detail/>}/>
          <Route path="/articles/updateForm/:id" element={<Update/>}/>
      </Routes>
    </div>
  );
}

export default App;
