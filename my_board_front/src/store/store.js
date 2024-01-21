import { create } from 'zustand' // create로 zustand를 불러옵니다.
import { getAllArticles,createArticle,updateArticle, deleteArticle } from '../api/TbBoardAPI'
const articleStore = create(set => ({
  articles: [{}],
  addArticle: async (writeForm) => {
    await createArticle(writeForm);
  },
  fetchArticles: async () => {
    let cur = await getAllArticles();
    set({articles: cur})
  },
  updateArticle: async (updateForm) => {
    await updateArticle(updateForm)
  },
  deleteArticle: async (id) => {
    await deleteArticle(id)
  }
}))

export default articleStore