package com.shenawynkov.onepagetest.ui.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shenawynkov.domain.model.contact.ContactX;
import com.shenawynkov.onepagetest.R;
import com.shenawynkov.onepagetest.databinding.ActivityMainBinding;
import com.shenawynkov.onepagetest.ui.contactDetail.ContactDetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ContactsActivity extends AppCompatActivity implements ContactsAdapter.ContactsListener {
    private ContactsViewModel viewModel;
    private ActivityMainBinding binding;
    private ContactsAdapter adapter;

    @Inject
    ContactsViewModelFactory factory;

    @Override
    public void onSectionSelected(@NonNull ContactX contact) {
        Intent intent=new Intent(this, ContactDetailActivity.class);
        intent.putExtra(ContactDetailActivity.Companion.getCONTACT(),contact);
        startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
    }
    private void setUp()
    {
        //viewmodel
        viewModel= new ViewModelProvider(this,factory).get(ContactsViewModel.class);
        viewModel.updateContacts();
        //binding
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);

        //init views
        adapter=new ContactsAdapter(new ArrayList<ContactX>(),this);
        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));
        binding.rvContacts.setAdapter(adapter);
        //observers
        viewModel.getContacts().observe(this, new Observer<List<ContactX>>() {
            @Override
            public void onChanged(List<ContactX> contactXES) {
                adapter.setNewList(contactXES);

            }
        });
        viewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(ContactsActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
