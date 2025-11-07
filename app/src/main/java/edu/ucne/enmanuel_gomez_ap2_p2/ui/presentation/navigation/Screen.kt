package edu.ucne.enmanuel_gomez_ap2_p2.ui.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Gastos : Screen()
}