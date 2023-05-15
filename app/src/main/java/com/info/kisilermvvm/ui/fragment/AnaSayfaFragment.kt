package com.info.kisilermvvm.ui.fragment

import android.os.Bundle

import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.kisilermvvm.R
import com.info.kisilermvvm.databinding.FragmentAnaSayfaBinding
import com.info.kisilermvvm.ui.adapter.KisilerAdapter
import com.info.kisilermvvm.ui.viewmodel.AnaSayfaViewModel
import com.info.kisilermvvm.utils.gecisyap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnaSayfaViewModel
    private  val adapter by lazy {
        KisilerAdapter(requireContext(), emptyList(), viewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false)
        binding.anaSayfaToolbarBaslik="Kisiler"
        binding.anaSayfaFragment=this
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnaSayfa)

        binding.rv.layoutManager=LinearLayoutManager(requireContext())

        observes()



        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_arama,menu)
                val item=menu.findItem(R.id.item_search)
                val searchView=item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnaSayfaFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)






        return binding.root
    }

    fun observes(){

        viewModel.kisilerLstesi.observe(viewLifecycleOwner){
            adapter.updateElements(it)
            binding.kisilerAdapter=adapter

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnaSayfaViewModel by viewModels()
        viewModel=tempViewModel
    }
    fun fabTikla(it:View){
        Navigation.gecisyap(it,R.id.kisiKayitGecis)
    }


    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }


    override fun onResume() {
        super.onResume()
        viewModel.kisilerYukle()
    }


}
