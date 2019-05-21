package com.firebase.architecture

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MobileViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: MobileRepository = MobileRepository()
    private var allMobile: LiveData<List<String>> = repository.getAllMobile()

    fun getAllMobile(): LiveData<List<String>> {
        return allMobile
    }

}