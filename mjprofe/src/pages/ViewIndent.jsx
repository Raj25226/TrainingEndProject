import React, { useState, useEffect } from "react";
import axios from "axios";

const ViewIndents = ({ category }) => {
  const [indents, setIndents] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        // Construct the API endpoint URL using the props
        const apiEndpoint = `/api/indents?category${category}`;

        // Make the API call with the constructed URL
        const response = await axios.get(apiEndpoint);
        const fetchedIndents = response.data;
        setIndents(fetchedIndents);
      } catch (error) {
        console.error("Error fetching indents:", error);
      }
    };

    fetchData();
  }, [category, product]);

  return (
    <div className="container col-md-5" style={{ marginTop: '10%' }}>
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
