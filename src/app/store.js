import { configureStore } from "@reduxjs/toolkit";
import productSliceReducer from "../slices/productSlice";
import loginSliceReducer from "../slices/loginSlice";
import { productApi } from "../service/product";
import { setupListeners } from "@reduxjs/toolkit/dist/query";


export const store = configureStore({
    reducer: {
        product:productSliceReducer,
        login:loginSliceReducer,
        [productApi.reducerPath]: productApi.reducer,
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(productApi.middleware)
})

setupListeners(store.dispatch)