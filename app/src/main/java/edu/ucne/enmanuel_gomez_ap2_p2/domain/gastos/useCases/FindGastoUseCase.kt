package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases

import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.GastoRepository
import javax.inject.Inject

class FindGastoUseCase @Inject constructor(
    private val repo: GastoRepository
) {
    suspend operator fun invoke(id: Int) = repo.findGasto(id)
}