package previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.expensas.data.ExpenseManager
import ar.com.expensas.model.Expense
import ar.com.expensas.model.ExpenseCategory
import ar.com.expensas.ui.AllExpensesHeader
import ar.com.expensas.ui.ExpensesItem
import ar.com.expensas.ui.ExpensesScreen
import ar.com.expensas.ui.ExpensesTotalHeader

@Preview(showBackground = true)
@Composable
fun ExpensesTotalHeaderPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        ExpensesTotalHeader(20.000)
    }

}

@Preview(showBackground = true)
@Composable
fun AllExpensesHeaderPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        AllExpensesHeader()
    }
}

@Preview(showBackground = true)
@Composable
fun ExpensesItemPreview() {
    val expense = ExpenseManager.fakeExpenseList[0]
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        ExpensesItem(expense = expense, onExpenseClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ExpensesScreenPreview() {
    ExpensesScreen(onExpenseClick={})
}