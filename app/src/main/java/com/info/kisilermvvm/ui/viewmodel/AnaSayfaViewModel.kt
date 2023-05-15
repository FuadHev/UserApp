package com.info.kisilermvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.info.kisilermvvm.data.entity.Kisiler
import com.info.kisilermvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor(var krepo: KisilerDaoRepository):ViewModel() {

    var kisilerLstesi=MutableLiveData<List<Kisiler>>()
    init {
        kisilerYukle()
        kisilerLstesi =krepo.kisilerGetir()
    }
    fun ara(aramaKelime:String){
        krepo.kisiAra(aramaKelime)

    }
    fun sil(kisi_id:Int){
        krepo.kisiSil(kisi_id)

    }
    fun kisilerYukle(){
        krepo.tumKisilerAl()
    }

}