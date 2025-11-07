package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Gasto(
    val gastoId: Int = 0,
    val fecha: String = LocalDateTime.now().toString(),
    val suplidor: String = "",
    val ncf: String = "",
    val itbis: Double = 0.18,
    val monto: Double = 0.0,
)