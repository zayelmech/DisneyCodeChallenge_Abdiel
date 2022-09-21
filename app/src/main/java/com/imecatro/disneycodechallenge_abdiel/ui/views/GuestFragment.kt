package com.imecatro.disneycodechallenge_abdiel.ui.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.imecatro.disneycodechallenge_abdiel.adapter.GuestRecyclerViewAdapter
import com.imecatro.disneycodechallenge_abdiel.R
import com.imecatro.disneycodechallenge_abdiel.databinding.FragmentItemListBinding
import com.imecatro.disneycodechallenge_abdiel.placeholder.PlaceHolderNoReservations
import com.imecatro.disneycodechallenge_abdiel.placeholder.PlaceholderReservations
import com.imecatro.disneycodechallenge_abdiel.ui.viewmodel.GuestViewModel
import com.imecatro.disneycodechallenge_abdiel.utils.CustomSnackbar

/**
 * A fragment representing a list of Items.
 */
class GuestFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[GuestViewModel::class.java]
    }

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        // Set the adapters
        with(binding) {
            firstList.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = GuestRecyclerViewAdapter(
                    PlaceholderReservations.GUEST_WITH_RESERVATION,
                    ::onItemWithReservationClicked
                )
            }
            secondList.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = GuestRecyclerViewAdapter(
                    PlaceHolderNoReservations.GUEST_WITHOUT_RESERVATION,
                    ::onItemWithoutReservationClicked
                )
            }
        }
        activity?.title = "Select Guests"
        return binding.root
    }

    private fun onItemWithReservationClicked(index: Int, state: Boolean) {

        Log.d(
            "CLASS::${javaClass.simpleName}",
            "Guest with reservation ${index + 1} was set to $state"
        )
        viewModel.putGuestWithInvitation(index, state)
        Log.d(
            "CLASS::${javaClass.simpleName}",
            "Guest with reservation TRUE are ${viewModel.nGuestsWithReservation}"
        )
        nextFragment()
    }

    private fun onItemWithoutReservationClicked(index: Int, state: Boolean) {
        Log.d(
            "CLASS::${javaClass.simpleName}",
            "Guest without reservation ${index + 1} was set to $state"
        )
        viewModel.putGuestWithoutInvitation(index, state)
        Log.d(
            "CLASS::${javaClass.simpleName}",
            "Guest without reservation TRUE are ${viewModel.nGuestsWithoutReservation}"
        )
        nextFragment()
    }


    private fun nextFragment() {

        val nGuestWithoutReservation = viewModel.nGuestsWithoutReservation
        val nGuestWithReservation = viewModel.nGuestsWithReservation

        if ((nGuestWithoutReservation + nGuestWithReservation) > 0) {

            binding.actionBtn.apply {
                isClickable = true
                setBackgroundColor(getColor(context, R.color.clickable_btn_true))
            }
        } else {
            binding.actionBtn.apply {
                isClickable = false
                setBackgroundColor(getColor(context, R.color.clickable_btn_false))
            }
        }

        binding.actionBtn.setOnClickListener {
            if (nGuestWithReservation > 0 && nGuestWithoutReservation == 0) {
                findNavController().navigate(R.id.action_guestFragment_to_confirmationFragment)

            } else if (nGuestWithReservation > 0 && nGuestWithoutReservation > 0) {
                findNavController().navigate(
                    R.id.action_guestFragment_to_conflict_page, bundleOf(
                        Pair(ConflictPageFragment.ARG_PARAM1, "We are working on")
                    )
                )

            } else if (nGuestWithReservation == 0 && nGuestWithoutReservation > 0) {
                view?.let { view ->
                    CustomSnackbar(
                        view,
                        getString(R.string.reservations_alert)
                    ).showAlertSnackbar()
                }
            } else {
                Log.d(
                    "CLASS::${javaClass.simpleName}",
                    "YOU MUST CHECK AT LEAST ONE ITEM"
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}