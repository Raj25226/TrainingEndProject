import "../styles.css";
import React from "react";
import { ListOfRfp, Suppliers, SplitScreen, Tenders } from "./pages/vanguards";
import About from "./pages/About";
import Contact from "./pages/Contact";
import Login from "./pages/Login";
import { Route, Routes } from "react-router-dom";
import NavBar2 from "./components/NavBar";
import Footer from "./components/Footer";

import {
  LogIn,
  Register,
  AddIndent,
  AddIndent2,
  AddProduct,
  ForgotPassword,
  IndentList,
  EditIndent,
  VendorPage,
  ViewIndents,
  MultipleIndent,
} from "./pages/innovators";

export default function App() {
  return (
    <>
      <NavBar2 />
      <Routes>
        <Route path="/" element={<ListOfRfp />} />
        {/* <Route element={<RouteProtect />}> */}
        <Route path="/suppliers" element={<Suppliers />} />
        <Route path="/suppliers/:id" element={<Suppliers />} />
        {/* </Route> */}
        <Route path="/splitscreen" element={<SplitScreen />} />
        <Route path="/tenders" element={<Tenders />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/about" element={<About />} />
        {/* <Route path="/login" element={<Login />} /> */}

        <Route path="/login" element={<LogIn />} />
        <Route path="/register" element={<Register />} />
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
      <Footer />
    </>
  );
}
