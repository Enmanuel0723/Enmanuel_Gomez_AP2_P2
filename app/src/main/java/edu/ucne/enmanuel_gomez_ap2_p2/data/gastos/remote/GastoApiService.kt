package edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote

import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoRequestDto
import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.remote.dto.GastoResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GastoApiService {
    @GET("api/Gastos")
    suspend fun getGastos(): Response<List<GastoResponseDto>>

    @POST("api/Gastos")
    suspend fun crearGasto(@Body request: GastoRequestDto): Response<Unit>

    @GET("api/Gastos/{id}")
    suspend fun findGasto(@Path("id") id: Int): Response<GastoResponseDto>
}