package com.example.cs160cashew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User("Test User");

        Button login = (Button) findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent loginIntent = null;

                try{
                    loginIntent = new Intent(view.getContext(), HomePage.class);
                    loginIntent.putExtra("user", user);
                   startActivity(loginIntent);


                }
                catch (Exception e) {

                    System.out.println(e);


                }
            }
        });
    }
}