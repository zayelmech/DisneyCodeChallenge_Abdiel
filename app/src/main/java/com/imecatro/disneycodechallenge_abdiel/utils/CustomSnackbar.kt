package com.imecatro.disneycodechallenge_abdiel.utils

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.imecatro.disneycodechallenge_abdiel.R

class CustomSnackbar(
    private val view: View,
    private val text: String,
) {

    fun showAlertSnackbar() {

        Snackbar.make(view, text, Snackbar.LENGTH_LONG).apply {
            setBackgroundTint(ContextCompat.getColor(context, R.color.snackbar_background_color))
            setAction(" ") {
                this.dismiss()
            }
            val actionView =
                view.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
            actionView?.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_baseline_cancel_24,
                0,
                0,
                0
            )

            show()
        }
    }
}