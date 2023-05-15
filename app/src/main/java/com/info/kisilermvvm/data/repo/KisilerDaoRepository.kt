package com.info.kisilermvvm.data.repo


import androidx.lifecycle.MutableLiveData
import com.info.kisilermvvm.data.entity.Kisiler
import com.info.kisilermvvm.room.KisilerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisilerDaoRepository(var kdao:KisilerDao) {

    var kisilerListesi:MutableLiveData<List<Kisiler>> = MutableLiveData()
    fun kisilerGetir():MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }


    fun kisiKayit(kisi_ad:String,kisi_tel:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi=Kisiler(0,kisi_ad,kisi_tel)
            kdao.kisiEkle(yeniKisi)

        }

    }
    fun kisiGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val guncelenenKisi=Kisiler(kisi_id,kisi_ad,kisi_tel)
            kdao.kisiGuncelle(guncelenenKisi)
        }


    }
    fun kisiAra(aramaKelime:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value=kdao.kisiAra(aramaKelime)


        }

    }
    fun kisiSil(kisi_id: Int){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi=Kisiler(kisi_id,"","")
            kdao.kisiSil(silinenKisi)
            tumKisilerAl()

        }





    }
    fun tumKisilerAl(){

         val job= CoroutineScope(Dispatchers.Main).launch{
             kisilerListesi.value=kdao.tumKisiler()


         }

    }


}