package me.robbin.net.model

import com.squareup.moshi.JsonClass

/**
 * 标签
 * Create by Robbin at 2020/7/11
 */
@JsonClass(generateAdapter = true)
data class Tag(
    var name: String,
    var url: String
) {
    val tagName: String
        get() {
            return this.name
        }
}