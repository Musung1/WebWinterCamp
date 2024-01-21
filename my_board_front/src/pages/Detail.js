import React from "react";
import {Link, useParams, useNavigate} from 'react-router-dom';
import articleStore from "../store/store";
function Detail() {
    let id = useParams().id;
    let article = articleStore((state)=> state.articles.find((p)=> p.id == id));
    let {deleteArticle} = articleStore();
    const navigate = useNavigate();
    const goBack = () => {
      navigate('/articles')
    }
    return (
        <div>
            <h1>{article.title}</h1>
            <h3>{article.content}</h3>
            <Link to="/articles">돌아가기</Link>
            <Link to={"/articles/updateForm/" + id}>수정하기</Link>
            <button onClick={ async ()=> {
                await deleteArticle(id)
                goBack();
            }}>삭제하기</button>
        </div>
    );
}
export default Detail;