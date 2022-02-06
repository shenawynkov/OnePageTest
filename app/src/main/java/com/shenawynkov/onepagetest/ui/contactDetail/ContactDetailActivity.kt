package com.shenawynkov.onepagetest.ui.contactDetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.shenawynkov.domain.model.contact.ContactX
import com.shenawynkov.onepagetest.R
import com.shenawynkov.onepagetest.databinding.ActivityContactDetailBinding
import com.shenawynkov.onepagetest.databinding.ActivityMainBinding
import com.shenawynkov.onepagetest.ui.contacts.ContactsAdapter
import com.shenawynkov.onepagetest.ui.contacts.ContactsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactDetailActivity : AppCompatActivity() {
    companion object {
        val CONTACT = "contact"
    }

    lateinit var viewModel: ContactDetailViewModel
    lateinit var binding: ActivityContactDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()

    }


    private fun setUp() {
        //viewmodel
        viewModel = ViewModelProvider(this)[ContactDetailViewModel::class.java]
        viewModel.contact.value = intent.getParcelableExtra<ContactX>(CONTACT)

        //binding
        binding = DataBindingUtil.setContentView<ActivityContactDetailBinding>(
            this@ContactDetailActivity,
            R.layout.activity_contact_detail
        )
        binding.viewmodel=viewModel
        binding.lifecycleOwner = this

        //init views
        binding.rvPhone.apply {
            layoutManager = LinearLayoutManager(this@ContactDetailActivity)
            adapter = viewModel.contact.value?.phones?.let { PhoneAdapter(it) }
        }

        Glide.with(this).load(viewModel.contact.value?.photo_url).into(binding.ivPhote)
    }
}