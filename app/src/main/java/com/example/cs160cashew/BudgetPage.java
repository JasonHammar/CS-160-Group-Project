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
    private MySecondAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Budget budget;
    TextView budgetLimit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_layout);


        Intent intentApp = getIntent();
        budget = intentApp.getParcelableExtra("budgetItem");

        TextView welcomeText = (TextView) findViewById(R.id.WelcomeText);
        budgetLimit = (TextView) findViewById(R.id.budgetLimit);

        welcomeText.setText(budget.getName());
        budgetLimit.setText("$" + budget.amountSpent() + " / $" + budget.getLimit());

        budgetListRecyclerView = (RecyclerView) findViewById(R.id.my_budget_list);

        budgetListRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        budgetListRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MySecondAdapter(budget.getCategoryList());

        budgetListRecyclerView.setAdapter(mAdapter);

        Button addButton = (Button) findViewById(R.id.addCategoryButton);
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


        Button editButton = (Button) findViewById(R.id.editBudget);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(BudgetPage.this).create();
                alertDialog.setTitle("Edit Budget");

                LinearLayout layout1 = new LinearLayout(BudgetPage.this);
                layout1.setOrientation(LinearLayout.VERTICAL);
                final EditText input = new EditText(BudgetPage.this);
                final EditText input2 = new EditText(BudgetPage.this);



                input.setHint(budget.getName());
                input2.setHint(Integer.toString(budget.getLimit()));




                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input2.setInputType(InputType.TYPE_CLASS_NUMBER);




                layout1.addView(input);
                layout1.addView(input2);
                alertDialog.setView(layout1);



                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(!TextUtils.isEmpty(input.getText().toString())){
                            budget.setName(input.getText().toString());
                            welcomeText.setText(budget.getName());
                        }
                        if(!TextUtils.isEmpty(input2.getText().toString())){
                            budget.setLimit(Integer.parseInt(input2.getText().toString()));
                            budgetLimit.setText("$" + budget.getLimit());
                        }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 333 && resultCode == Activity.RESULT_OK){
            mAdapter.onActivityResult(requestCode, resultCode, data);
            budgetListRecyclerView.setAdapter(mAdapter);
            budgetLimit.setText("$" + budget.amountSpent() + " / $" + budget.getLimit());
        }


        mAdapter.onActivityResult(requestCode, resultCode, data);
        budgetListRecyclerView.setAdapter(mAdapter);
    }



}


