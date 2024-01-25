import React, { useState } from 'react';

function Signup() {
  return (
    <div>
        <h1>회원가입 페이지 </h1>
        <input placeholder='아이디를 입력하세요'></input>
        <input placeholder='비밀번호를 입력하세요'></input>
        <br></br>
        <button>회원가입</button>
    </div>
  );
};

export default Signup;
