package com.compuserviSuarez.com.sisnegmovil.di

import com.compuserviSuarez.com.sisnegmovil.domain.cotizaciones.useCases.CotizacionUseCases
import com.compuserviSuarez.com.sisnegmovil.domain.cotizaciones.useCases.SaveCotizacionUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.clientes.useCases.ClienteUseCases
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.clientes.useCases.FindClienteUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.clientes.useCases.ListByNombreClienteUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.clientes.useCases.ListClienteUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.estadosDeCuenta.useCases.EstadoDeCuentaUseCases
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.estadosDeCuenta.useCases.ReportarEstadoDeCuentaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.estadosDeCuenta.useCases.ValidarFechaEstadoDeCuentaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.cotizaciones.useCases.GetCotizacionByCodigoClienteUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.cotizaciones.useCases.GetListaCotizacionesUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.FacturaUseCases
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.FindComisionLavadorFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.FindFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.FindHoldFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.GetDetalleComisionFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.ListComisionFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.ListComisionLavadorFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.ListFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.ListHoldFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.SaveFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.useCases.SaveHoldFacturaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.mesas.useCases.FindMesaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.mesas.useCases.ListAvailableCompaniaMesaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.mesas.useCases.ListAvailableMesaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.mesas.useCases.ListByCompaniaMesaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.mesas.useCases.ListMesaUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.mesas.useCases.MesaUseCases
import com.compuserviSuarez.com.sisnegmovil.domain.general.usuarios.useCases.LoginUsuarioUseCase
import com.compuserviSuarez.com.sisnegmovil.domain.general.usuarios.useCases.UsuarioUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideFacturaUseCases(
        findComisionLavadorFactura: FindComisionLavadorFacturaUseCase,
        findFactura: FindFacturaUseCase,
        findHoldFactura: FindHoldFacturaUseCase,
        getDetalleComisionFactura: GetDetalleComisionFacturaUseCase,
        listComisionFactura: ListComisionFacturaUseCase,
        listComisionLavadorFactura: ListComisionLavadorFacturaUseCase,
        listFactura: ListFacturaUseCase,
        listHoldFactura: ListHoldFacturaUseCase,
        saveFactura: SaveFacturaUseCase,
        saveHoldFactura: SaveHoldFacturaUseCase
    ): FacturaUseCases {
        return FacturaUseCases(
            findComisionLavadorFacturaUseCase = findComisionLavadorFactura,
            findFacturaUseCase = findFactura,
            findHoldFacturaUseCase = findHoldFactura,
            getDetalleComisionFacturaUseCase = getDetalleComisionFactura,
            listComisionFacturaUseCase = listComisionFactura,
            listComisionLavadorFacturaUseCase = listComisionLavadorFactura,
            listFacturaUseCase = listFactura,
            listHoldFacturaUseCase = listHoldFactura,
            saveFacturaUseCase = saveFactura,
            saveHoldFacturaUseCase = saveHoldFactura
        )
    }

    @Provides
    @Singleton
    fun provideClienteUseCases(
        findCliente: FindClienteUseCase,
        listByNombreCliente: ListByNombreClienteUseCase,
        listCliente: ListClienteUseCase
    ): ClienteUseCases {
        return ClienteUseCases(
            findClienteUseCase = findCliente,
            listByNombreClienteUseCase = listByNombreCliente,
            listClienteUseCase = listCliente
        )
    }

    @Provides
    @Singleton
    fun provideUsuarioUseCases(
        loginUsuarioUseCase: LoginUsuarioUseCase,
    ): UsuarioUseCases {
        return UsuarioUseCases(
            loginUsuarioUseCase = loginUsuarioUseCase,
        )
    }

    @Provides
    @Singleton
    fun provideMesaUseCases(
        findMesaUseCase: FindMesaUseCase,
        listAvailableCompaniaMesaUseCase: ListAvailableCompaniaMesaUseCase,
        listAvailableMesaUseCase: ListAvailableMesaUseCase,
        listByCompaniaMesaUseCase: ListByCompaniaMesaUseCase,
        listMesaUseCase: ListMesaUseCase
    ): MesaUseCases = MesaUseCases(
        findMesaUseCase = findMesaUseCase,
        listAvailableCompaniaMesaUseCase = listAvailableCompaniaMesaUseCase,
        listAvailableMesaUseCase = listAvailableMesaUseCase,
        listByCompaniaMesaUseCase = listByCompaniaMesaUseCase,
        listMesaUseCase = listMesaUseCase
    )

    @Provides
    @Singleton
    fun providesEstadoDeCuentaUseCases(
        reportarEstadoDeCuentaUseCase: ReportarEstadoDeCuentaUseCase,
        validarFechaEstadoDeCuentaUseCase: ValidarFechaEstadoDeCuentaUseCase
    ): EstadoDeCuentaUseCases = EstadoDeCuentaUseCases(
        reportarEstadoDeCuentaUseCase = reportarEstadoDeCuentaUseCase,
        validarFechaEstadoDeCuentaUseCase = validarFechaEstadoDeCuentaUseCase
    )

    @Provides
    @Singleton
    fun providesCotizacionUseCases(
        getCotizacionByCodigoCliente: GetCotizacionByCodigoClienteUseCase,
        getListaCotizaciones: GetListaCotizacionesUseCase,
        saveCotizacion: SaveCotizacionUseCase
    ): CotizacionUseCases = CotizacionUseCases(
        getCotizacionByCodigoCliente = getCotizacionByCodigoCliente,
        getListaCotizaciones = getListaCotizaciones,
        saveCotizacion = saveCotizacion
    )
}