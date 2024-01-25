import axios from "axios";
import { apiService } from "./UserAPI";



export const getAllArticles = async () => {
    getPagedArticles1(1);
  };
  export const getPagedArticles1 = async (pageInfo) => {
    console.log(pageInfo)
    let currentPage = pageInfo.currentPage
    let keyword = pageInfo.keyword
    let createdSortType = pageInfo.createdSortType
    let queryParm = "currentPage=" + currentPage
    if(keyword != null) {
      queryParm += "&keyword=" + keyword  
    }
    if(createdSortType != null) {
      queryParm += "&order=" + createdSortType  
    }
    console.log(queryParm)
    try {
      const response = await apiService.get('/articles?'+queryParm);
      console.log(response.data)
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