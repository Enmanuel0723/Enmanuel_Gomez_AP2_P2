package edu.ucne.enmanuel_gomez_ap2_p2.ui.presentation.gastos

import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto

interface GastoEvent {
    data class ChangeMonto(val monto: String) : GastoEvent
    data class ChangeNcf(val ncf: String) : GastoEvent
    data class ChangeSuplidor(val suplidor: String) : GastoEvent

    data object SaveGasto : GastoEvent
    data object LoadGastos : GastoEvent
    data object ShowModal : GastoEvent
    data object HideModal : GastoEvent
}