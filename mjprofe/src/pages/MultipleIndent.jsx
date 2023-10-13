import React, { useState } from "react";
import AddProduct from "./AddIndentProduct";
import { useNavigate } from "react-router-dom";

const MultipleIndent = () => {
    const [addedProducts, setAddedProducts] = useState([]);
    const [firstButtonClick, setFirstButtonClick] = useState(false);
    const navigate = useNavigate();


    const handleFirstButtonClick = () => {
        const updatedProducts = [
            ...addedProducts,
            <AddProduct key={addedProducts.length} />,
        ];
        setAddedProducts(updatedProducts);
        setFirstButtonClick(true);
    };

    const handleSecondButtonClick = () => {
        navigate('/indentlist');
    };

    return (
        <>
            <div className="mb-5">
                {addedProducts.map((product, index) => (
                    <div key={index}>{product}</div>
                ))}
                <div style={{marginLeft:"50%"}}>
                <button className="btn m-5" onClick={handleFirstButtonClick}>
                    Add Item
                </button>
                {firstButtonClick && (
                    <button
                        className="btn m-5 float-right"
                        onClick={handleSecondButtonClick}
                    >
                        Submit Indent
                    </button>
            )}
            </div>
            </div>
            
        </>
    );
};

export default MultipleIndent;
