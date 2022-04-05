package com.example.cs160cashew;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/*
public class BudgetPage extends AppCompatActivity {
    private RecyclerView budgetListRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Bundle budget;

        Intent intentApp = getIntent();
        budget = intentApp.getBundleExtra("bundle");
        budget.get("budget");

        TextView welcomeText = (TextView) findViewById(R.id.WelcomeText);
        welcomeText.setText();

        budgetListRecyclerView = (RecyclerView) findViewById(R.id.my_budget_list);

        budgetListRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        budgetListRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(user.getBudgetList());

        budgetListRecyclerView.setAdapter(mAdapter);

        Button addButton = (Button) findViewById(R.id.addBudgetButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(HomePage.this).create();
                alertDialog.setTitle("Create A New Budget");

                LinearLayout layout1 = new LinearLayout(HomePage.this);
                layout1.setOrientation(LinearLayout.VERTICAL);
                final EditText input = new EditText(HomePage.this);
                final EditText input2 = new EditText(HomePage.this);

                input.setHint("Budget Name");
                input2.setHint("Budget Limit");

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input2.setInputType(InputType.TYPE_CLASS_NUMBER);


                layout1.addView(input);
                layout1.addView(input2);
                alertDialog.setView(layout1);

                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        user.addBudget(new Budget(new Name(input.getText().toString()), new Limit(Integer.parseInt(input2.getText().toString()))));
                        budgetListRecyclerView.setAdapter(mAdapter);
                    }
                });


                alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialog.show();
            }
        });



    }

 */
