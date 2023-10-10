import { Route, Routes } from 'react-router-dom';
import LogIn from './pages/LogIn'
import Register from './pages/Register'
import Contact from './pages/Contact'
import About from './pages/About'
import NavBar from './components/NavBar'
import Footer from './components/Footer'
import "../styles.css";
import AddIndent from './pages/AddIndent';
import ForgotPassword from './pages/ForgotPassword'
import IndentList from './pages/IndentList';

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
          <Route path='/forgotpassword' element={<ForgotPassword />}/>
          <Route path='/indentlist' element={<IndentList />}/>
        </Routes>
      </div>
      <Footer/>
    </>
  );
}

export default App;
