package edu.ucne.enmanuel_gomez_ap2_p2.data.gastos

import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoRequestDto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.GastoRepository
import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource
import javax.inject.Inject

class GastoRepositoryImpl @Inject constructor(
    private val remote: GastoRemoteDataSource,
) : GastoRepository {
    override suspend fun getGastos(): Resource<List<Gasto>> {
        val response = remote.getGastos()
        println(response.message)
        return Resource.Success(response.data?.map { it.toDomain() } ?: emptyList())
    }

    override suspend fun crearGasto(req: Gasto): Resource<Unit> {
        val response = remote.crearGastos(
            GastoRequestDto(
                req.fecha,
                req.suplidor,
                req.ncf,
                req.itbis,
                req.monto
            )
        )
        return Resource.Success(response.data ?: Unit)
    }

    override suspend fun findGasto(id: Int): Resource<Gasto> {
        val response = remote.findGasto(id)

        return when (response) {
            is Resource.Error ->
                Resource.Error(response.message ?: "")

            is Resource.Loading ->
                Resource.Loading()

            is Resource.Success ->
                Resource.Success(response.data?.toDomain() ?: Gasto())
        }
    }
}