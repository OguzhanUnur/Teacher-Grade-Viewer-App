import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Routes bileşenini içe aktarın
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListStudentComponent from './components/ListStudentComponent';
import AddStudentComponent from './components/AddStudentComponent';
import StudentDetailComponent from './components/StudentDetailComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className='container'>
          <Routes> 
            <Route exact path='/' element={<ListStudentComponent />} />
            <Route path='/students' element={<ListStudentComponent />} />
            <Route path='/add-student' element={<AddStudentComponent />} />
            <Route path='/edit-student/:id' element={<AddStudentComponent />} />
            <Route path='/student-detail/:id' element={<StudentDetailComponent />} />

          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
