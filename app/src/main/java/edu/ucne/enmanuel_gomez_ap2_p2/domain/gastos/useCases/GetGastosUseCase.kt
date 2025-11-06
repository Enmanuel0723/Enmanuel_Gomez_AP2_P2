package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases

import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoResponseDto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.GastoRepository
import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGastosUseCase @Inject constructor(
    private val repo: GastoRepository
) {
    operator fun invoke(): Flow<Resource<List<Gasto>>> = flow {
        var mensaje = ""
        emit(Resource.Loading())
        try {
            val repoResponse = repo.getGastos()
            mensaje = repoResponse.message ?: ""
            emit(Resource.Success(repoResponse.data?.map { it.toDomain() } ?: emptyList()))
        } catch (e: Exception) {
            emit(Resource.Error(mensaje, emptyList()))
        }
    }
}

fun GastoResponseDto.toDomain() = Gasto(
    gastoId,
    fecha,
    suplidor,
    ncf,
    itbis,
    monto
)