package com.imecatro.disneycodechallenge_abdiel.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imecatro.disneycodechallenge_abdiel.databinding.FragmentConfirmationBinding
import com.imecatro.disneycodechallenge_abdiel.databinding.FragmentConflictPageBinding


class ConflictPageFragment : Fragment() {
    private var _binding: FragmentConflictPageBinding? = null
    private val binding get() = _binding!!

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConflictPageBinding.inflate(inflater, container, false)

        binding.conflictAlert.text = param1
        activity?.title = "Conflict Screen"

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val ARG_PARAM1 = "param1"

    }
}