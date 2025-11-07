package edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.useCases

import edu.ucne.enmanuel_gomez_ap2_p2.domain.gastos.Gasto
import edu.ucne.enmanuel_gomez_ap2_p2.utils.ValidationResult

fun validarGasto(gasto: Gasto): ValidationResult {
    if (gasto.suplidor.isBlank()) {
        return ValidationResult(
            esValido = false,
            error = "El suplidor no puede estar vacío."
        )
    }

    if (gasto.monto <= 0) {
        return ValidationResult(
            esValido = false,
            error = "El monto debe ser mayor que cero."
        )
    }

    if (gasto.ncf.isBlank()) {
        return ValidationResult(
            esValido = false,
            error = "El NCF no puede estar vacío."
        )
    }

    val ncfSinGuiones = gasto.ncf.replace("-", "").trim()
    if (!ncfSinGuiones.matches(Regex("^[A-Z0-9]{11}$|^[A-Z0-9]{13}$"))) {
        return ValidationResult(
            esValido = false,
            error = "El NCF debe tener 11 o 13 caracteres alfanuméricos."
        )
    }

    return ValidationResult(esValido = true)
}
