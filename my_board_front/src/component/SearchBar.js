import { useState } from "react";
import articleStore from "../store/store";

export default function SearchBar() {
    let {pageInfo,getPagedArticles,updatePageInfo} = articleStore();
    let [checkboxState, setCheckboxState] = useState(true);
    const fetchAll = () => {
        let pageInfoDTO = {
            currentPage: pageInfo.currentPage,
            keyword: pageInfo.option.keyword,
            createdSortType : pageInfo.option.createdSortType
        }
        getPagedArticles(pageInfoDTO)
    }
    const checkboxClick = (sortType) => {
        if(sortType == "ASC") {
            setCheckboxState(true)
            updatePageInfo({createdSortType:"ASC"})
            fetchAll()
            
        } else {
            setCheckboxState(false)
            updatePageInfo({createdSortType:"DES"})
            fetchAll()
        }
    }
    return (
        <div>
            <input type="text" id="search" name="search" placeholder="검색어를 입력하세요"></input>
            <button onClick={async (event)=> {
                updatePageInfo({keyword:String(document.getElementById("search").value)})
                fetchAll()
                event.preventDefault()
            }}>검색하기</button>
            <br></br>
            생성일 기준
            <br></br>
            오름 차순
            <input
                type="checkbox"
                checked={checkboxState}
                onChange={()=> checkboxClick("ASC")}
            />
            내림 차순
            <input
                type="checkbox"
                checked={!checkboxState}
                onChange={()=> checkboxClick("DES")}
            />
            
        </div>
    );
}