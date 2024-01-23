import {Link} from 'react-router-dom';
function Home() {
    return (
        <div>
            <h1>홈 화면입니다</h1>
            <Link to="/articles">게시판가기</Link>
            <Link to="/upload">파일 업로드</Link>
        </div>
    );
}
export default Home;