package br.com.scenarioautomation.alugames.main

import br.com.scenarioautomation.alugames.service.ApiConsumption
import br.com.scenarioautomation.alugames.model.Game
import br.com.scenarioautomation.alugames.model.Gamer
import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)

    var gamer = Gamer.createGamer(input)
    println("\nRegister successfully completed! ˆˆ")

    do {
        println("\nEnter a game code to search or 0 to exit:")
        val gameCode = input.nextLine()

        if (!gameCode.equals("0")) {
            val apiConsumption = ApiConsumption()
            val myGameInfo = apiConsumption.getGame(gameCode)

            var myGame: Game? = null

            val result = runCatching {
                myGame = Game(myGameInfo.info.title, thumb = myGameInfo.info.thumb)
            }

            result.onFailure {
                println("Game code not found!")
            }

            result.onSuccess {
                println(myGame)

                println("Do you want to enter a custom description? Y/N")
                val option = input.nextLine()

                if (option.equals("Y", true)) {
                    println("\nEnter a custom description for the game:")
                    val customDescription = input.nextLine()

                    myGame?.description = customDescription
                } else {
                    myGame?.description = myGame.title
                }

                println(myGame)
            }.also {
                println("Do you want to favorite this game? Y/N")
                val option = input.nextLine()

                if (option.equals("Y", true)) {
                    if (gamer.userName.isNullOrBlank()) {
                        println("\nFirst, complete your registration:")
                        gamer = Gamer.completeRegistration(input, gamer)
                    }

                    myGame?.isFavorite = true

                    gamer.favoriteGames.add(myGame)

                    println("\nGame added to the favorites successfully!")
                }
            }
        }
    } while (!gameCode.equals("0"))

    println("\nSearch successfully completed! ˆˆ")

    if (gamer.favoriteGames.isNotEmpty()) {
        println("\nCheck out your list of favorite games order by title:")
        println("-----")
        gamer.favoriteGames.sortBy {
            it?.title
        }
        gamer.favoriteGames.forEach {
            println(it?.title)
        }
        println("-----")

        println("\nDo you want filter the list? (Y/N)")
        val option = input.nextLine()

        if (option.equals("Y", true)) {
            println("\nEnter the filter:")
            val filter = input.nextLine()

            val filterGames: List<Game?> = gamer.favoriteGames.filter {
                it?.title?.contains(filter, true) ?: false
            }

            println("\nFilter games:")
            println("-----")
            filterGames.forEach {
                println(it?.title)
            }
            println("-----")
        }

        println("\nDo you want remove any game of original list? (Y/N)")
        val wantsRemove = input.nextLine()

        if (wantsRemove.equals("Y", true)) {
            println("\n-----")
            var i = 1
            gamer.favoriteGames.forEach {
                println("$i. ${it?.title}")
                i++
            }
            println("-----")

            println("\nEnter the game position in the list:")
            val position = input.nextInt()

            gamer.favoriteGames.removeAt(position - 1)
            println("\n-----")
            gamer.favoriteGames.forEach {
                println(it?.title)
            }
            println("-----")
        }
    }
}