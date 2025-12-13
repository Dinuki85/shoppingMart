import { api } from "../../../config/api";
import { CREATE_MENU_ITEM_FAILURE, CREATE_MENU_ITEM_REQUEST, CREATE_MENU_ITEM_SUCCESS, DELETE_MENU_ITEM_FAILURE, DELETE_MENU_ITEM_REQUEST, DELETE_MENU_ITEM_SUCCESS, GET_MENU_ITEMS_BY_SHOP_ID_FAILURE, GET_MENU_ITEMS_BY_SHOP_ID_REQUEST, GET_MENU_ITEMS_BY_SHOP_ID_SUCCESS, SEARCH_MENU_ITEM_FAILURE, SEARCH_MENU_ITEM_REQUEST, SEARCH_MENU_ITEM_SUCCESS, UPDATE_MENU_ITEMS_AVAILABILITY_FAILURE, UPDATE_MENU_ITEMS_AVAILABILITY_REQUEST, UPDATE_MENU_ITEMS_AVAILABILITY_SUCCESS } from "./ActionType";


export const createMenuItem = ({menu,jwt}) => {
  return async (dispatch) => {
    dispatch({type:CREATE_MENU_ITEM_REQUEST});
    try {
      const { data } = await api.post("/admin/grocery", menu,
      {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("created menu ", data);
      dispatch({type:CREATE_MENU_ITEM_SUCCESS,payload:data});
    } catch (error) {
      console.log("catch error ", error);
      dispatch({type:CREATE_MENU_ITEM_FAILURE,payload:error});
    }
  };
};

export const getMenuItemsByShopId = (reqData) => {
  return async (dispatch) => {
    dispatch({type:GET_MENU_ITEMS_BY_SHOP_ID_REQUEST});
    try {
      const { data } = await api.get(
        `/api/grocery/shop/${reqData.shopId}?vegetarian=${reqData.vegetarian}&nonveg=${reqData.nonveg}
        &seasonal=${reqData.seasonal}&grocery_category=${reqData.groceryCategory}`,
        {
          headers: {
            Authorization: `Bearer ${reqData.jwt}`,
          },
        }
      );
      console.log("menu item by shops ", data);
      dispatch({type:GET_MENU_ITEMS_BY_SHOP_ID_SUCCESS,payload:data});
    } catch (error) {
      dispatch({type:GET_MENU_ITEMS_BY_SHOP_ID_FAILURE,pauload:error});
    }
  };
};

export const searchMenuItem = ({keyword,jwt}) => {
  return async (dispatch) => {
    dispatch({ type: SEARCH_MENU_ITEM_REQUEST });
    try {
      const { data } = await api.get(`/grocery/search?name=${keyword}`,{
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("data ----------- ", data);
      dispatch({ type: SEARCH_MENU_ITEM_SUCCESS, payload: data });
    } catch (error) {
      dispatch({ type: SEARCH_MENU_ITEM_FAILURE });
    }
  };
};

export const getAllIngredientsOfMenuItem = (reqData) => {
  return async (dispatch) => {
    dispatch({type:GET_MENU_ITEMS_BY_SHOP_ID_REQUEST});
    try {
      const { data } = await api.get(
        `/grocery/shop/${reqData.shopId}`,
        {
          headers: {
            Authorization: `Bearer ${reqData.jwt}`,
          },
        }
      );
      console.log("menu item by shops ", data);
      dispatch({type:GET_MENU_ITEMS_BY_SHOP_ID_SUCCESS,payload:data});
    } catch (error) {
      dispatch({type:GET_MENU_ITEMS_BY_SHOP_ID_FAILURE,payload:error});
    }
  };
};

export const updateMenuItemsAvailability = ({groceryId,jwt}) => {
  return async (dispatch) => {
    dispatch({ type: UPDATE_MENU_ITEMS_AVAILABILITY_REQUEST });
    try {
      const { data } = await api.put(`/admin/grocery/${groceryId}`, {},{
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("update menuItems Availability ", data);
      dispatch({ type: UPDATE_MENU_ITEMS_AVAILABILITY_SUCCESS, payload: data });
    } catch (error) {
      console.log("error ",error)
      dispatch({
        type: UPDATE_MENU_ITEMS_AVAILABILITY_FAILURE,
        payload: error,
      });
    }
};
};

export const deletegroceryAction = ({groceryId,jwt}) => async (dispatch) => {
  dispatch({ type: DELETE_MENU_ITEM_REQUEST });
  try {
    const { data } = await api.delete(`/admin/grocery/${groceryId}`, {
      headers: {
        Authorization: `Bearer ${jwt}`,
      },
    });
    console.log("delete grocery ", data);
    dispatch({ type: DELETE_MENU_ITEM_SUCCESS, payload: groceryId });
  } catch (error) {
    dispatch({ type: DELETE_MENU_ITEM_FAILURE
        , payload: error });
  }
};
