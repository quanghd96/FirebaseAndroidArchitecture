package com.firebase.architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firebase.architecture.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listMobile = ArrayList<Mobile>()
    lateinit var adapter: ArrayAdapter<Mobile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listMobile)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        lvMobile.adapter = adapter
//        binding.adapter = adapter
//        adapter.notifyDataSetChanged()

        val mobileViewModel = ViewModelProviders.of(this).get(MobileViewModel::class.java)
        mobileViewModel.getAllMobile().observe(this, Observer {
            adapter.clear()
            adapter.addAll(it)
            adapter.notifyDataSetChanged()
//            Toast.makeText(this, it.size.toString(), Toast.LENGTH_LONG).show()
        })
    }
}
