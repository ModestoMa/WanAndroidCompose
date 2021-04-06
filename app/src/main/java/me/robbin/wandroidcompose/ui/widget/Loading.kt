package me.robbin.wandroidcompose.ui.widget

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

/**
 * Description.
 * @author: Created by Robbin in 2021/4/6
 */
@Composable
fun CircleLoading(
    modifier: Modifier = Modifier
) {

    val circleAnimateTween by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(3000), RepeatMode.Restart)
    )

    Row(
        modifier = modifier
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Outlined.Refresh,
            contentDescription = "Refresh",
            modifier = Modifier.rotate(circleAnimateTween)
        )
    }

}