package br.com.alura.alugames.model

import java.time.LocalDate
import java.time.Period

data class MyPeriod(val initialDate: LocalDate, val finalDate: LocalDate) {
    val inDays = Period.between(initialDate, finalDate).days
}
