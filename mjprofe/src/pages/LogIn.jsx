import React, { useState } from "react";
import "../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from 'react-router-dom';

const LogIn = () => {
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");

    const navigate=useNavigate();

    const handleLogin = async () => {
        try {
            const response = await fetch('//localhost:8080/mj/user/login', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify({ userName, password }),
            });
      
            if (response.ok) {
              const result = await response.json();
              console.log('Login successful:', result);
              if(result.role.roleId===1){
                navigate('/indentlist');
              }else if(result.role.roleId===3){
                navigate('/vendor');
              }
            } else {
              console.error('Login failed');
              navigate('/');
            }
          } catch (error) {
            console.error('Error during login:', error);
          }
        console.log("Username:", userName);
        console.log("Password:", password);

        setUserName("");
        setPassword("");
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <div className="card mt-5">
                        <div className="card-body">
                            <h2 className="card-title mb-4" style={{textAlign:"center"}}>Log In</h2>
                            <form>
                                <div className="mb-3">
                                    <label
                                        htmlFor="username"
                                        className="form-label"
                                    >
                                        Username:
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="username"
                                        value={userName}
                                        onChange={(e) =>
                                            setUserName(e.target.value)
                                        }
                                    />
                                </div>
                                <div className="mb-3">
                                    <label
                                        htmlFor="password"
                                        className="form-label"
                                    >
                                        Password:
                                    </label>
                                    <input
                                        type="password"
                                        className="form-control"
                                        id="password"
                                        value={password}
                                        onChange={(e) =>
                                            setPassword(e.target.value)
                                        }
                                    />
                                </div>
                                <button
                                    type="button"
                                    className="btn btn-primary"
                                    onClick={handleLogin}
                                >
                                    Login
                                </button>
                                <div className="mt-3">
                                <a href="/forgotpassword">
                                        Forgot Password?
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default LogIn;
