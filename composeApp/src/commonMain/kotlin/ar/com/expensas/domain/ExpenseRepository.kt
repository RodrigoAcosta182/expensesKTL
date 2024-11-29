package ar.com.expensas.domain

import ar.com.expensas.model.Expense
import ar.com.expensas.model.ExpenseCategory

interface ExpenseRepository {
    fun getAllExpenses() : List<Expense>
    fun addExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun getCategories(): List<ExpenseCategory>
    fun deleteExpense(expense: Expense): List<Expense>
}