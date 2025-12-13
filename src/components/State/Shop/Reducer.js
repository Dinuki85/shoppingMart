import { CREATE_CATEGORY_FAILURE, CREATE_CATEGORY_SUCCESS, CREATE_EVENTS_FAILURE, CREATE_EVENTS_SUCCESS, CREATE_SHOP_FAILURE, CREATE_SHOP_REQUEST, CREATE_SHOP_SUCCESS, DELETE_EVENTS_SUCCESS, DELETE_SHOP_FAILURE, DELETE_SHOP_REQUEST, DELETE_SHOP_SUCCESS, GET_ALL_EVENTS_SUCCESS, GET_ALL_SHOP_FAILURE, GET_ALL_SHOP_REQUEST, GET_ALL_SHOP_SUCCESS, GET_SHOP_BY_ID_FAILURE, GET_SHOP_BY_ID_REQUEST, GET_SHOP_BY_ID_SUCCESS, GET_SHOP_BY_USER_ID_SUCCESS, GET_SHOPS_CATEGORY_FAILURE, GET_SHOPS_CATEGORY_REQUEST, GET_SHOPS_CATEGORY_SUCCESS, GET_SHOPS_EVENTS_SUCCESS, UPDATE_SHOP_FAILURE, UPDATE_SHOP_REQUEST, UPDATE_SHOP_STATUS_SUCCESS, UPDATE_SHOP_SUCCESS } from "./ActionType";


const initialState = {
  shops: [],
  usersShop: null,
  shop: null,
  loading: false,
  error: null,
  events: [],
  shopsEvents: [],
  categories: [],
};

const shopReducer = (state = initialState, action) => {
  switch (action.type) {
    case CREATE_SHOP_REQUEST:
    case GET_ALL_SHOP_REQUEST:
    case DELETE_SHOP_REQUEST:
    case UPDATE_SHOP_REQUEST:
    case GET_SHOP_BY_ID_REQUEST:
    case GET_SHOPS_CATEGORY_REQUEST:
      return {
        ...state,
        loading: true,
        error: null,
      };
    case CREATE_SHOP_SUCCESS:
      return {
        ...state,
        loading: false,
        usersShop:action.payload
      };
    case GET_ALL_SHOP_SUCCESS:
      return {
        ...state,
        loading: false,
        shops: action.payload,
      };
    case GET_SHOP_BY_ID_SUCCESS:
      return {
        ...state,
        loading: false,
        shop: action.payload,
      };
    case GET_SHOP_BY_USER_ID_SUCCESS:
    case UPDATE_SHOP_STATUS_SUCCESS:
    case UPDATE_SHOP_SUCCESS:
      return {
        ...state,
        loading: false,
        usersShop: action.payload,
      };

    case DELETE_SHOP_SUCCESS:
      return {
        ...state,
        error: null,
        loading: false,
        shops: state.shops.filter(
          (item) => item.id !== action.payload
        ),
        usersshop: state.usersshop.filter(
          (item) => item.id !== action.payload
        ),
      };

    case CREATE_EVENTS_SUCCESS:
      return {
        ...state,
        loading: false,
        events: [...state.events, action.payload],
       shopsEvents: [...state.shopsEvents, action.payload],
      };
    case GET_ALL_EVENTS_SUCCESS:
      return {
        ...state,
        loading: false,
        events: action.payload,
      };
    case GET_SHOPS_EVENTS_SUCCESS:
      return {
        ...state,
        loading: false,
        eventssEvents: action.payload,
      };
    case DELETE_EVENTS_SUCCESS:
      return {
        ...state,
        loading: false,
        events: state.events.filter((item) => item.id !== action.payload),
        shopsEvents: state.shopsEvents.filter(
          (item) => item.id !== action.payload
        ),
      };
    case CREATE_CATEGORY_SUCCESS:
      return {
        ...state,
        loading: false,
        categories: [...state.categories, action.payload],
      };
    case GET_SHOPS_CATEGORY_SUCCESS:
      return {
        ...state,
        loading: false,
        categories: action.payload,
      };
    case CREATE_SHOP_FAILURE:
    case GET_ALL_SHOP_FAILURE:
    case DELETE_SHOP_FAILURE:
    case UPDATE_SHOP_FAILURE:
    case GET_SHOP_BY_ID_FAILURE:
    case CREATE_EVENTS_FAILURE:
    case CREATE_CATEGORY_FAILURE:
    case GET_SHOPS_CATEGORY_FAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload,
      };
    default:
      return state;
  }
};

export default shopReducer;
