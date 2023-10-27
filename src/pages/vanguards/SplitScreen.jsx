import { useState } from 'react';
import priceData from '../../data/ProduuctPrice.json';
import vendorData from '../../data/SupplierData.json';
export default function SplitTendor() {
    const [total, setTotal] = useState(0);
    const [selectedColumns, setSelectedColumns] = useState(Array(priceData.length).fill(null));
    const handleButtonClick = (value, columnIndex) => {
        setTotal(total + parseFloat(value));
        const newSelectedColumns = [...selectedColumns];
        newSelectedColumns[columnIndex] = columnIndex;
        setSelectedColumns(newSelectedColumns);
    };
    return (
        <>
            <div className="card">
                <table className='table table-striped'>
                    <thead>
                        <tr>
                            <th style={{ backgroundColor: "#053B50", borderColor: "#053B50" }}></th>
                            {priceData.map((item, index) => (
                                <th key={index} style={{ backgroundColor: "#053B50", color: "white" }}>{item.product}</th>
                            ))}
                        </tr>
                    </thead>
                    <tbody>
                        {vendorData.map((item, rowindex) => (
                            <tr key={rowindex}>
                                <td style={{ backgroundColor: "#053B50", color: "white", borderColor: "#053B50" }}>{item.name}</td>
                                {priceData.map((product, columnIndex) => (
                                    <td key={columnIndex}><button className="btn btn-outline-dark" value={product.price} onClick={() => handleButtonClick(product.price, columnIndex)}
                                    disabled={selectedColumns[columnIndex] !== rowindex}>{product.price}</button></td>
                                ))}
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <div className="d-flex justify-content-center gap-2">
                <button className="btn btn-outline-dark">Show Total price</button>
                <button className="btn btn-danger">Generate PO</button>
            </div>
        </>
    );
}