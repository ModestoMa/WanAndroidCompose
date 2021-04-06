package me.robbin.net.model

import com.squareup.moshi.JsonClass
import me.robbin.common.fromHtml
import me.robbin.common.removeAllBlank

/**
 * 文章
 * Created by Robbin on 2020-07-11
 */
@JsonClass(generateAdapter = true)
data class Article(
    var apkLink: String,
    var audit: Int,
    var author: String,
    var canEdit: Boolean,
    var chapterId: Int,
    var chapterName: String,
    var collect: Boolean,
    var courseId: Int,
    var desc: String,
    var descMd: String,
    var envelopePic: String,
    var fresh: Boolean,
    var host: String,
    var id: Int,
    var link: String,
    var niceDate: String,
    var niceShareDate: String,
    var origin: String,
    var prefix: String,
    var projectLink: String,
    var publishTime: Long,
    var realSuperChapterId: Int,
    var selfVisible: Int,
    var shareDate: Long,
    var shareUser: String,
    var superChapterId: Int,
    var superChapterName: String,
    var tags: MutableList<Tag>,
    var title: String,
    var type: Int,
    var userId: Int,
    var visible: Int,
    var zan: Int,
) {
    val realAuthor: String
        get() {
            if (author.isBlank() && shareUser.isBlank()) return "匿名"
            return if (author.isBlank()) shareUser else author
        }

    val projectPic: String
        get() {
            return this.envelopePic
        }

    val newTag: Boolean
        get() {
            return this.fresh
        }

    val topTag: Boolean
        get() {
            return this.type == 1
        }

    val haveTag: Boolean
        get() {
            return tags.isNotEmpty()
        }

    val allTag: MutableList<Tag>
        get() {
            return tags
        }

    val date: String
        get() {
            return this.niceDate
        }

    val realTitle: String
        get() {
            return this.title.fromHtml()
        }

    val realDesc: String
        get() {
            return this.desc.fromHtml().removeAllBlank(2)
        }

    val realChapter: String
        get() {
            return "${this.superChapterName}·${this.chapterName}"
        }

    var haveCollect: Boolean
        get() {
            return this.collect
        }
        set(value) {
            this.collect = value
        }

    fun sameId(article: Article): Boolean = this.id == article.id

    fun sameContent(article: Article): Boolean = this == article

}