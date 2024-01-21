import React, { useState } from "react";
import {Link, useParams,useNavigate} from 'react-router-dom';
import articleStore from "../store/store";
function Update() {
    let id = useParams().id;
    let article = articleStore((state)=> state.articles.find((p)=> p.id == id));
    let {updateArticle} = articleStore();
    let [title, setTitle] = useState(article.title);
    let [content, setContent] = useState(article.content);
    const navigate = useNavigate();

    const goBack = () => {
      navigate('/articles')
    }
    const onChangeTitle = (event) => {
        const value = event.target.value;
        setTitle(value)
      };
      const onChangeContnet = (event) => {
        const value = event.target.value;
        setContent(value)
      };
      const onClick = async () => {
        let updateForm = {
            id: String(id),
            title: String(title),
            content: String(content)
        }
        await updateArticle(updateForm);
        goBack();
      }
    return (
        <div>
            <h2>게시글 수정하기</h2>
            <h1><label id="title">title</label></h1>
            <input type="text" id="title" name="title" value={title} onChange={onChangeTitle}></input>
            <h1><label id="body">content</label></h1>
            <textarea type="text" id="body" name="body" value={content} onChange={onChangeContnet}></textarea>
            <br></br>
            <button onClick={onClick}>작성 완료</button>
        </div>
    )
}
export default Update;