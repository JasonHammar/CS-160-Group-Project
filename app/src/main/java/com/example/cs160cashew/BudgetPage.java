package com.example.cs160cashew;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.Inet4Address;

public class BudgetPage extends AppCompatActivity {
    private RecyclerView budgetListRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Budget budget;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_layout);



        Intent intentApp = getIntent();
        //Intent prog = getIntent();
        budget = intentApp.getParcelableExtra("budgetItem");
        //String progressOne;
        //progressOne = prog.getStringExtra("budgetProgress");
        double progress = budget.getProgress();

        //double progressTwo = Double.parseDouble(progressOne);
        Calendar c = Calendar.getInstance();
        // c.set(Calendar.DAY_OF_MONTH, 1);
        if(c.get(Calendar.DAY_OF_MONTH) == 1){
            budget.setProgress(budget.getLimit());
        }
        TextView welcomeText = (TextView) findViewById(R.id.WelcomeText);
        TextView budgetLimit = (TextView) findViewById(R.id.budgetLimit);
        TextView budgetProgress = (TextView) findViewById(R.id.budgetProgress);


        welcomeText.setText(budget.getName());
        budgetLimit.setText("$" + budget.getLimit());
        budgetProgress.setText(("Progress: $" + budget.getProgress()));


        budgetListRecyclerView = (RecyclerView) findViewById(R.id.my_budget_list);

        budgetListRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        budgetListRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MySecondAdapter(budget.getCategoryList());

        budgetListRecyclerView.setAdapter(mAdapter);

        Button addButton = (Button) findViewById(R.id.addCategoryButton);
        Button updateProgress = (Button) findViewById(R.id.updateProgress);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(BudgetPage.this).create();
                alertDialog.setTitle("Create A New Category");

                LinearLayout layout1 = new LinearLayout(BudgetPage.this);
                layout1.setOrientation(LinearLayout.VERTICAL);
                final EditText input = new EditText(BudgetPage.this);

                input.setHint("Category Name");

                input.setInputType(InputType.TYPE_CLASS_TEXT);


                layout1.addView(input);
                alertDialog.setView(layout1);

                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        budget.addCategory(new Category(input.getText().toString()));
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


        updateProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(BudgetPage.this).create();
                alertDialog.setTitle("How much money did you spend?");

                LinearLayout layout1 = new LinearLayout(BudgetPage.this);
                layout1.setOrientation(LinearLayout.VERTICAL);
                final EditText input = new EditText(BudgetPage.this);

                input.setHint("Money spent.");

                input.setInputType(InputType.TYPE_CLASS_NUMBER);


                layout1.addView(input);
                alertDialog.setView(layout1);

                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Update", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        budget.updateProgress(Double.parseDouble(input.getText().toString()));
                        budgetProgress.setText("Progress: $" + budget.getProgress());
                        budget.setProgress(budget.getProgress());
                        //budget.addCategory(new Category(input.getText()
                        // .toString()));
                        //budgetListRecyclerView.setAdapter(mAdapter);

                    }
                });


                alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialog.show();


            }
        });
        



        



        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK,
                        new Intent().putExtra("budgetItem", budget));
                finish();
            }
        });



    }



}
