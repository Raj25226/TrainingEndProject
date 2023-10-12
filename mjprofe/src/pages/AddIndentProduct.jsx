import React, { useEffect, useState } from "react";
import Date from "../util/Date";
import axios from "axios";

const AddProduct = () => {
    const [price, setPrice] = useState(0);
    const [unitPrice, setUnitPrice] = useState(0);
    const [totalPrice, setTotalPrice] = useState(0);
    const [quantity, setQuantity] = useState(0);
    const [selectedProduct, setSelectedProduct] = useState("");
    const [selectedCategory, setSelectedCategory] = useState("");
    const PQR = ["unit price", "total price"];
    const [category, setCategory] = useState([]);
    const [product, setProduct] = useState([]);
    const [pt, setPt] = useState("");

    const handlePrice = () => {
        // console.log(pt == "total price");
        // console.log(pt);
        if (pt == "total price") {
            setUnitPrice(price);
            setTotalPrice(price * quantity);
        } else {
            setUnitPrice(price / quantity);
            setTotalPrice(price);
        }
    };

    useEffect(() => {
        const fetchCategories = async () => {
            try {
                const response = await axios.get(
                    "http://localhost:8080/mj/category"
                );
                setCategory(response.data);
                console.log(response.data);
                const result = response.data;
                setCategory(result);
            } catch (error) {
                console.error("Error fetching categories:", error);
            } finally {
            }
        };

        const fetchProducts = async () => {
            try {
                const response = await axios.get(
                    "http://localhost:8080/mj/product"
                );
                const result = await response.data;
                console.log(result);
                setProduct(result);
            } catch (error) {
                console.error("Error fetching products:", error);
            } finally {
            }
        };

        fetchCategories();
        fetchProducts();
    }, []);

    const changeProductList = (id) => {
        const fetchProducts = async () => {
            try {
                const response = await axios.get(
                    `http://localhost:8080/mj/products/${id}`
                );
                const result = await response.data;
                console.log(result);
                setProduct(result);
            } catch (error) {
                console.error("Error fetching products:", error);
            } finally {
            }
        };
        fetchProducts();
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(e);
        e.target.disabled =true;
        const response2 = await fetch("http://localhost:8080/mj/indent", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                unitPrice: unitPrice,
                totalPrice: totalPrice,
                quantity: quantity,
                isActive: 1,
                createdBy: "Raj",
                createdAt: Date(),
                modifiedBy: "Raj",
                modifiedAt: Date(),
                product: {
                    productId: selectedProduct,
                    category: {
                        categoryId: selectedCategory,
                    },
                },
                indentHeaderVO: {
                    indentHeaderId: localStorage.getItem("hid"),
                    user: {
                        userId: 1,
                        role: {
                            roleId: 1,
                        },
                    },
                },
            }),
        });
    };

    return (
        <div className="container mb-5">
            <div className="row justify-content-center">
                <div className="col-md-12">
                    <div className="card mt-5">
                        <div className="card-body">
                            <h2
                                className="card-title mb-4"
                                style={{ textAlign: "center" }}
                            >
                                Add Product
                            </h2>
                            <form>
                                <fieldset>
                                    <div className="mb-3">
                                        <label className="form-label">
                                            Category:
                                        </label>
                                        <select
                                            className="form-select"
                                            value={selectedCategory}
                                            onChange={(e) => {
                                                setSelectedCategory(
                                                    e.target.value
                                                );
                                                changeProductList(
                                                    e.target.value
                                                );
                                            }}
                                        >
                                            <option value="">
                                                Select a category
                                            </option>
                                            {category.map((cat) => (
                                                <option
                                                    key={cat.categoryId}
                                                    value={cat.categoryId}
                                                >
                                                    {cat.categoryName}
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
                                                setSelectedProduct(
                                                    e.target.value
                                                )
                                            }
                                        >
                                            <option value="">
                                                Select a product
                                            </option>
                                            {product.map((prod) => (
                                                <option
                                                    key={prod.productId}
                                                    value={prod.productId}
                                                >
                                                    {prod.productName}
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
                                                        parseInt(
                                                            e.target.value,
                                                            10
                                                        )
                                                    )
                                                }
                                            />
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
                                                        parseFloat(
                                                            e.target.value,
                                                            0
                                                        )
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
                                                value={pt}
                                                onChange={(e) => {
                                                    setPt(e.target.value);
                                                    handlePrice();
                                                }}
                                            >
                                                <option value="">
                                                    Select Price Type
                                                </option>
                                                {PQR.map((unit) => (
                                                    <option
                                                        key={unit}
                                                        value={unit}
                                                    >
                                                        {unit}
                                                    </option>
                                                ))}
                                            </select>
                                        </div>
                                    </div>

                                    <button
                                        id="disab"
                                        type="submit"
                                        className="btn btn-primary"
                                        onClick={(e)=>{
                                            handleSubmit(e);
                                        }}
                                    >
                                        ADD
                                    </button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddProduct;
