package ar.com.expensas

import androidx.compose.runtime.*
import ar.com.expensas.data.ExpenseManager
import ar.com.expensas.data.ExpenseRepoImpl
import ar.com.expensas.presentation.ExpensesViewModel
import ar.com.expensas.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel



@Composable
fun App() {
    PreComposeApp {
        val viewModel = viewModel(modelClass = ExpensesViewModel::class) {
            ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        AppTheme {
            ExpensesScreen(
                uiState = uiState,
                onExpenseClick = {})
        }
    }

}