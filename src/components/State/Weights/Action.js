// action.js
import axios from 'axios';
import { CREATE_WEIGHTS_CATEGORY_FAILURE, CREATE_WEIGHTS_CATEGORY_SUCCESS, CREATE_WEIGHTS_SUCCESS, GET_WEIGHTS, GET_WEIGHTS_CATEGORY_FAILURE, GET_WEIGHTS_CATEGORY_SUCCESS, UPDATE_STOCK } from './ActionType';
import { API_URL, api } from '../../../config/api';

export const getWeightsOfshop = ({id,jwt}) => {
  return async (dispatch) => {
    try {
      const response = await api.get(`/admin/weights/shop/${id}`,{
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("get all WEIGHTS ",response.data)
      dispatch({
        type: GET_WEIGHTS,
        payload: response.data // Assuming the response contains the WEIGHTS data
      });
    } catch (error) {
        console.log("error",error)
      // Handle error, dispatch an error action, etc.
    }
  };
};

export const createWEIGHTS= ({data,jwt}) => {
  return async (dispatch) => {
    try {
      const response = await api.post(`/admin/weights`,data,{
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("create WEIGHTS ",response.data)
      dispatch({
        type: CREATE_WEIGHTS_SUCCESS,
        payload: response.data 
      });
    } catch (error) {
        console.log("error",error)
      // Handle error, dispatch an error action, etc.
    }
  };
};

export const createWEIGHTSCategory = ({data,jwt}) => {
  console.log("data ",data,"jwt",jwt)
  return async (dispatch) => {
    try {
      const response = await api.post(`/admin/weights/category`,data,{
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("create WEIGHTS category",response.data)
      dispatch({
        type:CREATE_WEIGHTS_CATEGORY_SUCCESS,
        payload: response.data 
      });
    } catch (error) {
        console.log("error",error)
      // Handle error, dispatch an error action, etc.
    }
  };
};

export const getWEIGHTSategory = ({id,jwt}) => {
  return async (dispatch) => {
    try {
      const response = await api.get(`/admin/weights/shop/${id}/category`,{
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      console.log("get WEIGHTS category",response.data)
      dispatch({
        type: GET_WEIGHTS_CATEGORY_SUCCESS,
        payload: response.data 
      });
    } catch (error) {
        console.log("error",error)
      
    }
  };
};

export const updateStockOfWEIGHTS= ({id,jwt}) => {
  return async (dispatch) => {
    try {
      const {data} = await api.put(`/admin/WEIGHTS/${id}/stock`, 
      { },
      {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      });
      dispatch({
        type: UPDATE_STOCK,
        payload: data
      });
      console.log("update WEIGHTS stock ",data)
    } catch (error) {
        console.log("error ",error)
      // Handle error, dispatch an error action, etc.
    }
  };
};
