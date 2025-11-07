package edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto

data class GastoResponseDto(
    val gastoId: Int,
    val fecha: String,
    val suplidor: String,
    val ncf: String,
    val itbis: Double,
    val monto: Double,
)
