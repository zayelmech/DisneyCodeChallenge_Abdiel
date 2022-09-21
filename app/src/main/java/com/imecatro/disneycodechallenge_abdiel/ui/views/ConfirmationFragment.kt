package com.imecatro.disneycodechallenge_abdiel.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.imecatro.disneycodechallenge_abdiel.adapter.ConfirmationRecyclerViewAdapter
import com.imecatro.disneycodechallenge_abdiel.databinding.FragmentConfirmationBinding
import com.imecatro.disneycodechallenge_abdiel.ui.viewmodel.GuestViewModel


class ConfirmationFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[GuestViewModel::class.java]
    }

    private var _binding: FragmentConfirmationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.confirmationList.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = ConfirmationRecyclerViewAdapter(viewModel.guestWithReservation)
        }
        activity?.title = "Confirmation Screen"

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}