import articleStore from "../store/store";
import React, { useEffect, useState } from 'react';
import { Link } from "react-router-dom";
import PageNavigator from "../component/PageNavigator";
import SearchBar from "../component/SearchBar";
function List() {
    let {articles,pageInfo,getPagedArticles} = articleStore();
    let count = 1;
    let ListItems= ()=> {
        return (
            articles.map((article) => 
            <tr key={count}>
            <td>{count++}</td>
            <td><Link to={"/articles/" + article.id}>{article.title}</Link></td>
            <td>{article.createAt}</td>
            <td>{article.views}</td>
        </tr>
        )
        );
    } 
    useEffect(()=> {
        let pageInfoDTO = {}
        console.log(articles)
        if(pageInfo.currentPage == null) {
            pageInfoDTO = {
                currentPage: 1,
                keyword: null,
                createdSortType : "ASC"
            }
        } else {
            pageInfoDTO = {
                currentPage: pageInfo.currentPage,
                keyword: pageInfo.option.keyword,
                createdSortType : pageInfo.option.createdSortType
            }
        }
        getPagedArticles(pageInfoDTO);
    },[getPagedArticles]);
    return (
        <div>
            <h1>게시판입니다</h1>
            <SearchBar/>
            <table>
                <thead>
                    <td>번호</td>
                    <td>제목</td>
                    <td>작성일</td>
                    <td>조회수</td>
                </thead>
                <tbody>
                    {ListItems()}
                </tbody>
            </table>
            <div>
            <PageNavigator/>
            <Link to="/writeForm">글 작성하기</Link>
            </div>
        </div>
    );
}
export default List;