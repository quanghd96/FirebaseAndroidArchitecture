package com.firebase.architecture

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MobileViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: MobileRepository = MobileRepository()
    private var allMobile: LiveData<List<Mobile>> = repository.getAllMobile()

    fun getAllMobile(): LiveData<List<Mobile>> {
        return allMobile
    }

}