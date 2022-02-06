package com.shenawynkov.onepagetest.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.shenawynkov.onepagetest.R;
import com.shenawynkov.onepagetest.databinding.ActivityLoginBinding;
import com.shenawynkov.onepagetest.ui.contacts.ContactsActivity;


import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;

    @Inject
    LoginViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUp();

        if (viewModel.isUserLoggedIn())
            moveToContacts();
    }

    private void setUp() {
        //viewmodel
        viewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);

        //binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);


        //observers

        viewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        viewModel.getLoginStatus().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean b) {
                if (b) {
                    moveToContacts();
                }

            }
        });
    }

    private void moveToContacts() {
        Intent intent = new Intent(LoginActivity.this, ContactsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}