package com.example.wereldapps.ui.indo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wereldapps.R
import com.example.wereldapps.data.response.IndonesiaResponseItem
import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.databinding.FragmentIndonesiaBinding
import com.example.wereldapps.ui.detail.DetailIndoActivity
import com.example.wereldapps.ui.detail.DetailNegaraActivity
import com.example.wereldapps.ui.negara.NegaraAdapter
import com.example.wereldapps.ui.negara.NegaraViewModel
import com.example.wereldapps.utils.OnItemClickCallbackIndonesia
import com.example.wereldapps.utils.OnItemClickCallbackNegara

class IndonesiaFragment : Fragment() {

    private var _binding: FragmentIndonesiaBinding? = null
    private val binding get() = _binding as FragmentIndonesiaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentIndonesiaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[IndonesiaViewModel::class.java]

        viewModel.apply {
            getListIndonesia()
            getResultIndonesia().observe(viewLifecycleOwner) {
                binding.rvIndonesia.apply {
                    adapter = IndonesiaAdapter(it)
                    layoutManager = LinearLayoutManager(requireContext())
                    val mAdapter = IndonesiaAdapter(it)
                    adapter = mAdapter
                    mAdapter.setOnItemClickCallback(object : OnItemClickCallbackIndonesia {
                        override fun onItemClicked(item: IndonesiaResponseItem) {
                            val intent = Intent(requireContext(), DetailIndoActivity::class.java)
                                .putExtra(DetailIndoActivity.EXTRA_DATA, item)
                            startActivity(intent)
                        }
                    })
                }
            }
        }
    }
}