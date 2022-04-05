package com.example.cs160cashew;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name = "default";
    private BankAccount bankAccount = new BankAccount();
    private List<Budget> budgetList = new ArrayList<Budget>();


    User(String s){
        name = s;
        budgetList.add(new Budget(new Name("Food Budget"), new Category("testCategory"), new Limit(300)));
        budgetList.add(new Budget(new Name("Miscellaneous"), new Category("testCategory2"), new Limit(500)));
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
