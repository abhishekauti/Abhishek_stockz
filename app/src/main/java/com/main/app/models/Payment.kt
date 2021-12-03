package com.main.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PaymentHistory")
class Payment(val payment_id: String) {
    @PrimaryKey(autoGenerate = true) val id = 0

}