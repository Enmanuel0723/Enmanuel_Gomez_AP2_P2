package edu.ucne.enmanuel_gomez_ap2_p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.enmanuel_gomez_ap2_p2.ui.presentation.navigation.NavHost
import edu.ucne.enmanuel_gomez_ap2_p2.ui.theme.Enmanuel_Gomez_AP2_P2Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Enmanuel_Gomez_AP2_P2Theme {
                NavHost()
            }
        }
    }
}