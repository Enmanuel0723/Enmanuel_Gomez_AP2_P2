package edu.ucne.enmanuel_gomez_ap2_p2.data.gastos

import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoResponseDto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto

fun GastoResponseDto.toDomain() = Gasto(
    gastoId,
    fecha,
    suplidor,
    ncf,
    itbis,
    monto
)