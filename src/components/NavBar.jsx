import { Link } from "react-router-dom";
import mjpro from "../assets/mjpro_image.jpg";
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { deleteUser, userLoggedin } from "../slices/loginSlice";

export default function NavBar2() {
  const user = useSelector(userLoggedin);
  const dispatch = useDispatch();
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary p-0">
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
            class="offcanvas offcanvas-end w-50 p-3"
            tabIndex="-1"
            id="offcanvasNavbar"
            aria-labelledby="offcanvasNavbarLabel"
            style={{ backgroundColor: "#053B50" }}
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
                    to="/suppliers"
                    className="nav-link active text-light"
                    aria-current="page"
                  >
                    Suppliers
                  </Link>
                </li>
                <li class="nav-item">
                  <Link
                    to="/tenders"
                    className="nav-link active text-light"
                    aria-current="page"
                  >
                    Tenders
                  </Link>
                </li>
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
                {user.user === "none" ? (
                  <>
                    <li>
                      <Link
                        to="/login"
                        className="nav-link active text-light"
                        aria-current="page"
                      >
                        Login
                      </Link>
                    </li>
                    <li>
                      <Link
                        to="/register"
                        className="nav-link active text-light"
                        aria-current="page"
                      >
                        Register
                      </Link>
                    </li>
                  </>
                ) : (
                  <li>
                   <button className="nav-link active text-light btn btn-danger"onClick={() => dispatch(deleteUser("none"))}>Logout</button>
                  </li>
                )}
                {/* <li>
                  <Link
                    to="/login"
                    className="nav-link active text-light"
                    aria-current="page"
                  >
                    Login
                  </Link>
                </li>
                <li>
                  <Link
                    to="/register"
                    className="nav-link active text-light"
                    aria-current="page"
                  >
                    Register
                  </Link>
                </li> */}
              </ul>
            </div>
          </div>
        </div>
      </div>
    </nav>
  );
}
