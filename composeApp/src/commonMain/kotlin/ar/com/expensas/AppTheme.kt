package ar.com.expensas

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp)
        )
    ) {
        content()
    }
}

@Composable
fun getColorsTheme(): ModeColors {
    val isDarkMode = false

    val purple = Color(0xFF6A66FF)
    val black = Color.Black
    val white = Color.White
    val gray = Color.Gray
    val lightGray = Color.LightGray
    val colorExpenseItem = if (isDarkMode) Color(0xFF090808) else Color(0xFFF1F1F1)
    val backgroundColor = if (isDarkMode) Color(0xFF1E1C1C) else Color.White
    val textColor = if (isDarkMode) Color.White else Color.Black
    val addIconColor = if (isDarkMode) purple else Color.Black
    val colorArrowRound = if (isDarkMode) purple else Color.Gray.copy(alpha = .2f)

    return ModeColors(
        purple = purple,
        colorExpenseItem = colorExpenseItem,
        backgroundColor = backgroundColor,
        textColor = textColor,
        addIconColor = addIconColor,
        colorArrowRound = colorArrowRound,
        black = black,
        gray = gray,
        lightGray = lightGray,
        white = white
    )
}

data class ModeColors(
    val purple: Color,
    val colorExpenseItem: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val addIconColor: Color,
    val colorArrowRound: Color,
    val black: Color,
    val gray: Color,
    val white: Color,
    val lightGray: Color,
)