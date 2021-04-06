package me.robbin.wandroidcompose.ui.widget

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import me.robbin.wandroidcompose.ui.theme.WanTheme

/**
 * Description.
 * @author: Created by Robbin in 2021/3/31
 */
@Composable
fun WanScaffold(content: @Composable () -> Unit) {
    WanTheme() {
        Surface(color = Color.White) {
            content()
        }
    }
}
