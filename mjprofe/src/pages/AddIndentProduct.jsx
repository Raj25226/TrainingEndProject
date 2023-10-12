import React, { useState } from "react";

const AddProduct = () => {

    const [formData, setFormData] = useState({
        selectedCategory: "",
        selectedProduct: "",
        quantity: 0,
        unitMeasurement: "",
        price: 0,
        pt: "",
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(formData);
    };

    return (
        <div className="container mb-5">
            <div className="row justify-content-center">
                <div className="col-md-12">
                    <div className="card mt-5 p-5">
                        <form onSubmit={handleSubmit}>
                            <div className="mb-3">
                                <label className="form-label">Category:</label>
                                <select
                                    className="form-select"
                                    name="selectedCategory"
                                    value={formData.selectedCategory}
                                    onChange={handleInputChange}
                                >
                                    <option value="">Select a category</option>
                                </select>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">Product:</label>
                                <select
                                    className="form-select"
                                    name="selectedProduct"
                                    value={formData.selectedProduct}
                                    onChange={handleInputChange}
                                >
                                    <option value="">Select a product</option>
                                </select>
                            </div>
                            <div className="row mb-3">
                                <div className="col">
                                    <label className="form-label">
                                        Quantity:
                                    </label>
                                    <input
                                        type="number"
                                        className="form-control"
                                        name="quantity"
                                        value={formData.quantity}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <div className="col">
                                    <label className="form-label">
                                        Unit Measurement:
                                    </label>
                                    <select
                                        className="form-select"
                                        name="unitMeasurement"
                                        value={formData.unitMeasurement}
                                        onChange={handleInputChange}
                                    >
                                        <option value="">Select unit</option>
                                    </select>
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col">
                                    <label className="form-label">Price:</label>
                                    <input
                                        type="number"
                                        className="form-control"
                                        name="price"
                                        value={formData.price}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <div className="col">
                                    <label className="form-label">
                                        Price Type:
                                    </label>
                                    <select
                                        className="form-select"
                                        name="pt"
                                        value={formData.pt}
                                        onChange={handleInputChange}
                                    >
                                        <option value="">
                                            Select Price Type
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" className="btn btn-primary">
                                Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddProduct;
