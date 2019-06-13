package com.firebase.architecture

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firebase.architecture.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val listMobile = ArrayList<Mobile>()
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            listMobile
        )
        binding.adapter = adapter

        val mobileViewModel = ViewModelProviders
            .of(this)
            .get(MobileViewModel::class.java)
        mobileViewModel.getAllMobile().observe(this, Observer {
            adapter.clear()
            adapter.addAll(it)
            adapter.notifyDataSetChanged()
        })

        btnAdd.setOnClickListener {
            mobileViewModel.addMobile("")
        }
    }
}
