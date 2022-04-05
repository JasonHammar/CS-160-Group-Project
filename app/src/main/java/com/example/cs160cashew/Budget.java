package com.example.cs160cashew;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private Name name;
    private List<Category> categoryList = new ArrayList<Category>();
    private Limit limit;

    Budget(Name n, Category c, Limit l){
        name = n;
        categoryList.add(c);
        limit = l;
    }

    Budget(Name n, Limit l){
        name = n;
        limit = l;
    }

    public void addCategory(Category c){
        categoryList.add(c);
    }

    public String getName(){
        return name.getName();
    }

    public int getLimit(){
        return limit.getAmount();
    }
}
