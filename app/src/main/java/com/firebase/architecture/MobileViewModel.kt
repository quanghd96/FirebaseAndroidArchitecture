package com.firebase.architecture

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MobileViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: MobileRepository = MobileRepository()

    fun getAllMobile(): LiveData<List<Mobile>> {
        return repository.getAllMobile()
    }

    fun addMobile(name: String) {
        repository.addMobile(name)
    }

}