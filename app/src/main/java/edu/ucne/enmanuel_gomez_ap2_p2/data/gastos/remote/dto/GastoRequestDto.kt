package edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto

data class GastoRequestDto(
    val fecha: String,
    val suplidor: String,
    val ncf: String,
    val itbis: Double,
    val monto: Double,
)