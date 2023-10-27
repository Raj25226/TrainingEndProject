import { createSlice } from "@reduxjs/toolkit";

const initialState = [];

export const productSlice = createSlice({
  name: "productSlice",
  initialState,
  reducers: {
    addProductPrice: (state, action) => {
      state.push(action.payload);
    },
    updateProductPrice: (state, action) => {
      return state.filter((p) => p != action.payload);
    },
    removeAllProductPrice: (state, action) => {
      state = [];
    },
  },
});

export const { addProductPrice, updateProductPrice, removeAllProductPrice } =
  productSlice.actions;

export default productSlice.reducer;
