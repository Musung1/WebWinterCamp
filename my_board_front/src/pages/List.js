import articleStore from "../store/store";
import React, { useEffect, useState } from 'react';
import { Link } from "react-router-dom";
function List() {
    let {articles, fetchArticles} = articleStore();
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
        fetchArticles();
        console.log(articles)
    },[fetchArticles]);

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
    const [data, setData] = useState([]);
    const [pageNumber, setPageNumber] = useState(1);
    const [totalPages, setTotalPages] = useState(0);
    const pageSize = 10; // 페이지당 아이템 수
    return (
        <div>
        <button disabled={pageNumber === 1}>
          이전 페이지
        </button>
        <span>
          페이지 {pageNumber} / {totalPages}
        </span>
        <button disabled={pageNumber === totalPages}>
          다음 페이지
        </button>
      </div>
    );
}
export default List;