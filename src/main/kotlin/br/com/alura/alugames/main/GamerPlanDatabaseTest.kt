package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.GamerDAO
import br.com.alura.alugames.data.PlanDAO
import br.com.alura.alugames.model.Gamer

fun main() {
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Database.getEntityManager()

    val gamerDAO = GamerDAO(manager)
    val planDAO = PlanDAO(manager)

    gamer.plan = planDAO.getById(3)

    gamerDAO.add(gamer)

    println(gamerDAO.getList())

    manager.close()
}