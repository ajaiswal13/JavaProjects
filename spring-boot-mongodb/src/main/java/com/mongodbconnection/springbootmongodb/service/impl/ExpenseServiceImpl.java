package com.mongodbconnection.springbootmongodb.service.impl;

import com.mongodbconnection.springbootmongodb.model.Expense;
import com.mongodbconnection.springbootmongodb.repository.ExpenseRepository;
import com.mongodbconnection.springbootmongodb.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    @Override
    public void updateExpense(Expense expense) {
        Expense expense1 = expenseRepository.findById(expense.getId()).orElseThrow(()-> new RuntimeException("Expense not found"));
        expense1.setExpenseAmount(expense.getExpenseAmount());
        expense1.setExpenseName(expense.getExpenseName());
        expense1.setExpenseCategory(expense.getExpenseCategory());
        expenseRepository.save(expense1);
    }


    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(()-> new RuntimeException("Expense not found"));
    }

    @Override
    public void deleteExpense(String id) {
        Expense expense1 = expenseRepository.findById(id).orElseThrow(()-> new RuntimeException("Expense not found"));
        expenseRepository.deleteById(id);
    }
}
