package ar.com.expensas.data

import ar.com.expensas.model.Expense
import ar.com.expensas.model.ExpenseCategory

object ExpenseManager {
    private var currentId = 1L

    val fakeExpenseList = mutableListOf(
        Expense(
            id = currentId++,
            amount = 90000.0,
            category = ExpenseCategory.CAR,
            description = "Nafta"
        ),
        Expense(
            id = currentId++,
            amount = 10000.0,
            category = ExpenseCategory.SNACKS,
            description = "LAYS"
        ),
        Expense(
            id = currentId++,
            amount = 5000.0,
            category = ExpenseCategory.CAR,
            description = "Lavado"
        ),
        Expense(
            id = currentId++,
            amount = 10000.0,
            category = ExpenseCategory.COFFEE,
            description = "Cafe + Tostado"
        ),
        Expense(
            id = currentId++,
            amount = 4000.0,
            category = ExpenseCategory.OTHER,
            description = "Limpieza Casa"
        )
    )


    fun addNewExpense(expense: Expense) {
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editNewExpense(expense: Expense) {
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCategories(): List<ExpenseCategory> {
        return listOf(
            ExpenseCategory.CAR,
            ExpenseCategory.COFFEE,
            ExpenseCategory.OTHER,
            ExpenseCategory.SNACKS,
            ExpenseCategory.PARTY,
            ExpenseCategory.GROCERIES,
        )
    }

    fun deleteExpense(expense: Expense): List<Expense> {
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenseList.removeAt(index)
        }
        return fakeExpenseList
    }

}