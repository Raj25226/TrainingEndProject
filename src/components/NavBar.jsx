import { Link } from "react-router-dom";
import mjpro from "../assets/mjpro_image.jpg";
import "bootstrap/dist/css/bootstrap.min.css";
import "../../node_modules/bootstrap-icons/font/bootstrap-icons.css";
import "../../node_modules/bootstrap/dist/js/bootstrap.min.js";

export default function NavBar() {

    const hidebtn=()=>{
        let element1=document.getElementById("logout");
        element1.classList.add("d-none");
        let element2=document.getElementById("list");
        element2.classList.add("d-none");
        let element3=document.getElementById("register");
        element3.classList.remove("d-none");
    }

    return (
        <>
            <nav className="navbar navbar-expand-lg nav">
                <div className="container-fluid">
                    <h1 className="navbar-brand">
                        <Link to="/">
                            <img className="logo" src={mjpro} alt="logo"></img>
                        </Link>
                    </h1>
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                    >
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div
                        className="collapse navbar-collapse"
                        id="navbarSupportedContent"
                    >
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item" id="register">
                                <Link className="nav-link" to="/register">Vendor Registration</Link>
                            </li>
                            <li className="nav-item d-none" id="list">
                                <Link className="nav-link" to="/indentlist">Indent List</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/contact">Contact</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/about">About</Link>
                            </li>
                            <li className="nav-item d-none" id="logout" onClick={hidebtn}>
                                <Link className="nav-link" to="/">Log Out</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </>
    );

}
