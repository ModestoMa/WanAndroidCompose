package me.robbin.wandroidcompose.ui.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.google.accompanist.coil.CoilImage
import me.robbin.net.model.Article
import me.robbin.wandroidcompose.R

/**
 * Description.
 * @author: Created by Robbin in 2021/4/2
 */
@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp, top = 3.dp, bottom = 3.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(size = 5.dp))
            .clickable(onClick = onClick)
            .padding(start = 5.dp, end = 5.dp, top = 3.dp, bottom = 3.dp)
    ) {

        val constraint = cardConstraints()

        ConstraintLayout(constraintSet = constraint) {
            CoilImage(
                data = article.projectPic,
                contentDescription = "Mu content description.",
                modifier = Modifier.layoutId("image")
            )
            val authorConstraint = authorConstrains()
            ConstraintLayout(
                constraintSet = authorConstraint,
                modifier = Modifier
                    .layoutId("author")
                    .fillMaxWidth()
            ) {
                Text(
                    text = article.realAuthor,
                    modifier = Modifier
                        .layoutId("authorStr")
                        .clip(shape = RoundedCornerShape(size = 5.dp))
                        .clickable { },
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.text_second)
                )
                Row(
                    modifier = Modifier.layoutId("tags")
                ) {
                    VisibleTag(
                        isVisible = article.topTag,
                        tagStr = stringResource(id = R.string.tag_top),
                        color = colorResource(id = R.color.tag_top)
                    )
                    VisibleTag(
                        isVisible = article.newTag,
                        tagStr = stringResource(id = R.string.tag_new),
                        color = colorResource(id = R.color.tag_new)
                    )
                    if (article.haveTag)
                        article.allTag.forEach {
                            VisibleTag(
                                isVisible = true,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(size = 5.dp))
                                    .clickable { },
                                tagStr = it.name,
                                color = colorResource(id = R.color.tag_new)
                            )
                        }
                }
                Text(
                    text = article.date,
                    modifier = Modifier.layoutId("date"),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.text_second)
                )
            }
            Column(
                modifier = Modifier.layoutId("content")
            ) {
                Text(
                    text = article.realTitle,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.text_primary),
                    maxLines = 1,
                    fontWeight = FontWeight.Bold
                )
                if (article.realDesc.isNotEmpty())
                    Text(
                        text = article.realDesc,
                        modifier = Modifier.padding(top = 3.dp),
                        fontSize = 13.sp,
                        color = colorResource(id = R.color.text_second),
                        maxLines = 3,
                        fontWeight = FontWeight.Bold
                    )
            }
            Row(
                modifier = Modifier.layoutId("chapter")
            ) {
                Text(
                    text = article.realChapter,
                    modifier = Modifier.weight(weight = 8.0F),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.text_third)
                )
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "collect",
                    modifier = Modifier
                        .weight(weight = 1.0F)
                        .height(20.dp)
                )
            }
        }

    }

}

private fun cardConstraints(): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val author = createRefFor("author")
        val content = createRefFor("content")
        val chapter = createRefFor("chapter")

        constrain(image) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        }
        constrain(author) {
            top.linkTo(parent.top)
            start.linkTo(image.end)
        }
        constrain(content) {
            top.linkTo(author.bottom)
            start.linkTo(image.end)
        }
        constrain(chapter) {
            top.linkTo(content.bottom, margin = 10.dp)
            start.linkTo(image.end)
        }
    }
}

private fun authorConstrains(): ConstraintSet {
    return ConstraintSet {
        val author = createRefFor("authorStr")
        val tags = createRefFor("tags")
        val date = createRefFor("date")

        constrain(author) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        }
        constrain(tags) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(author.end)
        }
        constrain(date) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }
    }
}

@Composable
fun VisibleTag(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    color: Color = Color.Blue,
    tagStr: String = stringResource(id = R.string.tag_new)
) {
    if (isVisible) {
        when (tagStr) {
            stringResource(id = R.string.tag_new), stringResource(id = R.string.tag_top) ->
                Text(
                    text = tagStr,
                    modifier = modifier.padding(start = 3.dp, end = 3.dp, top = 3.dp, bottom = 3.dp),
                    fontSize = 12.sp,
                    color = color
                )
            else ->
                Text(
                    text = tagStr,
                    modifier = modifier
                        .padding(start = 2.dp, end = 2.dp, top = 3.dp, bottom = 3.dp)
                        .border(width = 1.dp, color = color, shape = RoundedCornerShape(size = 3.dp))
                        .padding(start = 2.dp, end = 2.dp),
                    fontSize = 12.sp,
                    color = color
                )
        }
    }
}