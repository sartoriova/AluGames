package br.com.scenarioautomation.alugames.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.getAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return Period.between(LocalDate.parse(this, formatter), LocalDate.now()).years
}