package com.info.kisilermvvm.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.info.kisilermvvm.R

fun Navigation.gecisyap(it:View,id:Int){
    findNavController(it).navigate(id)
}
fun Navigation.gecisyap(it:View,id:NavDirections){
    findNavController(it).navigate(id)
}