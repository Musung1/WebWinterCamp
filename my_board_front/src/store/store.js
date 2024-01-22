import { create } from 'zustand' // create로 zustand를 불러옵니다.
import { getAllArticles,createArticle,updateArticle, deleteArticle,getPagedArticles1 } from '../api/TbBoardAPI'
const articleStore = create(set => ({
  pageInfo: {},
  articles: [{}],
  addArticle: async (writeForm) => {
    await createArticle(writeForm);
  },
  updateArticle: async (updateForm) => {
    await updateArticle(updateForm)
  },
  deleteArticle: async (id) => {
    await deleteArticle(id)
  },
  getPagedArticles: async (pageInfoDTO) => {
    console.log(pageInfoDTO)
    let pagedArticles = await getPagedArticles1(pageInfoDTO);
    set({
      pageInfo: {
        totalPage: pagedArticles.totalPage,
        currentPage: pagedArticles.currentPage,
        pageSize: pagedArticles.pageSize,
        option: {
          keyword: pagedArticles.option.keyword,
          createdSortType: pagedArticles.option.createdSortType
        }
      },
      articles: pagedArticles.elements
    })
  },
  updatePageInfo: (newKeyword) =>
    set((state) => (
      state.pageInfo.option = {
        ...state.pageInfo.option,
        ...newKeyword,
      }
    )),
}))

export default articleStore