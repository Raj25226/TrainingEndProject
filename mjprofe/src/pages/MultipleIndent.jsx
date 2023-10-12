import React, { useState } from "react";
import AddProduct from "./AddIndentProduct";

const MultipleIndent = () => {
    const [addedProducts, setAddedProducts] = useState([]);

    const handleButtonClick = () => {
        // Create a new array by copying the existing array and adding a new AddProduct component
        const updatedProducts = [
            ...addedProducts,
            <AddProduct key={addedProducts.length} />,
        ];
        setAddedProducts(updatedProducts);
    };

    return (
        <>
            <div className="mb-5">
                {addedProducts.map((product, index) => (
                    <div key={index}>{product}</div>
                ))}
                <button className="btn m-5" onClick={handleButtonClick}>
                    Add Indent
                </button>
            </div>
            <div>
                <button className="btn m-5" onClick={handleButtonClick}>
                    Add Indent
                </button>
            </div>
        </>
    );
};

export default MultipleIndent;
