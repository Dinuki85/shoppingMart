import { api } from "../../config/api";
import {
  CREATE_CATEGORY_FAILURE,
  CREATE_CATEGORY_REQUEST,
  CREATE_CATEGORY_SUCCESS,
  CREATE_EVENTS_FAILURE,
  CREATE_EVENTS_REQUEST,
  CREATE_EVENTS_SUCCESS,
  CREATE_SHOP_FAILURE,
  CREATE_SHOP_REQUEST,
  CREATE_SHOP_SUCCESS,
  DELETE_EVENTS_FAILURE,
  DELETE_EVENTS_REQUEST,
  DELETE_EVENTS_SUCCESS,
  DELETE_SHOP_FAILURE,
  DELETE_SHOP_REQUEST,
  DELETE_SHOP_SUCCESS,
  GET_ALL_EVENTS_FAILURE,
  GET_ALL_EVENTS_REQUEST,
  GET_ALL_EVENTS_SUCCESS,
  GET_ALL_SHOP_FAILURE,
  GET_ALL_SHOP_REQUEST,
  GET_ALL_SHOP_SUCCESS,
  GET_SHOP_BY_ID_FAILURE,
  GET_SHOP_BY_ID_REQUEST,
  GET_SHOP_BY_ID_SUCCESS,
  GET_SHOP_BY_USER_ID_FAILURE,
  GET_SHOP_BY_USER_ID_SUCCESS,
  GET_SHOPS_CATEGORY_FAILURE,
  GET_SHOPS_CATEGORY_REQUEST,
  GET_SHOPS_CATEGORY_SUCCESS,
  GET_SHOPS_EVENTS_FAILURE,
  GET_SHOPS_EVENTS_REQUEST,
  GET_SHOPS_EVENTS_SUCCESS,
  UPDATE_SHOP_FAILURE,
  UPDATE_SHOP_REQUEST,
  UPDATE_SHOP_STATUS_FAILURE,
  UPDATE_SHOP_STATUS_REQUEST,
  UPDATE_SHOP_STATUS_SUCCESS,
  UPDATE_SHOP_SUCCESS
} from "./ActionType";

// Helper function to get token safely
const getToken = (tokenFromArg) => {
  // If token is passed as argument, use it, otherwise fallback to localStorage
  const token = tokenFromArg || localStorage.getItem("token");
  if (!token) {
    console.warn("JWT token not found! Requests requiring authentication may fail.");
  }
  return token;
};

// ------------------ SHOP ACTIONS ------------------ //

export const getAllShoptAction = (token) => {
  return async (dispatch) => {
    dispatch({ type: GET_ALL_SHOP_REQUEST });
    try {
      const jwt = getToken(token);
      if (!jwt) throw new Error("No JWT token found for getAllShoptAction");

      const { data } = await api.get(`/shop/getAll`, {
        headers: { Authorization: `Bearer ${jwt}` },
      });

      console.log("all shops", data);
      dispatch({ type: GET_ALL_SHOP_SUCCESS, payload: data });
    } catch (error) {
      dispatch({ type: GET_ALL_SHOP_FAILURE, payload: error });
      console.error("catch error in getAllShoptAction:", error);
    }
  };
};

export const getShopById = (reqData) => {
  return async (dispatch) => {
    dispatch({ type: GET_SHOP_BY_ID_REQUEST });
    try {
      const jwt = getToken(reqData.jwt);
      if (!jwt) throw new Error("No JWT token found for getShopById");

      const response = await api.get(`/shop/find/${reqData.shopId}`, {
        headers: { Authorization: `Bearer ${jwt}` },
      });

      dispatch({ type: GET_SHOP_BY_ID_SUCCESS, payload: response.data });
    } catch (error) {
      dispatch({ type: GET_SHOP_BY_ID_FAILURE, payload: error });
      console.error("error in getShopById:", error);
    }
  };
};

export const getShopByUserId = ({ jwt }) => {
  return async (dispatch) => {
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for getShopByUserId");

      const { data } = await api.get('/admin/shop/user', {
        headers: { Authorization: `Bearer ${token}` },
      });

      console.log("get shop by user id", data);
      dispatch({ type: GET_SHOP_BY_USER_ID_SUCCESS, payload: data });
    } catch (error) {
      console.error("catch error in getShopByUserId:", error);
      dispatch({ type: GET_SHOP_BY_USER_ID_FAILURE, payload: error.message });
    }
  };
};

// ------------------ CREATE SHOP ------------------ //
export const createShop = (reqData) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_SHOP_REQUEST });
    try {
      const jwt = getToken(reqData.token);
      if (!jwt) throw new Error("No JWT token found for createShop");

      const { data } = await api.post('/admin/shop', reqData.data, {
        headers: { Authorization: `Bearer ${jwt}` },
      });

      console.log("Created shop:", data);
      dispatch({ type: CREATE_SHOP_SUCCESS, payload: data });

      // Update UI by fetching all shops
      dispatch(getAllShoptAction(jwt));
    } catch (error) {
      console.error("catch error in createShop:", error);
      dispatch({ type: CREATE_SHOP_FAILURE, payload: error.message });
    }
  };
};

