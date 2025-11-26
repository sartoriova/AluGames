package br.com.alura.alugames.data

import br.com.alura.alugames.model.Gamer
import javax.persistence.EntityManager

class GamerDAO(val manager: EntityManager) {
    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)

        return query.resultList.map {
            Gamer(
                it.nome,
                it.email,
                it.dataNascimento,
                it.usuario,
                it.id
            )
        }
    }

    fun addGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.name, gamer.email, gamer.dateOfBirth, gamer.userName)

        manager.transaction.begin()

        manager.persist(entity)

        manager.transaction.commit()
    }
}