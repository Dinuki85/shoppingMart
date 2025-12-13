import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "./Authentication/Reducer";
import { thunk } from "redux-thunk";
import shopReducer from "./Shop/Reducer";
import menuItemReducer from "./Menu/Reducer";
import cartReducer from "./Cart/Reducer";

const rootReducer=combineReducers({
    auth:authReducer,
    shop:shopReducer,
    menu:menuItemReducer,
    cart:cartReducer,
    


})

export const store = legacy_createStore(rootReducer,applyMiddleware(thunk));

