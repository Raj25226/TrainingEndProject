import { Route, Routes } from "react-router-dom";
import LogIn from "./pages/LogIn";
import Register from "./pages/Register";
import Contact from "./pages/Contact";
import About from "./pages/About";
import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import "../styles.css";
import AddIndent from "./pages/AddIndent";
import ForgotPassword from "./pages/ForgotPassword";
import IndentList from "./pages/IndentList";
import EditIndent from "./pages/EditIndent";
import ViewIndents from "./pages/ViewIndent";
import AddIndent2 from "./pages/AddIndent2";
import AddProduct from "./pages/AddIndentProduct";
import MultipleIndent from "./pages/MultipleIndent";
import VendorPage from "./pages/VendorPage";

function App() {
  return (
    <>
      <NavBar />
      <div className="mycontainer">
        <Routes>
          <Route path="/" element={<LogIn />} />
          <Route path="/register" element={<Register />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/addindent" element={<AddIndent />} />
          <Route path="/forgotpassword" element={<ForgotPassword />} />
          <Route path="/indentlist" element={<IndentList />} />
          <Route path="/editindent" element={<EditIndent />} />
          <Route path="/viewindent" element={<ViewIndents />} />
          <Route path="/addindent2" element={<AddIndent2 />} />
          <Route path="/addproduct" element={<AddProduct />} />
          <Route path="/multipleindent" element={<MultipleIndent />} />
          <Route path="/vendor" element={<VendorPage />} />
        </Routes>
      </div>
      <Footer />
    </>
  );
}

export default App;
