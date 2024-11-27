package ar.com.expensas.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.expensas.getColorsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpensesScreen() {
    val colors = getColorsTheme()
    LazyColumn(
        modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(
            16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        stickyHeader {
            Column(modifier = Modifier.background(colors.backgroundColor)) {
                ExpensesTotalHeader(10.000)
                AllExpensesHeader()
            }
        }
        items(emptyList<String>()) {

        }
    }
}

@Composable
fun ExpensesTotalHeader(total: Double) {
    val colors = getColorsTheme()
    Card(shape = RoundedCornerShape(30), backgroundColor = colors.black, elevation = 5.dp) {
        Box(
            modifier = Modifier.fillMaxWidth().height(130.dp).padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "$$total",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colors.white
            )
            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = "USD",
                color = colors.gray
            )
        }
    }
}

@Composable
fun AllExpensesHeader() {
    val colors = getColorsTheme()
    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Todos los gastos",
            fontWeight = FontWeight.ExtraBold,
            color = colors.textColor,
            fontSize = 20.sp,
        )
        Button(
            onClick = { onclickButton() },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = colors.lightGray),
            enabled = false
        ) { Text("Ver todo") }
    }
}

fun onclickButton() {

}