import { create } from 'zustand' // create로 zustand를 불러옵니다.
import { getAllArticles,createArticle,updateArticle, deleteArticle,getPagedArticles } from '../api/TbBoardAPI'
const articleStore = create(set => ({
  pageInfo: {},
  articles: [{}],
  addArticle: async (writeForm) => {
    await createArticle(writeForm);
  },
  // fetchArticles: async () => {
  //   let cur = await getAllArticles();
  //   set({articles: cur})
  // },
  updateArticle: async (updateForm) => {
    await updateArticle(updateForm)
  },
  deleteArticle: async (id) => {
    await deleteArticle(id)
  },
  getPagedArticles: async (currentPage) => {
    let pagedArticles = await getPagedArticles(currentPage);
    set({
      pageInfo: {
        totalPage: pagedArticles.totalPage,
        currentPage: pagedArticles.currentPage,
        pageSize: pagedArticles.pageSize
      },
      articles: pagedArticles.elements
    })
  }
}))

export default articleStore