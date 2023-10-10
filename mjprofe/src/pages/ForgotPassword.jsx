import React, { useState } from 'react';

function ForgotPassword() {
  const [formData, setFormData] = useState({
    email: '',
  });

  const [error, setError] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const validateEmail = (email) => {
    const regex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i;
    return regex.test(email);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!validateEmail(formData.email)) {
      setError('Invalid email format');
    } else {
      setError(null); // Clear the error
      // Send a password reset email or perform the desired action here
      console.log('Password reset email sent to: ' + formData.email);
    }
  };

  return (
    <div className="container" style={{ maxWidth: '400px' }}>
      <div className="card p-4" style={{ marginTop: '38%' }}>
        <h2 className="card-title text-center">Forgot Password</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
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
