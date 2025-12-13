import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import { authReducer } from "./Authentication/Reducer";
import { thunk } from "redux-thunk";
import shopReducer from "./Shop/Reducer";

const rootReducer=combineReducers({
    auth:authReducer,
    shop:shopReducer,
    


})

export const store = legacy_createStore(rootReducer,applyMiddleware(thunk));

