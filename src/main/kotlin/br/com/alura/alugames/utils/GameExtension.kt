package br.com.alura.alugames.utils

import br.com.alura.alugames.data.GameEntity
import br.com.alura.alugames.model.Game
import br.com.alura.alugames.model.GameInfoJSON

fun GameInfoJSON.createGame(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}

fun Game.toEntity(): GameEntity {
        return GameEntity(this.title, this.thumb, this.price, this.description, this.id)
}

fun GameEntity.toModel(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao, this.id)
}