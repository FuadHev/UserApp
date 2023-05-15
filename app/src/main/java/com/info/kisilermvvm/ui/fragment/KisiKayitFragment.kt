package com.info.kisilermvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.info.kisilermvvm.R
import com.info.kisilermvvm.databinding.FragmentKisiKayitBinding
import com.info.kisilermvvm.ui.viewmodel.KisiKayitViewModel
import com.info.kisilermvvm.utils.gecisyap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var binding:FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false)

        binding.kisiKayitToolbarBaslik="Kisi Kayit"
        binding.kisiKayitFragment=this



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun buttonKaydet(it:View,kisi_ad:String,kisi_tel:String){
        viewModel.kayit(kisi_ad,kisi_tel)
        Navigation.gecisyap(it,R.id.anaSayfaGecis)

    }

}