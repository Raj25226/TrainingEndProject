import { Route, Routes } from 'react-router-dom';
import LogIn from './pages/LogIn'
import Register from './pages/Register'
import Contact from './pages/Contact'
import About from './pages/About'
import NavBar from './components/NavBar'
import Footer from './components/Footer'
import "../styles.css";
import AddIndent from './pages/AddIndent';


function App() {
  return (
    <>
      <NavBar />
      <div className='mycontainer'>
        <Routes>
          <Route path='/' element={<LogIn/>}/>
          <Route path='/register' element={<Register/>}/>
          <Route path='/contact' element={<Contact/>}/>
          <Route path='/about' element={<About/>}/>
          <Route path='/add' element={<AddIndent/>}/>
        </Routes>
      </div>
      <Footer/>
    </>
  );
}

export default App;
