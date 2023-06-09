package com.info.kisilermvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.info.kisilermvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor (var krepo: KisilerDaoRepository): ViewModel() {
    fun kayit(kisi_ad:String,kisi_tel:String){
        krepo.kisiKayit(kisi_ad,kisi_tel)

    }
}