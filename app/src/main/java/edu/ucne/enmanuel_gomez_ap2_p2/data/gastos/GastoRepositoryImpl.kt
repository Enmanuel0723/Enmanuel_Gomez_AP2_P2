package edu.ucne.enmanuel_gomez_ap2_p2.data.gastos

import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoRequestDto
import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoResponseDto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.GastoRepository
import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource
import javax.inject.Inject

class GastoRepositoryImpl @Inject constructor(
    private val remote: GastoRemoteDataSource,
) : GastoRepository {
    override suspend fun getGastos(): Resource<List<GastoResponseDto>> {
        val response = remote.getGastos()
        return when (response) {
            is Resource.Error -> Resource.Error(
                response.message ?: "",
                emptyList()
            )

            is Resource.Loading -> Resource.Loading()
            is Resource.Success -> Resource.Success(response.data ?: emptyList())
        }
    }

    override suspend fun crearGasto(req: Gasto): Resource<Unit> {
        val response = remote.crearGastos(
            GastoRequestDto(
                req.gastoId,
                req.fecha,
                req.suplidor,
                req.ncf,
                req.itbis,
                req.monto
            )
        )
        return Resource.Success(response.data ?: Unit)
    }
}