import React, { useState, useEffect } from "react";

const EditIndent = () => {
  // Assume you have an indent ID as a parameter (you may receive it through props)
  const [indentId, setIndentId] = useState(null);

  const [unitPrice, setUnitPrice] = useState(null);
  const [totalPrice, setTotalPrice] = useState(null);
  const [quantity, setQuantity] = useState(null);
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [unitMeasurement, setUnitMeasurement] = useState(null);
  const [selectedManufacturer, setSelectedManufacturer] = useState(null);

  // Fetch products and categories from your data source
  const products = ["Product1", "Product2", "Product3"]; // Replace with your actual product data
  const categories = ["Category1", "Category2", "Category3"]; // Replace with your actual category data
  const unitMeasurements = ["kg", "lbs", "pieces"]; // Replace with your actual unit measurement data
  const manufacturers = ["Manufacturer1", "Manufacturer2", "Manufacturer3"]; // Replace with your actual manufacturer data

  // Fetch the existing indent data based on the indentId
  useEffect(() => {
    // Assume fetchIndentData is a function to fetch indent data based on indentId
    const fetchIndentData = async () => {
      // Replace with your actual API call or data fetching logic
      // For example, you might use a library like axios to make an API call
      // const response = await axios.get(`/api/indents/${indentId}`);
      // const indentData = response.data;

      // For demonstration purposes, setting some dummy data
      const indentData = {
        unitPrice: 10.0,
        totalPrice: 50.0,
        quantity: 5,
        selectedProduct: "Product2",
        selectedCategory: "Category1",
        unitMeasurement: "kg",
        selectedManufacturer: "Manufacturer2",
      };

      // Update state with the fetched data
      setUnitPrice(indentData.unitPrice);
      setTotalPrice(indentData.totalPrice);
      setQuantity(indentData.quantity);
      setSelectedProduct(indentData.selectedProduct);
      setSelectedCategory(indentData.selectedCategory);
      setUnitMeasurement(indentData.unitMeasurement);
      setSelectedManufacturer(indentData.selectedManufacturer);
    };

    // Call the fetchIndentData function
    fetchIndentData();
  }, [indentId]);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Add your form submission logic here
    console.log("Form submitted:", {
      indentId,
      unitPrice,
      totalPrice,
      quantity,
      unitMeasurement,
      selectedProduct,
      selectedCategory,
      selectedManufacturer,
    });
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card mt-5">
            <div className="card-body">
              <h2 className="card-title mb-4" style={{ textAlign: "center" }}>
                Edit Indent
              </h2>
              <form onSubmit={handleSubmit}>
                {/* Add a field to display indentId */}
                <div className="mb-3">
                  <label className="form-label">Indent ID:</label>
                  <input
                    type="text"
                    className="form-control"
                    value={indentId || ""}
                    disabled
                  />
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
                  <label className="form-label">Manufacturer:</label>
                  <select
                    className="form-select"
                    value={selectedManufacturer}
                    onChange={(e) => setSelectedManufacturer(e.target.value)}
                  >
                    <option value="">Select a manufacturer</option>
                    {manufacturers.map((manufacturer) => (
                      <option key={manufacturer} value={manufacturer}>
                        {manufacturer}
                      </option>
                    ))}
                  </select>
                </div>
                <div className="row mb-3">
                  <div className="col">
                    <label className="form-label">Quantity:</label>
                    <input
                      type="number"
                      className="form-control"
                      value={quantity}
                      onChange={(e) => setQuantity(parseInt(e.target.value, 10))}
                    />
                  </div>
                  <div className="col">
                    <label className="form-label">Unit Measurement:</label>
                    <select
                      className="form-select"
                      value={unitMeasurement}
                      onChange={(e) => setUnitMeasurement(e.target.value)}
                    >
                      <option value="">Select unit</option>
                      {unitMeasurements.map((unit) => (
                        <option key={unit} value={unit}>
                          {unit}
                        </option>
                      ))}
                    </select>
                  </div>
                </div>
                <div className="mb-3">
                  <label className="form-label">Price:</label>
                  <input
                    type="number"
                    className="form-control"
                    value={totalPrice}
                    onChange={(e) => setTotalPrice(parseFloat(e.target.value))}
                  />
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

export default EditIndent;
