package me.robbin.wandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import me.robbin.wandroidcompose.ui.widget.CircleLoading
import me.robbin.wandroidcompose.ui.widget.HomeArticles
import me.robbin.wandroidcompose.ui.widget.WanScaffold

/**
 * Description.
 * @author: Created by Robbin in 2021/3/31
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WanScaffold {
                Column {
                    CircleLoading()
                    HomeArticles()
                }
            }
        }
    }
}