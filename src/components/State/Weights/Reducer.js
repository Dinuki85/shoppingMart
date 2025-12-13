import {
  CREATE_WEIGHT_CATEGORY_SUCCESS,
  CREATE_WEIGHT_SUCCESS,
  GET_WEIGHTS,
  GET_WEIGHT_CATEGORY_SUCCESS,
  UPDATE_STOCK,
} from "./ActionTypes";

const initialState = {
  weights: [],
  update: null,
  category: [],
};

export const WEIGHTReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_WEIGHTS:
      return {
        ...state,
        weights: action.payload,
      };
    case GET_WEIGHT_CATEGORY_SUCCESS:
      return {
        ...state,
        category: action.payload,
      };
    case CREATE_WEIGHT_CATEGORY_SUCCESS:
      return {
        ...state,
        category: [...state.category, action.payload],
      };
    case CREATE_WEIGHT_SUCCESS:
      return {
        ...state,
        weights: [...state.WEIGHTs, action.payload],
      };
    case UPDATE_STOCK:
      return {
        ...state,
        update: action.payload,
        weights: state.weights.map((item) =>
          item.id === action.payload.id ? action.payload : item
        ),
      };

    default:
      return state;
  }
};
