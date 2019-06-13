package com.firebase.architecture

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firebase.architecture.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_dialog.*
import kotlinx.android.synthetic.main.my_dialog.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var mobileViewModel: MobileViewModel

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

        mobileViewModel = ViewModelProviders
            .of(this)
            .get(MobileViewModel::class.java)
        mobileViewModel.getAllMobile().observe(this, Observer {
            adapter.clear()
            adapter.addAll(it)
            adapter.notifyDataSetChanged()
        })

        btnAdd.setOnClickListener {
            showAddMobileDialog()
        }
    }

    private fun showAddMobileDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog, viewGroup, false)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        builder.setTitle("Add mobile")
        builder.setPositiveButton("OK") { _, _ ->
            mobileViewModel.addMobile(dialogView.edtName.text.toString())
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}
