package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos

import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource

interface GastoRepository {
    suspend fun getGastos(): Resource<List<Gasto>>
    suspend fun crearGasto(req: Gasto): Resource<Unit>
    suspend fun findGasto(id: Int): Resource<Gasto>
}