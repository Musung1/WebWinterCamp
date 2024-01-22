import axios from "axios";

const API_BASE_URL = 'http://localhost:8080/api';

const apiService = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});
export const getAllArticles = async () => {
    getPagedArticles(1);
  };
  export const getPagedArticles = async (currentPage) => {
    try {
      const response = await apiService.get('/articles?currentPage=' + currentPage);
      return response.data;
    } catch (error) {
      console.error('Error fetching articles:', error);
      throw error;
    }
  }
  export const createArticle = async (writeForm) => {
    try {
      const response = await apiService.post('/articles',writeForm);
      return response.data;
    } catch (error) {
      console.error('Error fetching articles:', error);
      throw error;
    }
  };
  export const updateArticle = async (updateForm) => {
    try {
      const response = await apiService.put('/articles',updateForm);
      return response.data;
    } catch (error) {
      console.error('Error fetching articles:', error);
      throw error;
    }
  };
  export const deleteArticle = async (id) => {
    try {
      const response = await apiService.delete('/articles/'+ id);
      return response.data;
    } catch (error) {
      console.error('Error fetching articles:', error);
      throw error;
    }
  };