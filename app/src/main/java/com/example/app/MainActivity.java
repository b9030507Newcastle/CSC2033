package com.example.app;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginPage = findViewById(R.id.LoginViewBT);
        loginPage.setOnClickListener(this);
        Button registerPage = findViewById(R.id.RegistrationViewBT);
        registerPage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.LoginViewBT:
                replaceFragment(new loginFragment());
                break;
            case R.id.RegistrationViewBT:
                replaceFragment(new registrationFragment());
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.Account, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}