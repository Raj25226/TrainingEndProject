import React, { useState, useEffect } from "react";

const ViewIndents = () => {
  // Assume you have an array of indents
  const [indents, setIndents] = useState([]);

  // Fetch indents from your data source
  useEffect(() => {
    // Replace with your actual API call or data fetching logic
    // For example, you might use a library like axios to make an API call
    // const response = await axios.get("/api/indents");
    // const fetchedIndents = response.data;
    // For demonstration purposes, setting some dummy data
    const fetchedIndents = [
      {
        id: 1,
        unitPrice: 10.0,
        totalPrice: 50.0,
        quantity: 5,
        selectedProduct: "Product2",
        selectedCategory: "Category1",
        unitMeasurement: "kg",
        selectedManufacturer: "Manufacturer2",
      },
      // Add more indents as needed
    ];

    setIndents(fetchedIndents);
  }, []);

  return (
    <div className="container col-md-5" style={{marginTop:'10%'}}>
      {indents.map((indent) => (
        <div
          key={indent.id}
          className="card mb-3"
          style={{ background: "#176B87", color: "#EEEEEE" }}
        >
          <div className="card-body">
            <h5 className="card-title">Indent ID: {indent.id}</h5>
            <p>Category: {indent.selectedCategory}</p>
            <p>Product: {indent.selectedProduct}</p>
            <p>Manufacturer: {indent.selectedManufacturer}</p>
            <p>Quantity: {indent.quantity}</p>
            <p>Unit Measurement: {indent.unitMeasurement}</p>
            <p>Unit Price: {indent.unitPrice}</p>
            <p>Total Price: {indent.totalPrice}</p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ViewIndents;
