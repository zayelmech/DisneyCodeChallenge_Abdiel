package com.imecatro.disneycodechallenge_abdiel.model

/**
 * A Guest item representing a piece of content.
 */

data class Guest(var guestCheck: Boolean, val guestName: String) {
    override fun toString(): String = guestName
}
