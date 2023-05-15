package com.info.kisilermvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.info.kisilermvvm.R
import com.info.kisilermvvm.databinding.FragmentKisiDetayBinding
import com.info.kisilermvvm.ui.viewmodel.KisiDetayViewModel
import com.info.kisilermvvm.ui.viewmodel.KisiKayitViewModel
import com.info.kisilermvvm.utils.gecisyap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var binding:FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)
        binding.kisiDetayToolbarBaslik="Kisi detay"
        binding.kisiDetayFragment=this
        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenkisi=bundle.kisi
        binding.kisiNesnesi=gelenkisi




        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDetayViewModel by viewModels()
        viewModel=tempViewModel
    }
    fun buttonGuncelle(it:View,kisi_id:Int,kisi_ad:String,kisi_tel:String){
        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
        Navigation.gecisyap(it,R.id.detaytoanasayfa)


    }



}