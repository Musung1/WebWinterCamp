import React, { useEffect, useState } from 'react';
import {login} from "../../api/UserAPI"
import { useNavigate } from 'react-router-dom';
function Login() {
    const navigate = useNavigate();
  return (
    <div>
        <h1>로그인 페이지</h1>
        <input type="text" id="id" name="title" placeholder="아이디를 입력하세요"></input>
        <input type="text" id="pw" name="title" placeholder="비밀번호를 입력하세요"></input>
        <br></br>
        <button onClick={async (event)=> {
                    let loginForm = {
                        id: String(document.getElementById("id").value),
                        pw: String(document.getElementById("pw").value),
                    }
                event.preventDefault()
                try {
                    await login(loginForm)
                    alert("로그인 성공")
                    navigate("/")
                } catch (error) {
                    alert("로그인 실패")
                }
            }}>작성 완료</button>
        <button onClick={()=> {
            navigate('/signup')
        }}>회원가입</button>
    </div>
  );
};

export default Login;
