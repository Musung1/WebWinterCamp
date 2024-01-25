import React, { useEffect, useState } from 'react';
import {loginTest} from "../../api/UserAPI"
function LoginTest() {
    let [loginState,setLoginState] = useState("로그인 X")
    useEffect(()=> {
        async function fetchData() {
            try {
                await loginTest()
                setLoginState("로그인 OK")
            } catch(e) {
                setLoginState("로그인 X")
            }
        } fetchData();
    })
  return (
    <div>
        <h1>로그인 상태</h1>
        <h1>{loginState}</h1>
        <button onClick={async()=> {
            try {
                await loginTest()
                setLoginState("로그인 OK")
            } catch(e) {
                setLoginState("로그인 X")
            }
        }}>update</button>
    </div>
  );
};

export default LoginTest;
