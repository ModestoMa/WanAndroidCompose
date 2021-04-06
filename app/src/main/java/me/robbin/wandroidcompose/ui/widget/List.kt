package me.robbin.wandroidcompose.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import me.robbin.net.api.WanService
import me.robbin.net.model.Article
import me.robbin.wandroidcompose.data.datasource.ArticleDataSource

/**
 * Description.
 * @author: Created by Robbin in 2021/4/6
 */
@Composable
fun HomeArticles() {

    Box {
        val articleDataSource = remember { ArticleDataSource(WanService.getApi()) }
        val pager = remember {
            Pager(
                PagingConfig(
                    pageSize = 20,
                    enablePlaceholders = false
                )
            ) {
                articleDataSource
            }
        }
        val lazyPagingItems: LazyPagingItems<Article> = pager.flow.collectAsLazyPagingItems()
        LazyColumn {
            itemsIndexed(lazyPagingItems = lazyPagingItems) { index, item ->
                if (item != null) {
                    ArticleItem(article = item)
                }
            }
        }
    }

}