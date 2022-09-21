package com.imecatro.disneycodechallenge_abdiel.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.imecatro.disneycodechallenge_abdiel.model.Guest
import com.imecatro.disneycodechallenge_abdiel.placeholder.PlaceHolderNoReservations
import com.imecatro.disneycodechallenge_abdiel.placeholder.PlaceholderReservations

class GuestViewModel(
    private val guestWithReservationRepo: MutableList<Guest> = PlaceholderReservations.GUEST_WITH_RESERVATION,
    private val guestWithoutReservationRepo: MutableList<Guest> = PlaceHolderNoReservations.GUEST_WITHOUT_RESERVATION
) : ViewModel() {


    private var _nGuestsWithReservation: Int = 0
    private var _nGuestsWithoutReservation: Int = 0

    val nGuestsWithReservation get() = _nGuestsWithReservation
    val nGuestsWithoutReservation get() = _nGuestsWithoutReservation

    private val _guestsWithReservation: MutableList<Guest> = ArrayList()
    private val _guestsWithoutReservation: MutableList<Guest> = ArrayList()

    val guestWithReservation get() = _guestsWithReservation

    fun putGuestWithInvitation(index: Int, state: Boolean) {
        guestWithReservationRepo[index].guestCheck = state

        _guestsWithReservation.clear()

        guestWithReservationRepo.forEach { item ->
            if (item.guestCheck) {
                _guestsWithReservation.add(item)
            }
        }
        _nGuestsWithReservation = _guestsWithReservation.size
    }

    fun putGuestWithoutInvitation(index: Int, state: Boolean) {
        guestWithoutReservationRepo[index].guestCheck = state

        _guestsWithoutReservation.clear()

        guestWithoutReservationRepo.forEach { item ->
            if (item.guestCheck) {
                _guestsWithoutReservation.add(item)
            }
        }
        _nGuestsWithoutReservation = _guestsWithoutReservation.size
    }
}