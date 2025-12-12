import axios from "axios";
import {
    ADD_TO_FAVORITE_FAILURE,
    ADD_TO_FAVORITE_REQUEST,
  ADD_TO_FAVORITE_SUCCESS,
  GET_USER_FAILURE,
  GET_USER_REQUEST,
  LOGIN_FAILURE,
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGOUT,
  REGISTER_FAILURE,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
} from "./ActionType";
import { api, API_URL } from "../../config/api";

export const registerUser = (reqData) => async (dispatch) => {
  dispatch({ type: REGISTER_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signup`,
      reqData.userData
    );
    if (data.jwt) localStorage.setItem("jwt", data.jwt);
    if (data.role === "ROLE_SHOP_OWNER") {
      reqData.navigate("/admin/resturant");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: REGISTER_SUCCESS, payload: data.jwt });
    console.log("register success", data);
  } catch (error) {
    dispatch({type:REGISTER_FAILURE,payload:error})
    console.log("error", error);
  }
};

export const loginUser = (reqData) => async (dispatch) => {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signing`,
      reqData.userData
    );
    if (data.jwt) localStorage.setItem("jwt", data.jwt);
    if (data.role === "ROLE_SHOP_OWNER") {
      reqData.navigate("/admin/resturant");
    } else {
      reqData.navigate("/");
    }
    dispatch({ type: LOGIN_SUCCESS, payload: data.jwt });
    console.log("login success", data);
  } catch (error) {
     dispatch({type:LOGIN_FAILURE,payload:error})
    console.log("error", error);
  }
};

export const getUser = (jwt) => async (dispatch) => {
  dispatch({ type: GET_USER_REQUEST });
  try {
    const { data } = await api.get(`/users/profile`, {
      headers: {
        Authorization: `Bearer ${jwt}`,
      },
    });
    console.log("User Profile", data);
    dispatch({ type: LOGIN_SUCCESS, payload: data});
  } catch (error) {
     dispatch({type:GET_USER_FAILURE,payload:error})
    console.log("error", error);
  }
};


export const addToFavouriter = (jwt,shopId) => async (dispatch) => {
  dispatch({ type: ADD_TO_FAVORITE_REQUEST });
  try {
    const { data } = await api.put(`/auth/resturants/${shopId}/add-favorite`,{}, {
      headers: {
        Authorization: `Bearer ${jwt}`
      },
    });
    console.log("Added to Favorite", data);
    dispatch({ type: ADD_TO_FAVORITE_SUCCESS, payload: data });
  } catch (error) {
    dispatch({type:ADD_TO_FAVORITE_FAILURE,payload:error})
    console.log("error", error);
  }
};

export const logout = () => async (dispatch) => {
  dispatch({ type: ADD_TO_FAVORITE_REQUEST });
  try {
   localStorage.clear()
    console.log("Logout success");
    dispatch({ type: LOGOUT });
  } catch (error) {

    console.log("error", error);
  }
};

