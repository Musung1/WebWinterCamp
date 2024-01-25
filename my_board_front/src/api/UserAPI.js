import axios from "axios";

const API_BASE_URL = 'http://localhost:8080/api';

export const apiService = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  withCredentials: true,
});


export const login = async (loginForm) => {
    try {
      const response = await apiService.post('/login',loginForm);
      return true;
    } catch (error) {
        throw error;
    }
  }
  export const signup = async (signupForm) => {
    try {
      const response = await apiService.post('/signup',signupForm);
      return true;
    } catch (error) {
        throw error;
    }
  }
  export const loginTest = async () => {
    try {
      const response = await apiService.get('/loginTest');
      return true;
    } catch (error) {
        throw error;
    }
  }