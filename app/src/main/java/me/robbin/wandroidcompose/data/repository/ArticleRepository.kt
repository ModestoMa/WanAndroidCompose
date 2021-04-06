package me.robbin.wandroidcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import me.robbin.net.api.WanService
import me.robbin.wandroidcompose.data.datasource.ArticleDataSource

/**
 * Description.
 * @author: Created by Robbin in 2021/4/6
 */
object ArticleRepository {

    fun homeArticles() =
        Pager(PagingConfig(pageSize = 20, enablePlaceholders = false)) {
            ArticleDataSource(WanService.getApi())
        }.flow

}