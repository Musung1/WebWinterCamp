import React from "react";
import {useNavigate} from 'react-router-dom';
import articleStore from "../store/store";
// 게시글 작성 화면
function Write(props) {
    const navigate = useNavigate();

    const goBack = () => {
      navigate('/articles')
    }
    let {articles, addArticle,fetchArticles} = articleStore();
    return (
        <div>
            <h2>게시글 작성하기</h2>
            <h1><label>title(3~15자)</label></h1>
            <input type="text" id="title" name="title" placeholder="제목을 입력하세요"></input>
            <h1><label>content(5~500자)</label></h1>
            <textarea type="text" id="body" name="body" placeholder="내용을 입력하세요"></textarea>
            <br></br>
            <button onClick={async (event)=> {
                    let writeForm = {
                        title: String(document.getElementById("title").value),
                        content: String(document.getElementById("body").value),
                    }
                event.preventDefault()
                console.log(writeForm)
                try {
                    await addArticle(writeForm)
                } catch (error) {
                    alert("유효성 검사 에러")
                }
                goBack()
            }}>작성 완료</button>
        </div>
    )
}
export default Write;