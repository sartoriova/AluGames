package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.GameDAO
import br.com.alura.alugames.model.Game

fun main() {
    val game = Game("The last of us", "Teste", 50.0, "Jogo bem famoso")

    val manager = Database.getEntityManager()
    val gameDAO = GameDAO(manager)

    gameDAO.addGame(game)

    println(gameDAO.getGames())

    manager.close()
}