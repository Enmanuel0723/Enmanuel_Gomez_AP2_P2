package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases

import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.GastoRepository
import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetGastosUseCase @Inject constructor(
    private val repo: GastoRepository,
) {
    operator fun invoke(): Flow<Resource<List<Gasto>>> = flow {
        emit(Resource.Loading())
        val repoResponse = repo.getGastos()
        emit(Resource.Success(repoResponse.data ?: emptyList()))
    }
}