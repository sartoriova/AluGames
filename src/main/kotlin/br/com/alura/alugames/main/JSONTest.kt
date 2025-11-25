package br.com.alura.alugames.main

import br.com.alura.alugames.service.ApiConsumption

fun main() {
    val apiConsumption = ApiConsumption()

    val gamersList = apiConsumption.getGamers()
    val game = apiConsumption.getGame("146")

    println(gamersList)
    println(game)
}