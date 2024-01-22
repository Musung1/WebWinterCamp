import articleStore from "../store/store";
import React, { useEffect, useState } from 'react';
import { Link } from "react-router-dom";
function List() {
    let {articles,getPagedArticles} = articleStore();
    let count = 1;
    function ListItems() {
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
        getPagedArticles(1);
    },[getPagedArticles]);
    return (
        <div>
            <h1>게시판입니다</h1>
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
function PageNavigator() {
    let {pageInfo,getPagedArticles} = articleStore();
    const onClick = (pageNum) => {
        getPagedArticles(pageNum)
        console.log("hello")
    }
    const generateButtons = () => {
        const buttons = [];
        for (let i = 1; i <= pageInfo.totalPage; i++) {
            let style = {}
            if (i == pageInfo.currentPage) {
                style = {backgroundColor: "blue"}
            }
            buttons.push(
                <button 
                onClick={()=>onClick(i)}
                key={i} 
                style={style}>{i}</button>
            );
        }
        return buttons;
    };
    return (
        <div>
        <button onClick={()=>onClick(pageInfo.currentPage-1)} disabled={pageInfo.currentPage == 1}>
          이전 페이지
        </button>
        {generateButtons()}
        <button onClick={()=>onClick(pageInfo.currentPage+1)} disabled={pageInfo.currentPage == pageInfo.totalPage}>
          다음 페이지
        </button>
      </div>
    );
}
export default List;