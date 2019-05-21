package com.firebase.architecture

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreRepository {

    var firestoreDB = FirebaseFirestore.getInstance()

    fun getAllMobile(): CollectionReference {
        return firestoreDB.collection("mobile")
    }

}
