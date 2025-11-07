package edu.ucne.enmanuel_gomez_ap2_p2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.GastoRemoteDataSource
import edu.ucne.enmanuel_gomez_ap2_p2.data.gastos.GastoRepositoryImpl
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.GastoRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGastoRepository(remote: GastoRemoteDataSource): GastoRepository =
        GastoRepositoryImpl(remote)
}