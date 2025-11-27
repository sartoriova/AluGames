package br.com.alura.alugames.utils

import br.com.alura.alugames.data.GamerEntity
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.GamerInfoJSON

fun GamerInfoJSON.createGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.name, this.email, this.dateOfBirth, this.userName, this.plan.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}