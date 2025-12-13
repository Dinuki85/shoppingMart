import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "./Authentication/Reducer";
import { thunk } from "redux-thunk";
import shopReducer from "./Shop/Reducer";
import menuItemReducer from "./Menu/Reducer";
import cartReducer from "./Cart/Reducer";
import { orderReducer } from "./Orders/Reducer";
import { WEIGHTReducer } from "./Weights/Reducer";
import shopOrderReducer from "./Shop Order/Reducer";

const rootReducer=combineReducers({
    auth:authReducer,
    shop:shopReducer,
    menu:menuItemReducer,
    cart:cartReducer,
    order:orderReducer,
    shopOrder:shopOrderReducer,
    weights:WEIGHTReducer


})

export const store = legacy_createStore(rootReducer,applyMiddleware(thunk));

