package com.info.kisilermvvm.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.info.kisilermvvm.R
import com.info.kisilermvvm.data.entity.Kisiler
import com.info.kisilermvvm.databinding.CardTasarimiBinding
import com.info.kisilermvvm.ui.fragment.AnaSayfaFragmentDirections
import com.info.kisilermvvm.ui.viewmodel.AnaSayfaViewModel
import com.info.kisilermvvm.utils.gecisyap

class KisilerAdapter(var mContext: Context,
                     var kisilerList:List<Kisiler>,
                     var viewModel: AnaSayfaViewModel):RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(tasarim:CardTasarimiBinding):RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimiBinding
        init {
            this.tasarim=tasarim
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim:CardTasarimiBinding=DataBindingUtil.inflate(layoutInflater,
            R.layout.card_tasarimi,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi=kisilerList[position]
        val t=holder.tasarim
        t.kisiNesnesi=kisi
        t.satirCard.setOnClickListener {
           val gecis=AnaSayfaFragmentDirections.kisiDetayGecis(kisi=kisi)
            Navigation.gecisyap(it,gecis)



        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} Silinsinmi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(kisi.kisi_id)

                }.show()
        }


    }

    override fun getItemCount(): Int {
        return kisilerList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateElements(kisilerList: List<Kisiler>){
        this.kisilerList = kisilerList
        notifyDataSetChanged()
    }

}