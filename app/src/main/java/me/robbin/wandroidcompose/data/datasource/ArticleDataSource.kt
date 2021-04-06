package me.robbin.wandroidcompose.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import me.robbin.net.api.WanApi
import me.robbin.net.model.Article
import retrofit2.HttpException

/**
 * Description.
 * @author: Created by Robbin in 2021/4/6
 */
class ArticleDataSource(
    private val service: WanApi,
): PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 0
            val response = service.homeArticles(page)
            LoadResult.Page(
                data = response.data.datas,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.data.curPage == response.data.pageCount) null else page + 1
            )
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

}