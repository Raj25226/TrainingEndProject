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
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card mt-5">
            <div className="card-body">
              <h2 className="card-title mb-4" style={{ textAlign: 'center' }}>
                Add Indent
              </h2>
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label className="form-label">Unit Price:</label>
                  <input
                    type="number"
                    className="form-control"
                    value={unitPrice}
                    onChange={(e) => setUnitPrice(parseFloat(e.target.value))}
                  />
                </div>
                <div className="mb-3">
                  <label className="form-label">Total Price:</label>
                  <input
                    type="number"
                    className="form-control"
                    value={totalPrice}
                    onChange={(e) => setTotalPrice(parseFloat(e.target.value))}
                  />
                </div>
                <div className="mb-3">
                  <label className="form-label">Quantity:</label>
                  <input
                    type="number"
                    className="form-control"
                    value={quantity}
                    onChange={(e) => setQuantity(parseInt(e.target.value, 10))}
                  />
                </div>
                <div className="mb-3">
                  <label className="form-label">Product:</label>
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
                </div>
                <div className="mb-3">
                  <label className="form-label">Category:</label>
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
                </div>
                <button type="submit" className="btn btn-primary">
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>

        <div className="mt-4"> 
        <p></p>
        <p></p>
      </div>
      
      </div>
    </div>
  );
};

export default AddIndent;
