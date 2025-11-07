package edu.ucne.enmanuel_gomez_ap2_p2.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.enmanuel_gomez_ap2_p2.ui.presentation.gastos.GastoScreen

@Composable
fun NavHost() {
    NavHost(
        navController = rememberNavController(),
        startDestination = Screen.Gastos
    ) {
        composable<Screen.Gastos> {
            GastoScreen()
        }
    }
}