package com.firebase.architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot

class MobileRepository {

    var firebaseRepository = FirestoreRepository()
    var allMobile: MutableLiveData<List<String>> = MutableLiveData()

    fun getAllMobile(): LiveData<List<String>> {
        firebaseRepository.getAllMobile().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                allMobile.value = null
                return@EventListener
            }

            val savedAddressList: MutableList<String> = mutableListOf()
            for (doc in value!!) {
                val addressItem = doc.data.values.toString()
                savedAddressList.add(addressItem)
            }
            allMobile.value = savedAddressList
        })

        return allMobile
    }
}