package br.com.alura.alugames.main

import br.com.alura.alugames.model.SubscriptionPlan
import br.com.alura.alugames.service.ApiConsumption
import com.google.gson.GsonBuilder
import java.io.File
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

    //println(gamerCaroline.rentedGames)

    val gamerCamila = gamersList[5]
    gamerCamila.plan = SubscriptionPlan("prata", 9.9, 3, 0.15)

    gamerCamila.rentGame(gameResidentVillage, LocalDate.now(), LocalDate.now().plusDays(3))
    gamerCamila.rentGame(gameSpiderMan, LocalDate.now(), LocalDate.now().plusDays(7))
    gamerCamila.rentGame(gameTheLastOfUs, LocalDate.now(), LocalDate.now().plusDays(10))
    gamerCamila.rentGame(gameTheLastOfUs, LocalDate.now(), LocalDate.now().plusDays(10))

    //println(gamerCamila.rentedGames)

    val result = runCatching {
        gamerCamila.recommend(7)
        gamerCamila.recommend(10)
        gamerCamila.recommend(7)
    }

    result.onSuccess {
        //println(gamerCamila)

        gamerCamila.rentGame(gameResidentVillage, LocalDate.now(), LocalDate.now().plusDays(3))

        //println(gamerCamila.rentedGames)
    }

    result.onFailure {
        println("\nInvalid score! Enter a number of 1 to 10!")
    }

    gamerCamila.recommendGame(gameResidentVillage, 7)
    gamerCamila.recommendGame(gameTheLastOfUs, 10)
    gamerCaroline.recommendGame(gameTheLastOfUs, 9)
    gamerCaroline.recommendGame(gameResidentVillage, 8)

    println("Camila's recommendations:")
    println(gamerCamila.recommendedGames)

    println("Caroline's recommendations:")
    println(gamerCaroline.recommendedGames)

    val gameDandara = gamesList[5]
    val gameAssassins = gamesList[4]
    val gameCyber = gamesList[6]
    val gameGod = gamesList[7]
    val gameSkyrim = gamesList[18]

    gamerCamila.recommendGame(gameResidentVillage, 7)
    gamerCamila.recommendGame(gameTheLastOfUs, 10)
    gamerCamila.recommendGame(gameAssassins, 8)
    gamerCamila.recommendGame(gameCyber, 7)
    gamerCamila.recommendGame(gameGod, 10)
    gamerCamila.recommendGame(gameDandara, 8)
    gamerCamila.recommendGame(gameSkyrim, 8)
    gamerCamila.recommendGame(gameSpiderMan, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gson.toJson(gamerCamila.recommendedGames)

    println(serialization)

    val file = File("recommendedGames - ${gamerCamila.name}.json")
    file.writeText(serialization)

    println(file.absolutePath)
    println(gamerCamila)
}