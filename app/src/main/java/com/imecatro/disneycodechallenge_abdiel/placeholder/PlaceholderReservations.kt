package com.imecatro.disneycodechallenge_abdiel.placeholder

import com.imecatro.disneycodechallenge_abdiel.model.Guest
import java.util.HashMap
import kotlin.collections.ArrayList

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 */
object PlaceholderReservations {

    /**
     * An array of sample (placeholder) items.
     */
    val GUEST_WITH_RESERVATION: MutableList<Guest> = ArrayList()
    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, Guest> = HashMap()

    private val COUNT = 7

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: Guest) {
        GUEST_WITH_RESERVATION.add(item)
        ITEM_MAP.put(item.guestName, item)
    }

    private fun createPlaceholderItem(position: Int): Guest {
        return Guest( false,"Guest " +  makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Number ").append(position)

        return builder.toString()
    }

}