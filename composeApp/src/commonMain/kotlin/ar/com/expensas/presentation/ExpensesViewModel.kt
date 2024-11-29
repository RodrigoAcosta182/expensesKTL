package ar.com.expensas.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.expensas.domain.ExpenseRepository
import ar.com.expensas.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ExpensesUiState(
    val expenses: List<Expense> = emptyList(),
    val total: Double = 0.0
)

class ExpensesViewModel(private val expenseRepository: ExpenseRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(ExpensesUiState())
    val uiState = _uiState.asStateFlow()
    private val allExpense = expenseRepository.getAllExpenses()

    init {
        getAllExpense()
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(expenses = allExpense, total = allExpense.sumOf { it.amount })
        }
    }

    private fun getAllExpense() {
        viewModelScope.launch {
            updateState()
        }
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.addExpense(expense)
            updateState()
        }
    }

    fun editExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.editExpense(expense)
            updateState()
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.deleteExpense(expense)
            updateState()
        }
    }

    fun getExpenseWithID(id: Long): Expense {
        return allExpense.first { it.id == id }
    }


}