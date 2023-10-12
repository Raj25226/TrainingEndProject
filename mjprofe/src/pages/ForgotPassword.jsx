import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function ForgotPassword() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const [error, setError] = useState(null);
  const [showErrorMessage, setShowErrorMessage] = useState(false); // State to control the error message visibility

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const validateEmail = (email) => {
    const regex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i;
    return regex.test(email);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const { email, password } = formData; // Get email and new password from formData

    try {
      const userResponse = await axios.get(`http://localhost:8080/mj/user/byEmail/${email}`);


      if (userResponse.status !== 200) {
        console.error('User not found');
        setShowErrorMessage(true); // Show the error message
        return;
      }

      const user = userResponse.data;
      console.log(user);
      
      const userData = {
        userId: user.userId,
        userName: email, 
        password: password,
        role: {
          roleId: 1,
          isActive: 1,
          createdBy: "Vishwa",
          createdAt: new Date(), // Use new Date() to get the current date
          modifiedBy: "Vishwa",
          modifiedAt: new Date(),
         }
      };
      userData.isActive = 1;
      userData.createdBy = "Vishwa";
      userData.createdAt = new Date(); // Use new Date() to get the current date
      userData.modifiedBy = "Vishwa";
      userData.modifiedAt = new Date();
        

        const response = await axios.put('http://localhost:8080/mj/user', userData, {
        headers: { 'Content-Type': 'application/json' },
      });


      // });

      if (response.status === 200) {
        const result = response.data;
        console.log('Password reset successful:', result);

        // Redirect to the login page or another appropriate route
        navigate('/');
      } else {
        console.error('Password reset failed');
      }
    } catch (error) {
      console.error('Error during password reset:', error);
    }
  };

  return (
    <div className="container" style={{ maxWidth: '400px' }}>
      <div className="card p-4" style={{ marginTop: '38%' }}>
        <h2 className="card-title text-center">Forgot Password</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            {showErrorMessage && (
              <p className="text-danger">User not found. Please check your email.</p>
            )}
            <label htmlFor="email" className="form-label">
              Email <span className="text-danger">*</span>
            </label>
            <input
              type="email"
              className={`form-control form-control-sm ${error ? 'is-invalid' : ''}`}
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
            />

            <label htmlFor="password" className="form-label">
              New Password <span className="text-danger">*</span>
            </label>
            <input
              type="password"
              className={`form-control form-control-sm ${error ? 'is-invalid' : ''}`}
              id="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              required
            />

            

            {error && (
              <div className="invalid-feedback">{error}</div>
            )}
          </div>
          <button type="submit" className="btn btn-primary">
            Reset Password
          </button>
        </form>
      </div>
    </div>
  );
}

export default ForgotPassword;