// ------------------ UPDATE SHOP ------------------ //
export const updateshop = ({ shopId, shopData, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: UPDATE_SHOP_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for updateshop");

      const res = await api.put(`/api/admin/shop/${shopId}`, shopData, {
        headers: { Authorization: `Bearer ${token}` },
      });
      dispatch({ type: UPDATE_SHOP_SUCCESS, payload: res.data });
    } catch (error) {
      dispatch({ type: UPDATE_SHOP_FAILURE, payload: error });
    }
  };
};

// ------------------ DELETE SHOP ------------------ //
export const deleteShop = ({ shopId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: DELETE_SHOP_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for deleteShop");

      const res = await api.delete(`/admin/shop/${shopId}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log("delete Shop", res.data);
      dispatch({ type: DELETE_SHOP_SUCCESS, payload: shopId });
    } catch (error) {
      console.error("catch error in deleteShop:", error);
      dispatch({ type: DELETE_SHOP_FAILURE, payload: error });
    }
  };
};

// ------------------ UPDATE SHOP STATUS ------------------ //
export const updateShopStatus = ({ shopId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: UPDATE_SHOP_STATUS_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for updateShopStatus");

      const res = await api.put(
        `/admin/restaurants/${shopId}/status`,
        {}, // empty body required by backend
        { headers: { Authorization: `Bearer ${token}` } }
      );
      console.log("updateShopStatus response:", res.data);
      dispatch({ type: UPDATE_SHOP_STATUS_SUCCESS, payload: res.data });
    } catch (error) {
      console.error("error in updateShopStatus:", error);
      dispatch({ type: UPDATE_SHOP_STATUS_FAILURE, payload: error });
    }
  };
};

// ------------------ EVENT ACTIONS ------------------ //
export const createEventAction = ({ data, jwt, shopId }) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_EVENTS_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for createEventAction");

      const res = await api.post(`/admin/events/shop/${shopId}`, data, {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log("create events", res.data);
      dispatch({ type: CREATE_EVENTS_SUCCESS, payload: res.data });
    } catch (error) {
      console.error("catch error in createEventAction:", error);
      dispatch({ type: CREATE_EVENTS_FAILURE, payload: error });
    }
  };
};

export const getAllEvents = ({ jwt }) => {
  return async (dispatch) => {
    dispatch({ type: GET_ALL_EVENTS_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for getAllEvents");

      const res = await api.get(`/events`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log("get all events", res.data);
      dispatch({ type: GET_ALL_EVENTS_SUCCESS, payload: res.data });
    } catch (error) {
      dispatch({ type: GET_ALL_EVENTS_FAILURE, payload: error });
    }
  };
};

// ------------------ DELETE EVENT ------------------ //
export const deleteEventAction = ({ eventId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: DELETE_EVENTS_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for deleteEventAction");

      const res = await api.delete(`/admin/events/${eventId}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log("DELETE events", res.data);
      dispatch({ type: DELETE_EVENTS_SUCCESS, payload: eventId });
    } catch (error) {
      console.error("catch error in deleteEventAction:", error);
      dispatch({ type: DELETE_EVENTS_FAILURE, payload: error });
    }
  };
};

// ------------------ SHOP EVENTS ------------------ //
export const getShopsEvents = ({ shopId, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: GET_SHOPS_EVENTS_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for getShopsEvents");

      const res = await api.get(`/admin/events/shop/${shopId}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log("get shops event", res.data);
      dispatch({ type: GET_SHOPS_EVENTS_SUCCESS, payload: res.data });
    } catch (error) {
      dispatch({ type: GET_SHOPS_EVENTS_FAILURE, payload: error });
    }
  };
};

// ------------------ CATEGORY ACTIONS ------------------ //
export const createCategoryAction = ({ reqData, jwt }) => {
  return async (dispatch) => {
    dispatch({ type: CREATE_CATEGORY_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for createCategoryAction");

      const res = await api.post(`/admin/category`, reqData, {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log("create category", res.data);
      dispatch({ type: CREATE_CATEGORY_SUCCESS, payload: res.data });
    } catch (error) {
      console.error("catch error in createCategoryAction:", error);
      dispatch({ type: CREATE_CATEGORY_FAILURE, payload: error });
    }
  };
};

export const getShopsCategory = ({ jwt, shopId }) => {
  return async (dispatch) => {
    dispatch({ type: GET_SHOPS_CATEGORY_REQUEST });
    try {
      const token = getToken(jwt);
      if (!token) throw new Error("No JWT token found for getShopsCategory");

      const res = await api.get(`/category/shop/${shopId}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log("get Shops category", res.data);
      dispatch({ type: GET_SHOPS_CATEGORY_SUCCESS, payload: res.data });
    } catch (error) {
      dispatch({ type: GET_SHOPS_CATEGORY_FAILURE, payload: error });
    }
  };
};
