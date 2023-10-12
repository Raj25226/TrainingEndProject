import React, { useState, useEffect } from "react";
import axios from "axios";

const ViewIndents = (props) => {
  const [indents, setIndents] = useState({});
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const apiEndpoint = `http://localhost:8080/mj/indent1/${props.headerId}`;
        const response = await axios.get(apiEndpoint);
        const fetchedIndents = response.data;
        setIndents(fetchedIndents);
        setIsLoading(false);
      } catch (error) {
        console.error("Error fetching indents:", error);
      }
    };

    fetchData();
  }, [props.headerId]);

  return (
    <div className="container col-md-5" style={{ marginTop: '10%' }}>
      {isLoading ? (
        <p>Loading...</p>
      ) : (
        <div className="card mb-3" style={{ background: "#176B87", color: "#EEEEEE" }}>
          <div className="card-body">
            <h5 className="card-title">Indent:</h5>
            {indents.indentId && <p>IndentId: {indents.indentId}</p>}
            {indents.indentCode && <p>IndentCode: {indents.indentCode}</p>}
            {indents.unitPrice && <p>UnitPrice: {indents.unitPrice}</p>}
            {indents.totalPrice && <p>Totalprice: {indents.totalPrice}</p>}
            {indents.quantity && <p>Quantity: {indents.quantity}</p>}
            {/* {indents.indentcategory && <p>Category: {indents.indentcategory}</p>} */}
            {/* Check for the existence of 'indentcategory' */}
          </div>
        </div>
      )}
    </div>
  );
};

export default ViewIndents;
