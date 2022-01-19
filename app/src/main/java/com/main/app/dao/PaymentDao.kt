package com.main.app.dao

import androidx.room.Dao
import androidx.room.Query
import com.main.app.models.Payment
import java.util.*

@Dao
interface PaymentDao {

     fun insert(payment: Payment)

    @Query("Select * from PaymentHistory order by id desc")
     fun getAllPayments(): ArrayList<Payment>
}