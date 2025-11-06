package edu.ucne.enmanuel_gomez_ap2_p2.data.gastos

import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.GastoApiService
import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoRequestDto
import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoResponseDto
import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource
import okio.IOException
import javax.inject.Inject

class GastoRemoteDataSource @Inject constructor(
    private val api: GastoApiService
) {
    suspend fun getGastos(): Resource<List<GastoResponseDto>> {
        return try {
            val response = api.getGastos()
            if (response.isSuccessful)
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("No hay gastos...")
            else Resource.Error("HTTP ${response.code()} ${response.message()}")
        } catch (e: IOException) {
            Resource.Error(message = "Error de conexion", data = null)
        }
    }

    suspend fun crearGastos(req: GastoRequestDto): Resource<Unit> {
        return try {
            val response = api.crearGasto(req)
            if (response.isSuccessful)
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("No se ha podido crear el gasto...")
            else Resource.Error("HTTP ${response.code()} ${response.message()}")
        } catch (e: IOException) {
            Resource.Error(message = "Error de conexion", data = null)
        }
    }
}