import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    vendorName: '',
    phoneNumber: '',
    gst: '',
    email: '',
    pan: '',
    turnover: '',
    password: '',
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const validateEmail = (email) => {
    const regex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i;
    return regex.test(email);
  };

  const validateGST = (gst) => {
    const regex = /^\d{2}[A-Z]{5}\d{4}[A-Z]{1}\d[Z]{1}[A-Z\d]{1}$/;
    return regex.test(gst);
  };

  const validatePhoneNumber = (phoneNumber) => {
    // Basic phone number validation (10 digits)
    const regex = /^\d{10}$/;
    return regex.test(phoneNumber);
  };

  const validatePAN = (pan) => {
    const regex = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/;
    return regex.test(pan);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const newErrors = {};
    let formIsValid = true;

    if (!formData.vendorName) {
      newErrors.vendorName = 'Vendor Name is required';
      formIsValid = false;
    }

    if (!formData.phoneNumber) {
      newErrors.phoneNumber = 'Phone Number is required';
      formIsValid = false;
    } else if (!validatePhoneNumber(formData.phoneNumber)) {
      newErrors.phoneNumber = 'Invalid Phone Number';
      formIsValid = false;
    }

    if (!formData.gst) {
      newErrors.gst = 'GST is required';
      formIsValid = false;
    } else if (!validateGST(formData.gst)) {
      newErrors.gst = 'Invalid GST format';
      formIsValid = false;
    }

    if (!formData.email) {
      newErrors.email = 'Email is required';
      formIsValid = false;
    } else if (!validateEmail(formData.email)) {
      newErrors.email = 'Invalid email format';
      formIsValid = false;
    }

    if (!formData.pan) {
      newErrors.pan = 'PAN is required';
      formIsValid = false;
    } else if (!validatePAN(formData.pan)) {
      newErrors.pan = 'Invalid PAN format';
      formIsValid = false;
    }

    if (!formData.turnover) {
      newErrors.turnover = 'Turnover is required';
      formIsValid = false;
    }

    if (!formData.password) {
      newErrors.password = 'Password is required';
      formIsValid = false;
    }

    setErrors(newErrors);

    if (formIsValid) {
      // Handle form submission logic here
      console.log(formData);
    }
  };

  return (
    <div className="container" style={{ maxWidth: '43%' }}>
      <div className="card p-4 mb-5">
        <h2 className="card-title text-center">Registration</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="vendorName" className="form-label">
              Vendor Name <span className="text-danger">*</span>
            </label>
            <input
              type="text"
              className={`form-control form-control-sm ${errors.vendorName ? 'is-invalid' : ''}`}
              id="vendorName"
              name="vendorName"
              value={formData.vendorName}
              onChange={handleChange}
              required
            />
            {errors.vendorName && (
              <div className="invalid-feedback">{errors.vendorName}</div>
            )}
          </div>
          <div className="mb-3">
            <label htmlFor="phoneNumber" className="form-label">
              Phone Number <span className="text-danger">*</span>
            </label>
            <input
              type="text"
              className={`form-control form-control-sm ${errors.phoneNumber ? 'is-invalid' : ''}`}
              id="phoneNumber"
              name="phoneNumber"
              value={formData.phoneNumber}
              onChange={handleChange}
              required
            />
            {errors.phoneNumber && (
              <div className="invalid-feedback">{errors.phoneNumber}</div>
            )}
          </div>
          <div className="mb-3">
            <label htmlFor="gst" className="form-label">
              GST <span className="text-danger">*</span>
            </label>
            <input
              type="text"
              className={`form-control form-control-sm ${errors.gst ? 'is-invalid' : ''}`}
              id="gst"
              name="gst"
              value={formData.gst}
              onChange={handleChange}
              required
            />
            {errors.gst && (
              <div className="invalid-feedback">{errors.gst}</div>
            )}
          </div>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">
              Email <span className="text-danger">*</span>
            </label>
            <input
              type="email"
              className={`form-control form-control-sm ${errors.email ? 'is-invalid' : ''}`}
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
            />
            {errors.email && (
              <div className="invalid-feedback">{errors.email}</div>
            )}
          </div>
          <div className="mb-3">
            <label htmlFor="pan" className="form-label">
              PAN <span className="text-danger">*</span>
            </label>
            <input
              type="text"
              className={`form-control form-control-sm ${errors.pan ? 'is-invalid' : ''}`}
              id="pan"
              name="pan"
              value={formData.pan}
              onChange={handleChange}
              required
            />
            {errors.pan && (
              <div className="invalid-feedback">{errors.pan}</div>
            )}
          </div>
          <div className="mb-3">
            <label htmlFor="turnover" className="form-label">
              Turnover <span className="text-danger">*</span>
            </label>
            <input
              type="text"
              className={`form-control form-control-sm ${errors.turnover ? 'is-invalid' : ''}`}
              id="turnover"
              name="turnover"
              value={formData.turnover}
              onChange={handleChange}
              required
            />
            {errors.turnover && (
              <div className="invalid-feedback">{errors.turnover}</div>
            )}
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label">
              Password <span className="text-danger">*</span>
            </label>
            <input
              type="password"
              className={`form-control form-control-sm ${errors.password ? 'is-invalid' : ''}`}
              id="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              required
            />
            {errors.password && (
              <div className="invalid-feedback">{errors.password}</div>
            )}
          </div>
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}

export default Register;
