package me.robbin.net.model

import com.squareup.moshi.JsonClass

/**
 * 服务器返回数据基类
 * @author Create by Robbin at 2020/7/10
 */
interface IBaseResponse<T> {
    fun code(): Int
    fun msg(): String
    fun data(): T
    fun isSuccess(): Boolean
}

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(val data: T, val errorCode: Int, val errorMsg: String) :
    IBaseResponse<T> {

    override fun code(): Int = errorCode

    override fun msg(): String = errorMsg

    override fun data(): T = data

    override fun isSuccess(): Boolean = errorCode == 0

}

@JsonClass(generateAdapter = true)
data class ApiPageResponse<T>(
    var curPage: Int,
    var datas: T,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int
)