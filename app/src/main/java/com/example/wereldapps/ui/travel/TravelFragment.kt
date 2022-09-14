package com.example.wereldapps.ui.travel

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wereldapps.data.response.TravelResponseItem
import com.example.wereldapps.databinding.FragmentTravelBinding
import com.example.wereldapps.ui.detail.DetailTravelActivity
import com.example.wereldapps.utils.OnItemClickCallbackTravel
import kotlinx.coroutines.delay

class TravelFragment : Fragment() {

    private var _binding: FragmentTravelBinding? = null
    private val binding get() = _binding as FragmentTravelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTravelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[TravelViewHolder::class.java]

        viewModel.apply {
            getListTravel()
            getResultTravel().observe(viewLifecycleOwner) {
                binding.rvTravel.apply {
                    adapter = TravelAdapter(it)
                    layoutManager = LinearLayoutManager(requireContext())
                    val mAdapter = TravelAdapter(it)
                    adapter = mAdapter
                    mAdapter.setOnItemClickCallback(object : OnItemClickCallbackTravel {
                        override fun onItemClicked(item: TravelResponseItem) {
                            val intent = Intent(requireContext(), DetailTravelActivity::class.java)
                                .putExtra(DetailTravelActivity.EXTRA_DATA, item)
                            startActivity(intent)
                        }
                    })
                }
            }
        }
    }
}