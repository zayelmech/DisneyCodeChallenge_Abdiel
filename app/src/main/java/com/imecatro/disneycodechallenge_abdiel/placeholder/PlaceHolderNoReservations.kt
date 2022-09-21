package com.imecatro.disneycodechallenge_abdiel.placeholder


import com.imecatro.disneycodechallenge_abdiel.model.Guest
import java.util.HashMap
import kotlin.collections.ArrayList

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 */
object PlaceHolderNoReservations {

    /**
     * An array of sample (placeholder) items.
     */
    val GUEST_WITHOUT_RESERVATION : MutableList<Guest> = ArrayList()
    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, Guest> = HashMap()

    private val COUNT = 4

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: Guest) {
        GUEST_WITHOUT_RESERVATION.add(item)
        ITEM_MAP.put(item.guestName, item)
    }

    private fun createPlaceholderItem(position: Int): Guest {
        return Guest( false,"Guest Without Reservation" +  makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Number ").append(position)
//        for (i in 0..position - 1) {
//            builder.append("\nMore details information here.")
//        }
        return builder.toString()
    }

}