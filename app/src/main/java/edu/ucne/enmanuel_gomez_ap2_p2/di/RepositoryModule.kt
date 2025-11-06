package com.compuserviSuarez.com.sisnegmovil.di

import com.compuserviSuarez.com.sisnegmovil.data.caja.cajas.CajaRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.caja.cajasAbiertas.CajaAbiertaRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.caja.desgloces.DesgloceRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.cxc.clientes.ClienteRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.cxc.estadosDeCuenta.EstadoDeCuentaRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.clientesDelivery.ClienteDeliveryRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.condiciones.CondicionRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.cotizaciones.CotizacionRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.facturas.FacturaRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.mesas.MesaRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.pedidos.PedidoRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.rnc.RncRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.facturacion.tiposComprobantesFiscales.TipoComprobanteFiscalRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.general.companias.CompaniaRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.general.configuraciones.ConfiguracionRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.general.impresoras.ImpresoraRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.general.usuarios.UsuarioRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.inventario.almacenes.AlmacenRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.inventario.articulos.ArticuloRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.data.inventario.departamentos.DepartamentoRepositoryImpl
import com.compuserviSuarez.com.sisnegmovil.domain.caja.desgloces.repository.DesgloceRepository
import com.compuserviSuarez.com.sisnegmovil.domain.cajas.repository.CajaRepository
import com.compuserviSuarez.com.sisnegmovil.domain.cajasAbiertas.repository.CajaAbiertaRepository
import com.compuserviSuarez.com.sisnegmovil.domain.cotizaciones.repository.CotizacionRepository
import com.compuserviSuarez.com.sisnegmovil.domain.cxc.clientes.repository.ClienteRepository
import com.compuserviSuarez.com.sisnegmovil.domain.estadosDeCuenta.repository.EstadoDeCuentaRepository
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.clientesDelivery.repository.ClienteDeliveryRepository
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.condiciones.repository.CondicionRepository
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.facturas.repository.FacturaRepository
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.mesas.repository.MesaRepository
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.pedidos.repository.PedidoRepository
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.rnc.repository.RncRepository
import com.compuserviSuarez.com.sisnegmovil.domain.facturacion.tiposComprobantesFiscales.repository.TipoComprobanteFiscalRepository
import com.compuserviSuarez.com.sisnegmovil.domain.general.companias.repository.CompaniaRepository
import com.compuserviSuarez.com.sisnegmovil.domain.general.configuraciones.repository.ConfiguracionRepository
import com.compuserviSuarez.com.sisnegmovil.domain.general.impresoras.repository.ImpresoraRepository
import com.compuserviSuarez.com.sisnegmovil.domain.general.usuarios.repository.UsuarioRepository
import com.compuserviSuarez.com.sisnegmovil.domain.inventario.almacenes.repository.AlmacenRepository
import com.compuserviSuarez.com.sisnegmovil.domain.inventario.articulos.repository.ArticuloRepository
import com.compuserviSuarez.com.sisnegmovil.domain.inventario.departamentos.repository.DepartamentoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCajaRepositoryImpl(repo: CajaRepositoryImpl): CajaRepository = repo
}