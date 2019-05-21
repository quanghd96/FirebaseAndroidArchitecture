package com.firebase.architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class MobileRepository {

    var allMobile: MutableLiveData<List<Mobile>> = MutableLiveData()

    fun getAllMobile(): LiveData<List<Mobile>> {
        FirebaseFirestore.getInstance().collection("mobile")
            .addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
                if (e != null) {
                    allMobile.value = null
                    return@EventListener
                }

                val savedAddressList: MutableList<Mobile> = mutableListOf()
                for (doc in value!!) {
                    val addressItem = doc.toObject(Mobile::class.java)
                    savedAddressList.add(addressItem)
                }
                allMobile.value = savedAddressList
            })

        return allMobile
    }

    fun addMobile(name: String) {
        FirebaseFirestore.getInstance().collection("mobile").document("name").set(name)
    }
}