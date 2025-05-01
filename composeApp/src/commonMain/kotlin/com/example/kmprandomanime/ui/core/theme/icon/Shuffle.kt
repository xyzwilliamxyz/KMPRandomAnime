package com.example.kmprandomanime.ui.core.theme.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Icons.Shuffle: ImageVector
	get() {
		if (_Shuffle != null) {
			return _Shuffle!!
		}
		_Shuffle = ImageVector.Builder(
            name = "Shuffle",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
			path(
    			fill = SolidColor(Color.Black),
    			fillAlpha = 1.0f,
    			stroke = null,
    			strokeAlpha = 1.0f,
    			strokeLineWidth = 1.0f,
    			strokeLineCap = StrokeCap.Butt,
    			strokeLineJoin = StrokeJoin.Miter,
    			strokeLineMiter = 1.0f,
    			pathFillType = PathFillType.NonZero
			) {
				moveTo(14.83f, 13.41f)
				lineTo(13.42f, 14.82f)
				lineTo(16.55f, 17.95f)
				lineTo(14.5f, 20f)
				horizontalLineTo(20f)
				verticalLineTo(14.5f)
				lineTo(17.96f, 16.54f)
				lineTo(14.83f, 13.41f)
				moveTo(14.5f, 4f)
				lineTo(16.54f, 6.04f)
				lineTo(4f, 18.59f)
				lineTo(5.41f, 20f)
				lineTo(17.96f, 7.46f)
				lineTo(20f, 9.5f)
				verticalLineTo(4f)
				moveTo(10.59f, 9.17f)
				lineTo(5.41f, 4f)
				lineTo(4f, 5.41f)
				lineTo(9.17f, 10.58f)
				lineTo(10.59f, 9.17f)
				close()
			}
		}.build()
		return _Shuffle!!
	}

private var _Shuffle: ImageVector? = null
