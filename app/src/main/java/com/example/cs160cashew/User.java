package com.example.cs160cashew;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name = "default";
    private BankAccount bankAccount = new BankAccount();
    private List<Budget> budgetList = new ArrayList<Budget>();


    User(String s){
        name = s;
        budgetList.add(new Budget("Food Budget", new Category("testCategory"), 300));
        budgetList.add(new Budget("Miscellaneous", new Category("testCategory2"), 500));
    }

    public void addBudget(Budget b){
        budgetList.add(b);
    }

    public String getName(){
        return name;
    }

    public List getBudgetList(){
        return budgetList;
    }

}
