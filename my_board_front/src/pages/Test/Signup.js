import React, { useState } from 'react';
import {signup} from "../../api/UserAPI"
import { useNavigate } from 'react-router-dom';
function Signup() {
    const navigate = useNavigate();
  return (
    <div>
        <h1>로그인 페이지</h1>
        <input type="text" id="userName" name="title" placeholder="이름을 입력하세요"></input>
        <br></br>
        <input type="text" id="id" name="title" placeholder="아이디를 입력하세요"></input>
        <br></br>
        <input type="text" id="pw" name="title" placeholder="비밀번호를 입력하세요"></input>
        <br></br>
        <button onClick={async (event)=> {
                    let signupForm = {
                        name: String(document.getElementById("userName").value),
                        id: String(document.getElementById("id").value),
                        pw: String(document.getElementById("pw").value),
                    }
                event.preventDefault()
                try {
                    await signup(signupForm)
                } catch (error) {
                    alert("회원가입 실패")
                }
                alert("회원가입 성공")
                navigate("/login")
            }}>회원 가입하기</button>
    </div>
  );
};

export default Signup;
