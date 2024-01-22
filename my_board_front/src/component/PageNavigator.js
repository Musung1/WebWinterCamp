import articleStore from "../store/store";

export default function PageNavigator() {
    let {pageInfo,getPagedArticles} = articleStore();
    const onClick = (pageNum) => {
        getPagedArticles(pageNum)
    }
    const generateButtons = () => {
        const buttons = [];
        for (let i = 1; i <= pageInfo.totalPage; i++) {
            let style = {}
            if (i == pageInfo.currentPage) {
                style = {backgroundColor: "blue"}
            }
            buttons.push(
                <button 
                onClick={()=>onClick(i)}
                key={i} 
                style={style}>{i}</button>
            );
        }
        return buttons;
    };
    return (
        <div>
        <button onClick={()=>onClick(pageInfo.currentPage-1)} disabled={pageInfo.currentPage == 1}>
          이전 페이지
        </button>
        {generateButtons()}
        <button onClick={()=>onClick(pageInfo.currentPage+1)} disabled={pageInfo.currentPage == pageInfo.totalPage}>
          다음 페이지
        </button>
      </div>
    );
}