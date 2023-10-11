import React, { useState } from "react";
import Date from "../util/Date";

const AddIndent = () => {
    const [price, setPrice] = useState(null);
    const [quantity, setQuantity] = useState(null);
    const [selectedProduct, setSelectedProduct] = useState(null);
    const [selectedCategory, setSelectedCategory] = useState(null);
    const [unitMeasurement, setUnitMeasurement] = useState(null);
    const [selectedManufacturer, setSelectedManufacturer] = useState(null);

    const products = ["Product1", "Product2", "Product3"]; // Replace with your actual product data
    const categories = ["Category1", "Category2", "Category3"]; // Replace with your actual category data
    const unitMeasurements = ["kg", "lbs", "pieces"]; // Replace with your actual unit measurement data
    const manufacturers = ["Manufacturer1", "Manufacturer2", "Manufacturer3"]; // Replace with your actual manufacturer data
    const PQR=["unit price","total price"];
    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch("http://localhost:8080/mj/indentheader", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                description: "Third Indent",
                netprice: 0,
                isActive: 1,
                createdBy: "Raj",
                createdAt: Date(),
                modifiedBy: "Raj",
                modifiedAt: Date(),
                user: {
                    userId: 1,
                    role: {
                        roleId: 1,
                    },
                },
            }),
        });

        try {
            const response = await fetch("http://localhost:8080/mj/indent", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    unitPrice: price,
                    totalPrice: price * quantity,
                    quantity: quantity,
                    isActive: 1,
                    createdBy: "Raj",
                    createdAt: Date(),
                    modifiedBy: "Raj",
                    modifiedAt: Date(),
                    product: {
                        productId: 1,
                        category: {
                            categoryId: 1,
                        },
                    },
                    indentHeaderVO: {
                        indentHeaderId: 1,
                        user: {
                            userId: 1,
                            role: {
                                roleId: 1,
                            },
                        },
                    },
                }),
            });

            if (response.ok) {
                const result = await response.json();
                console.log("Post successful:", result);
            } else {
                console.error("Post failed");
            }
        } catch (error) {
            console.error("Error during POST request:", error);
        }

        console.log("Form submitted:", {
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
        <div className="container">
            <div className="row justify-content-center">
                <div className="col-md-12">
                    <div className="card mt-5">
                        <div className="card-body">
                            <h2
                                className="card-title mb-4"
                                style={{ textAlign: "center" }}
                            >
                                Add Indent
                            </h2>
                            <form onSubmit={handleSubmit}>
                                <div className="mb-3">
                                    <label className="form-label">
                                        Category:
                                    </label>
                                    <select
                                        className="form-select"
                                        value={selectedCategory}
                                        onChange={(e) =>
                                            setSelectedCategory(e.target.value)
                                        }
                                    >
                                        <option value="">
                                            Select a category
                                        </option>
                                        {categories.map((category) => (
                                            <option
                                                key={category}
                                                value={category}
                                            >
                                                {category}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">
                                        Product:
                                    </label>
                                    <select
                                        className="form-select"
                                        value={selectedProduct}
                                        onChange={(e) =>
                                            setSelectedProduct(e.target.value)
                                        }
                                    >
                                        <option value="">
                                            Select a product
                                        </option>
                                        {products.map((product) => (
                                            <option
                                                key={product}
                                                value={product}
                                            >
                                                {product}
                                            </option>
                                        ))}
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
                                            value={quantity}
                                            onChange={(e) =>
                                                setQuantity(
                                                    parseInt(e.target.value, 10)
                                                )
                                            }
                                        />
                                    </div>
                                    <div className="col">
                                        <label className="form-label">
                                            Unit Measurement:
                                        </label>
                                        <select
                                            className="form-select"
                                            value={unitMeasurement}
                                            onChange={(e) =>
                                                setUnitMeasurement(
                                                    e.target.value
                                                )
                                            }
                                        >
                                            <option value="">
                                                Select unit
                                            </option>
                                            {unitMeasurements.map((unit) => (
                                                <option key={unit} value={unit}>
                                                    {unit}
                                                </option>
                                            ))}
                                        </select>
                                    </div>
                                </div>
                                <div className="row mb-3">
                                    <div className="col">
                                        <label className="form-label">
                                            Price:
                                        </label>
                                        <input
                                            type="number"
                                            className="form-control"
                                            value={price}
                                            onChange={(e) =>
                                                setPrice(
                                                    parseFloat(e.target.value)
                                                )
                                            }
                                        />
                                    </div>
                                    <div className="col">
                                        <label className="form-label">
                                            Price Type:
                                        </label>
                                        <select
                                            className="form-select"
                                            value={unitMeasurement}
                                            onChange={(e) =>
                                                setPQR(
                                                    e.target.value
                                                )
                                            }
                                        >
                                            <option value="">
                                                Select Price Type
                                            </option>
                                            {PQR.map((unit) => (
                                                <option key={unit} value={unit}>
                                                    {unit}
                                                </option>
                                            ))}
                                        </select>
                                    </div>
                                </div>

                                <button
                                    type="submit"
                                    className="btn btn-primary"
                                >
                                    Submit
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddIndent;
