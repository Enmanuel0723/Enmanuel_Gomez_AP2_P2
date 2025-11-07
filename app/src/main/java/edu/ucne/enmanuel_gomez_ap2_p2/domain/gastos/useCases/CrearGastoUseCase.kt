package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases

import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.GastoRepository
import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource
import edu.ucne.enmanuel_gomez_ap2_p2.utils.ValidationResult
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class CrearGastoUseCase @Inject constructor(
    private val repo: GastoRepository,
) {
    suspend operator fun invoke(req: Gasto): Resource<Unit> {
        val result = validarGasto(req)
        return when (result) {
            else -> if (!result.esValido)
                Resource.Error(result.error ?: "")
            else repo.crearGasto(req)
        }
    }
}