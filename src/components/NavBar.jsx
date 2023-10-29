import { Link } from "react-router-dom";
import mjpro from "../assets/mjpro_image.jpg";
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { deleteUser, userLoggedin } from "../slices/loginSlice";
import { authorization, logout } from "../slices/authSlice";

export default function NavBar2() {
  const state = useSelector(authorization);
  const dispatch = useDispatch();

  let AboutContact = (
    <>
      <li class="nav-item">
        <Link
          to="/contact"
          className="nav-link active text-light"
          aria-current="page"
        >
          Contact
        </Link>
      </li>
      <li>
        <Link
          to="/about"
          className="nav-link active text-light"
          aria-current="page"
        >
          About
        </Link>
      </li>
    </>
  );

  let content = (
    <nav className="navbar navbar-expand-lg bg-body-tertiary sticky-top p-0">
      <div
        className="container-fluid p-2"
        style={{ backgroundColor: "#053B50" }}
      >
        <div>
          <a className="navbar-brand ms-4" href="#">
            <img
              src={mjpro}
              alt="mjprolite"
              width="50"
              height="50"
              style={{ borderRadius: "50%" }}
            />
          </a>
        </div>
        <div>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="offcanvas"
            data-bs-target="#offcanvasNavbar"
            aria-controls="offcanvasNavbar"
            aria-label="Toggle navigation"
            style={{ backgroundColor: "white" }}
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div
            class="offcanvas offcanvas-top p-3"
            tabIndex="-1"
            id="offcanvasNavbar"
            aria-labelledby="offcanvasNavbarLabel"
            style={{ backgroundColor: "#053B50", height: "fit-content" }}
          >
            <div class="offcanvas-header">
              <div>
                <img
                  src={mjpro}
                  alt="mjprolite"
                  width="50"
                  height="50"
                  style={{ borderRadius: "50%" }}
                />
              </div>
              <button
                type="button"
                class="btn-close btn-close-white"
                data-bs-dismiss="offcanvas"
                aria-label="Close"
              ></button>
            </div>
            <div class="offcanvas-body">
              <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                <li class="nav-item">
                  <Link
                    to="/tenders"
                    className="nav-link active text-light"
                    aria-current="page"
                  >
                    Tenders
                  </Link>
                </li>
                {state.user === "none" ? (
                  <>
                  {AboutContact}
                    <li>
                      <Link
                        to="/login"
                        className="nav-link active text-light"
                        aria-current="page"
                      >
                        Login
                      </Link>
                    </li>
                  </>
                ) : state.user === "indenter" ? (
                  <>
                    <li class="nav-item">
                      <Link
                        to="/suppliers"
                        className="nav-link active text-light"
                        aria-current="page"
                      >
                        Suppliers
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link
                        to="/indentlist"
                        className="nav-link active text-light"
                        aria-current="page"
                      >
                        Indent List
                      </Link>
                    </li>
                    {AboutContact}
                    <li className="nav-item">
                      <button
                        className="nav-link active text-light btn btn-danger"
                        onClick={() => dispatch(logout())}
                      >
                        Logout
                      </button>
                    </li>
                  </>
                ) : (
                  <>
                    {AboutContact}
                    <li className="nav-item">
                      <Link
                        to="/login"
                        className="nav-link active text-light"
                        aria-current="page"
                      >
                        Login
                      </Link>
                    </li>
                  </>
                )}
              </ul>
            </div>
          </div>
        </div>
      </div>
    </nav>
  );
  return (
    // <nav className="navbar navbar-expand-lg bg-body-tertiary">
    //   <div className="container-fluid">
    //     <a className="navbar-brand ms-4" href="#">
    //       <img
    //         src={mjpro}
    //         alt="mjprolite"
    //         width="50"
    //         height="50"
    //         style={{ borderRadius: "50%" }}
    //       />
    //     </a>
    //     <button
    //       class="navbar-toggler"
    //       type="button"
    //       data-bs-toggle="offcanvas"
    //       data-bs-target="#offcanvasNavbar"
    //       aria-controls="offcanvasNavbar"
    //       aria-label="Toggle navigation"
    //       style={{ backgroundColor: "white" }}
    //     >
    //       <span class="navbar-toggler-icon"></span>
    //     </button>
    //     <div></div>
    //   </div>
    // </nav>
    content
  );
}
