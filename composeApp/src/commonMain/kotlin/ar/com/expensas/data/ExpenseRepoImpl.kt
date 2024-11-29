package ar.com.expensas.data

import ar.com.expensas.domain.ExpenseRepository
import ar.com.expensas.model.Expense
import ar.com.expensas.model.ExpenseCategory

class ExpenseRepoImpl(private val expenseManager: ExpenseManager) : ExpenseRepository {
    override fun getAllExpenses(): List<Expense> {
        return expenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        expenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editNewExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }

    override fun deleteExpense(expense: Expense): List<Expense> {
        return expenseManager.deleteExpense(expense)
    }
}