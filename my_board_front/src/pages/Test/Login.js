import React, { useState } from 'react';

function Login() {
  return (
    <div>
        <h1>로그인 페이지</h1>
        <input placeholder='아이디를 입력하세요'></input>
        <input placeholder='비밀번호를 입력하세요'></input>
        <br></br>
        <button>로그인</button>
        <button>회원가입</button>
    </div>
  );
};

export default Login;
