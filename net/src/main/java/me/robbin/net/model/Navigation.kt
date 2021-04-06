package me.robbin.net.model

import me.robbin.net.model.Article

/**
 * 导航
 * Created by Robbin on 2020-07-21
 */
data class Navigation(
    private var articles: MutableList<Article>,
    private var cid: Int,
    private var name: String
)