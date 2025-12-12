import axios from "axios"

export const API_URL = "http://localhost:5454/"//when deployed backend need to provide that URL

export const api=axios.create({
    baseURL:API_URL,
    header:{
        "Content-Type":"application/json"
    }
})