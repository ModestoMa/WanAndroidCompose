package me.robbin.net.api

import me.robbin.net.model.*
import retrofit2.http.*


/**
 * Description.
 * @author: Created by Robbin in 2021/4/6
 */
interface WanApi {

    // ******************** 用户相关 ********************
    /**
     * 用户登录
     * <br>Created by Robbin in 2020/7/10
     */
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): ApiResponse<User>

    /**
     * 用户注册
     * <br>Created by Robbin in 2020/7/10
     */
    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): ApiResponse<User>

    /**
     * 用户注销
     * <br>Created by Robbin in 2021/3/29
     */
    @GET("user/logout/json")
    suspend fun logout(): ApiResponse<Any?>

    // ******************** 收藏相关 ********************
    /**
     * 站内收藏文章列表
     * <br>Created by Robbin in 2020/7/30
     */
    @GET("lg/collect/list/{page}/json")
    suspend fun collectArticles(
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<Collect>>>

    /**
     * 收藏网址列表
     * <br>Created by Robbin in 2020/7/30
     */
    @GET("lg/collect/usertools/json")
    suspend fun userCollectArticles(): ApiResponse<MutableList<CollectUrl>>

    /**
     * 收藏站内文章
     * <br>Created by Robbin in 2020/7/31
     */
    @POST("lg/collect/{id}/json")
    suspend fun collect(
        @Path("id") id: Int
    ): ApiResponse<Any?>

    /**
     * 收藏站外文章
     * <br>Created by Robbin in 2020/7/31
     */
    @POST("lg/collect/add/json")
    suspend fun collectCustom(
        @Query("title") title: String,
        @Query("author") author: String,
        @Query("link") link: String
    ): ApiResponse<Collect>

    /**
     * 收藏网址
     * <br>Created by Robbin in 2021/3/29
     */
    @POST("lg/collect/addtool/json")
    suspend fun collectUrl(
        @Query("name") name: String,
        @Query("link") link: String
    ): ApiResponse<CollectUrl>

    /**
     * 编辑收藏网址
     * <br>Created by Robbin in 2021/3/29
     */
    @POST("lg/collect/updatetool/json")
    suspend fun editCollectUrl(
        @Query("id") id: Int,
        @Query("name") name: String,
        @Query("link") link: String
    )

    /**
     * 根据文章 ID 取消收藏
     * <br>Created by Robbin in 2020/7/31
     */
    @POST("lg/uncollect_originId/{id}/json")
    suspend fun uncollect(
        @Path("id") id: Int
    ): ApiResponse<Any?>

    /**
     * 根据收藏 ID 取消收藏
     * @param id 要取消收藏的文章的 ID
     * @param originId
     * @author Created by Robbin in 2020/7/31
     */
    @POST("lg/uncollect/{id}/json")
    suspend fun uncollectCustom(
        @Path("id") id: Int,
        @Query("originId") originId: Int
    ): ApiResponse<Any?>

    /**
     * 根据 ID 取消收藏网址
     * @param id 要取消收藏的网址的 ID
     * @author Created by Robbin in 2021/3/29
     */
    @POST("lg/collect/deletetool/json")
    suspend fun uncollectUrl(
        @Query("id") id: Int
    ): ApiResponse<Any?>

    // ******************** 首页相关 ********************
    /**
     * 首页文章列表
     * @param page 文章列表的页数
     * @return 首页文章列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("article/list/{page}/json")
    suspend fun homeArticles(
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<Article>>>

    /**
     * 置顶文章列表
     * @return 置顶文章列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("article/top/json")
    suspend fun topArticles(): ApiResponse<MutableList<Article>>

    /**
     * 首页 Banner 列表
     * @return 首页 Banner 列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("banner/json")
    suspend fun banners(): ApiResponse<MutableList<Banner>>

    /**
     * 常用网站列表
     * @return 常用网站列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("friend/json")
    suspend fun friendSite(): ApiResponse<MutableList<FriendSite>>

    /**
     * 搜素热词
     * @return 搜索热词列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("hotkey/json")
    suspend fun hotKey(): ApiResponse<MutableList<HotKey>>

    // ******************** 知识体系相关 ********************
    /**
     * 知识体系列表
     * @return 知识体系列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("tree/json")
    suspend fun tree(): ApiResponse<MutableList<Chapter>>

    /**
     * 知识体系文章列表
     * @param page 文章列表的页数
     * @param cid 知识体系 ID
     * @return 知识体系文章列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("article/list/{page}/json")
    suspend fun treeArticles(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): ApiResponse<ApiPageResponse<MutableList<Article>>>

    /**
     * 根据作者昵称获取文章列表
     * @param page 文章列表的页数
     * @param author 要获取的作者的昵称
     * @return 特定作者文章列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("article/list/{page}/json")
    suspend fun authorArticles(
        @Path("page") page: Int,
        @Query("author") author: String
    ): ApiResponse<ApiPageResponse<Article>>

    // ******************** 导航相关 ********************
    /**
     * 导航数据
     * @return 导航列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("navi/json")
    suspend fun navigations(): ApiResponse<MutableList<Navigation>>

    // ******************** 项目相关 ********************
    /**
     * 项目分类
     * @return 项目分类列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("project/tree/json")
    suspend fun projectTree(): ApiResponse<MutableList<Chapter>>

    /**
     * 特定项目文章列表
     * @param page 文章列表的页数
     * @param cid 分类 ID
     * @return 文章列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("project/list/{page}/json")
    suspend fun projects(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): ApiResponse<ApiPageResponse<MutableList<Article>>>

    // ******************** 搜索相关 ********************
    /**
     * 根据关键词搜索
     * @param page 获取文章列表的页数
     * @param k 要检索的关键字
     * @return 搜索结果
     * @author Created by Robbin in 2021/3/29
     */
    @GET("article/query/{page}/json")
    suspend fun search(
        @Path("page") page: Int,
        @Query("k") k: String
    ): ApiResponse<ApiPageResponse<MutableList<Article>>>

    // ******************** 积分相关 ********************
    /**
     * 获取积分排行榜，page 从 1 开始
     * @param page 积分排行榜列表的页数
     * @return 积分排行榜列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("coin/rank/{page}/json")
    suspend fun coinRank(
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<Integral>>>

    /**
     * 个人积分详细
     * @return 个人积分详细
     * @author Created by Robbin in 2021/3/29
     */
    @GET("lg/coin/userinfo/json")
    suspend fun myCoin(): ApiResponse<Integral>

    /**
     * 获取个人积分获取详情
     * @param page 要获取的详细列表的页数
     * @return 个人积分获取详情列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("lg/coin/list/{page}/json")
    suspend fun coinList(
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<Integral>>>

    // ******************** 广场相关 ********************
    /**
     * 广场文章列表
     * @param page 文章列表的页数
     * @return 广场文章列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("user_article/list/{page}/json")
    suspend fun userArticles(
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<Article>>>

    /**
     * 根据用户 ID 获取分享文章列表，page 从 1 开始
     * @param id 要获取的用户的 ID
     * @param page 文章列表的页数
     * @return 特定用户分享的文章列表
     * @author Created by Robbin in 2021/3/29
     */
    @GET("user/{id}/articles/{page}/json")
    suspend fun userArticles(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<UserPage>>>

    /**
     * 获取自己分享的文章
     * @param page 文章列表的页数
     * @return 自己分享的文章
     * @author Created by Robbin in 2021/3/29
     */
    @GET("user/lg/private_articles/{page}/json")
    suspend fun myArticles(
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<Article>>>

    /**
     * 删除自己的文章
     * @param id 要删除的文章的 ID
     * @author Created by Robbin in 2021/3/29
     */
    @POST("lg/user_article/delete/{id}/json")
    suspend fun deleteMyArticle(
        @Path("id") id: Int
    ): ApiResponse<Any?>

    /**
     * 分享文章
     * @param title 要分享的文章的标题
     * @param link 要分享的文章的链接
     * @return 返回新添加的文章的相关信息
     * @author Created by Robbin in 2021/3/29
     */
    @POST("lg/user_article/add/json")
    suspend fun shareArticle(
        @Query("title") title: String,
        @Query("link") link: String
    ): ApiResponse<Article>

    // ******************** 问答相关 ********************
    /**
     * 获得每日一问列表
     * @param page 每日一问列表的页面号，从 1 开始
     * @return 返回每日一问文章列表
     * @author Created by Robbin in 2021/03/30
     */
    @GET("wenda/list/{page}/json")
    suspend fun question(
        @Path("page") page: Int
    ): ApiResponse<ApiPageResponse<MutableList<Article>>>

    // ******************** TODO相关 ********************
    /**
     * 新增一个Todo
     * @param title 新增标题，必填
     * @param content 新增内容，必填
     * @param date 预定完成时间，默认为当天，可自行添加
     * @param type 类型，大于 0 的整数
     * @param priority 优先级，大于 0 的整数
     * @return 返回新增注释相关信息
     * @author Created by Robbin in 2021/03/30
     */
    @POST("lg/todo/add/json")
    @FormUrlEncoded
    suspend fun addTodo(
        @Field("title") title: String,
        @Field("content") content: String,
        @Field("date") date: Long,
        @Field("type") type: Int,
        @Field("priority") priority: Int
    ): ApiResponse<Todo>

    /**
     * 修改一个Todo
     * @param id 要修改的Todo的Id，必填
     * @param title 更新标题，必填
     * @param content 更新内容，必填
     * @param date 预计完成时间，必填
     * @param status 当前Todo状态，0为未完成，1为完成
     * @param type 类型
     * @param priority 优先级
     * @return 返回修改结果
     * @author Created by Robbin in 2021/03/30
     */
    @POST("lg/todo/update/{id}/json")
    @FormUrlEncoded
    suspend fun editTodo(
        @Path("id") id: Int,
        @Field("title") title: String,
        @Field("content") content: String,
        @Field("date") date: Long,
        @Field("status") status: Int,
        @Field("type") type: Int,
        @Field("priority") priority: Int
    ): ApiResponse<Any?>

    /**
     * 删除一个Todo
     * @param id 要删除的Todo的Id
     * @author Created by Robbin in 2021/03/30
     */
    @POST("lg/todo/delete/{id}/json")
    suspend fun deleteTodo(
        @Path("id") id: Int
    ): ApiResponse<Any?>

    /**
     * 更新指定Todo的状态
     * @param id 要更新的Todo的Id
     * @param status 要更新成的状态，0为未完成，1为完成
     * @author Created by Robbin in 2021/03/30
     */
    @POST("lg/todo/done/{id}/json")
    @FormUrlEncoded
    suspend fun updateTodoStatus(
        @Path("id") id: Int,
        @Field("status") status: Int
    ): ApiResponse<Any?>

    /**
     * 获得Todo列表
     * @param page 当前页数，从1开始
     * @param status 指定获取特定状态的Todo，默认为全都获取
     * @param type 指定获取特定类型的Todo，默认为全部获取
     * @param priority 指定获取特定优先级的Todo，默认为全部获取
     * @param orderby 指定获取的Todo的事件顺序，1.完成日期顺序；2.完成日期逆序；3.创建日期顺序；4.创建日期逆序(默认)
     * @return 返回Todo列表
     * @author Created by Robbin in 2021/03/30
     */
    @GET("lg/todo/v2/list/{page}/json")
    @FormUrlEncoded
    suspend fun todoList(
        @Path("page") page: Int,
        @Field("status") status: Int,
        @Field("type") type: Int,
        @Field("priority") priority: Int,
        @Field("orderby") orderby: Int
    ): ApiResponse<ApiPageResponse<MutableList<Todo>>>

}