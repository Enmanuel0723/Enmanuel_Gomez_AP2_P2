package edu.ucne.enmanuel_gomez_ap2_p2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases.CrearGastoUseCase
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases.FindGastoUseCase
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases.GastoUseCases
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases.GetGastosUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGastoUseCase(
        getGastosUseCase: GetGastosUseCase,
        crearGastoUseCase: CrearGastoUseCase,
        findGastoUseCase: FindGastoUseCase
    ) = GastoUseCases(
        crearGastoUseCase = crearGastoUseCase,
        getGastosUseCase = getGastosUseCase,
        findGastoUseCase = findGastoUseCase,
    )
}
