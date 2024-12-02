package ar.com.expensas.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ar.com.expensas.data.ExpenseManager
import ar.com.expensas.data.ExpenseRepoImpl
import ar.com.expensas.getColorsTheme
import ar.com.expensas.presentation.ExpensesViewModel
import ar.com.expensas.ui.ExpensesDetailScreen
import ar.com.expensas.ui.ExpensesScreen
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun Navigator(navigator: Navigator) {
    val colors = getColorsTheme()
    val viewModel = viewModel(modelClass = ExpensesViewModel::class) {
        ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
    }
    NavHost(
        modifier = Modifier.background(colors.backgroundColor),
        navigator = navigator,
        initialRoute = "/home"
    ) {
        scene(route = "/home") {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ExpensesScreen(uiState) { expense ->
                navigator.navigate("/addExpenses/${expense.id}")
            }
        }
        scene(route = "/addExpenses/{id}?") { backStackEntry ->
            val idFromPath = backStackEntry.path<Long>("id")
            val expenseToEditOrAdd = idFromPath?.let { id -> viewModel.getExpenseWithID(id) }
            ExpensesDetailScreen(
                expenseToEdit = expenseToEditOrAdd,
                categoryList = viewModel.getCategories()
            ) { expense ->
                if (expenseToEditOrAdd == null) {
                    viewModel.addExpense(expense)
                } else {
                    viewModel.editExpense(expense)
                }
                navigator.popBackStack()
            }
        }
    }

}