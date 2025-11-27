package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.GameDAO
import br.com.alura.alugames.data.GamerDAO
import br.com.alura.alugames.data.RentalDAO
import java.time.LocalDate

fun main() {
    val manager = Database.getEntityManager()

    val gameDAO = GameDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val rentalDAO = RentalDAO(manager)

    val gamer = gamerDAO.getById(1)
    val game = gameDAO.getById(1)
    val rental = gamer.rentGame(game, LocalDate.now(), LocalDate.now().plusDays((7)))

    rentalDAO.add(rental)

    println(rentalDAO.getList())

    manager.close()
}