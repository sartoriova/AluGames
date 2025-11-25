package br.com.alura.alugames.utils

import br.com.alura.alugames.model.Game
import br.com.alura.alugames.model.GameInfoJSON

fun GameInfoJSON.createGame(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}