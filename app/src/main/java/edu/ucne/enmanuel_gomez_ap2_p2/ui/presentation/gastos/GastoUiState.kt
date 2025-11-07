package edu.ucne.enmanuel_gomez_ap2_p2.ui.presentation.gastos

import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto

data class GastoUiState(
    val gastoId: Int? = null,
    val fecha: String? = null,
    val suplidor: String? = null,
    val ncf: String? = null,
    val itbis: Double? = 0.18,
    val monto: Double? = null,
    val isLoading: Boolean = false,
    val errorSuplidor: String? = null,
    val errorNcf: String? = null,
    val errorMonto: String? = null,
    val listaGastos: List<Gasto> = emptyList(),
    val showModal: Boolean = false
)
