import React, { useState } from 'react';

const AddIndent = () => {
  const [unitPrice, setUnitPrice] = useState(null);
  const [totalPrice, setTotalPrice] = useState(null);
  const [quantity, setQuantity] = useState(null);
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [selectedCategory, setSelectedCategory] = useState(null);

  // Fetch products and categories from your data source
  const products = ['Product1', 'Product2', 'Product3']; // Replace with your actual product data
  const categories = ['Category1', 'Category2', 'Category3']; // Replace with your actual category data

  const handleSubmit = (e) => {
    e.preventDefault();
    // Add your form submission logic here
    console.log('Form submitted:', {
      unitPrice,
      totalPrice,
      quantity,
      selectedProduct,
      selectedCategory,
    });
  };

  return (
    <form onSubmit={handleSubmit} className="container mt-5">
      <div className="row">
        <div className="col-md-6">
          <label className="form-label">
            Unit Price:
            <input
              type="number"
              className="form-control"
              value={unitPrice}
              onChange={(e) => setUnitPrice(parseFloat(e.target.value))}
            />
          </label>
        </div>

        <div className="col-md-6">
          <label className="form-label">
            Total Price:
            <input
              type="number"
              className="form-control"
              value={totalPrice}
              onChange={(e) => setTotalPrice(parseFloat(e.target.value))}
            />
          </label>
        </div>
      </div>

      <div className="row mt-3">
        <div className="col-md-6">
          <label className="form-label">
            Quantity:
            <input
              type="number"
              className="form-control"
              value={quantity}
              onChange={(e) => setQuantity(parseInt(e.target.value, 10))}
            />
          </label>
        </div>

        <div className="col-md-6">
          <label className="form-label">
            Product:
            <select
              className="form-select"
              value={selectedProduct}
              onChange={(e) => setSelectedProduct(e.target.value)}
            >
              <option value="">Select a product</option>
              {products.map((product) => (
                <option key={product} value={product}>
                  {product}
                </option>
              ))}
            </select>
          </label>
        </div>
      </div>

      <div className="row mt-3">
        <div className="col-md-6">
          <label className="form-label">
            Category:
            <select
              className="form-select"
              value={selectedCategory}
              onChange={(e) => setSelectedCategory(e.target.value)}
            >
              <option value="">Select a category</option>
              {categories.map((category) => (
                <option key={category} value={category}>
                  {category}
                </option>
              ))}
            </select>
          </label>
        </div>
      </div>

      <div className="row mt-3">
        <div className="col-md-12">
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </div>
      </div>
    </form>
  );
};

export default AddIndent;
