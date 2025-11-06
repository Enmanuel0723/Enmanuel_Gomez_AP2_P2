package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos

data class Gasto(
    val gastoId: Int,
    val fecha: String,
    val suplidor: String,
    val ncf: String,
    val itbis: Int,
    val monto: Int,
)