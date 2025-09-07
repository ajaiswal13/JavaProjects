package com.mongodbconnection.springbootmongodb.service;

import com.mongodbconnection.springbootmongodb.model.Expense;

import java.util.List;

public interface ExpenseService {
    public void addExpense(Expense expense);
    public void updateExpense(Expense expense);
    public List<Expense> getAllExpenses();
    public Expense getExpenseByName(String name);
    public void deleteExpense(String id);
}
