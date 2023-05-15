package com.info.kisilermvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.info.kisilermvvm.data.entity.Kisiler


@Database(entities =[Kisiler::class],version=1)
abstract class Veriabani:RoomDatabase() {
    abstract fun getKisilerDao():KisilerDao
}