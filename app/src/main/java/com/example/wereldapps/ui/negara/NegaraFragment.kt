package com.example.wereldapps.ui.negara

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wereldapps.R
import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.data.response.TravelResponseItem
import com.example.wereldapps.databinding.FragmentNegaraBinding
import com.example.wereldapps.ui.detail.DetailNegaraActivity
import com.example.wereldapps.ui.detail.DetailTravelActivity
import com.example.wereldapps.ui.travel.TravelAdapter
import com.example.wereldapps.utils.OnItemClickCallbackNegara
import com.example.wereldapps.utils.OnItemClickCallbackTravel

class NegaraFragment : Fragment() {

    private var _binding: FragmentNegaraBinding? = null
    private val binding get() = _binding as FragmentNegaraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNegaraBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[NegaraViewModel::class.java]

        viewModel.apply {
            getListNegara()
            getResultNegara().observe(viewLifecycleOwner) {
                binding.rvNegara.apply {
                    adapter = NegaraAdapter(it)
                    layoutManager = LinearLayoutManager(requireContext())
                    val mAdapter = NegaraAdapter(it)
                    adapter = mAdapter
                    mAdapter.setOnItemClickCallback(object : OnItemClickCallbackNegara {
                        override fun onItemClicked(item: NegaraResponseItem) {
                            val intent = Intent(requireContext(), DetailNegaraActivity::class.java)
                                .putExtra(DetailNegaraActivity.EXTRA_DATA, item)
                            startActivity(intent)
                        }
                    })
                }
            }
        }
    }
}