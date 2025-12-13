import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "./Authentication/Reducer";
import { thunk } from "redux-thunk";
import shopReducer from "./Shop/Reducer";
import menuItemReducer from "./Menu/Reducer";

const rootReducer=combineReducers({
    auth:authReducer,
    shop:shopReducer,
    menu:menuItemReducer,


})

export const store = legacy_createStore(rootReducer,applyMiddleware(thunk));

