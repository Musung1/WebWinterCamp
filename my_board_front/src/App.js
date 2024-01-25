import Detail from "./pages/Detail";
import Home from "./pages/Home";
import List from "./pages/List";
import Update from "./pages/Update";
import Write from "./pages/Write";
import Header from "./component/Header";
import FileUpload from "./pages/Test/FileUpload";
import Longin from "./pages/Test/Login";
import Signup from "./pages/Test/Signup";
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
          <Route path="/articles/update/:id" element={<Update/>}/>
          <Route path="/upload" element={<FileUpload/>}/>
          <Route path="/login" element={<Longin/>}/>
          <Route path="/signup" element={<Signup/>}/>
          
      </Routes>
    </div>
  );
}

export default App;
