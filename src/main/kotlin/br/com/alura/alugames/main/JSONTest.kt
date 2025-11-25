package br.com.alura.alugames.main

import br.com.alura.alugames.model.SubscriptionPlan
import br.com.alura.alugames.service.ApiConsumption
import java.time.LocalDate

fun main() {
    val apiConsumption = ApiConsumption()

    val gamersList = apiConsumption.getGamers()
    val gamesList = apiConsumption.getGames()

    val gamerCaroline  = gamersList[3]

    val gameResidentVillage = gamesList[10]
    val gameSpiderMan = gamesList[13]
    val gameTheLastOfUs = gamesList[2]

    gamerCaroline.rentGame(gameResidentVillage, LocalDate.now(), LocalDate.now().plusDays(3))
    gamerCaroline.rentGame(gameSpiderMan, LocalDate.now(), LocalDate.now().plusDays(7))
    gamerCaroline.rentGame(gameTheLastOfUs, LocalDate.now(), LocalDate.now().plusDays(10))

    println(gamerCaroline.rentedGames)

    val gamerCamila = gamersList[5]
    gamerCamila.plan = SubscriptionPlan("prata", 9.9, 3)

    gamerCamila.rentGame(gameResidentVillage, LocalDate.now(), LocalDate.now().plusDays(3))
    gamerCamila.rentGame(gameSpiderMan, LocalDate.now(), LocalDate.now().plusDays(7))
    gamerCamila.rentGame(gameTheLastOfUs, LocalDate.now(), LocalDate.now().plusDays(10))
    gamerCamila.rentGame(gameTheLastOfUs, LocalDate.now(), LocalDate.now().plusDays(10))

    println(gamerCamila.rentedGames)
}