package br.com.alura.alugames.main

import br.com.alura.alugames.data.GameDAO
import br.com.alura.alugames.model.Game

fun main() {
    val game = Game("Teste", "Teste", 0.0, "Inserindo teste")

    GameDAO.addGame(game)

    println(GameDAO.getGames())
}