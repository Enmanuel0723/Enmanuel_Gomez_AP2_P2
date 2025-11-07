package edu.ucne.enmanuel_gomez_ap2_p2.ui.presentation.gastos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto
import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases.GastoUseCases
import edu.ucne.enmanuel_gomez_ap2_p2.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GastoViewModel @Inject constructor(
    private val gastosUseCase: GastoUseCases,
) : ViewModel() {
    private val _state = MutableStateFlow(GastoUiState())
    val state = _state.asStateFlow()

    init {
        loadGastos()
    }

    fun onEvent(event: GastoEvent) {
        when (event) {
            is GastoEvent.LoadGastos -> loadGastos()
            is GastoEvent.SaveGasto -> saveGasto()
            GastoEvent.HideModal -> _state.update { it.copy(showModal = false) }
            GastoEvent.ShowModal -> _state.update { it.copy(showModal = true) }

            is GastoEvent.ChangeMonto -> _state.update {
                it.copy(
                    monto = event.monto.toDouble(),
                    errorMonto = ""
                )
            }

            is GastoEvent.ChangeNcf -> {
                _state.update {
                    it.copy(
                        ncf = event.ncf,
                        errorNcf = ""
                    )
                }
            }

            is GastoEvent.ChangeSuplidor -> {
                _state.update {
                    it.copy(
                        suplidor = event.suplidor,
                        errorSuplidor = ""
                    )
                }
            }
        }
    }

    private fun saveGasto() {
        viewModelScope.launch {
            val gasto = Gasto(
                suplidor = state.value.suplidor ?: "",
                ncf = state.value.ncf ?: "",
                monto = state.value.monto ?: 0.0,
                itbis = state.value.itbis?.times(state.value.monto ?: 0.0) ?: 0.0,
            )
            val result = gastosUseCase.crearGastoUseCase(gasto)
            when (result) {
                is Resource.Error -> _state.update {
                    it.copy(
                        errorMonto = result.message,
                        isLoading = false
                    )
                }

                is Resource.Loading ->
                    _state.update { it.copy(isLoading = true) }

                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            monto = null,
                            ncf = "",
                            suplidor = "",
                            isLoading = false,
                            showModal = false
                        )
                    }
                    loadGastos()
                }
            }
        }
    }

    private fun loadGastos() {
        viewModelScope.launch {
            gastosUseCase.getGastosUseCase().collectLatest { result ->
                when(result) {
                    is Resource.Error ->
                        _state.update {
                            it.copy(
                                errorMonto = result.message,
                                isLoading = false
                            )
                        }

                    is Resource.Loading ->
                        _state.update { it.copy(isLoading = true) }

                    is Resource.Success ->
                        _state.update {
                            it.copy(
                                listaGastos = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                }
            }
        }
    }
}