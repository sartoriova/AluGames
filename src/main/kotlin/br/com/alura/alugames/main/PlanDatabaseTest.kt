package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.PlanDAO
import br.com.alura.alugames.model.IndividualPlan
import br.com.alura.alugames.model.SubscriptionPlan

fun main() {
    val individual = IndividualPlan("BRONZE")
    val silver = SubscriptionPlan("PRATA", 9.9, 3, 0.15)
    val gold = SubscriptionPlan("OURO", 19.90, 5, 0.20)
    val platinum = SubscriptionPlan("PLATINA", 29.90, 10, 0.30)
    val diamond = SubscriptionPlan("DIAMANTE", 49.90, 20, 0.50)

    val manager = Database.getEntityManager()
    val planDAO = PlanDAO(manager)

    planDAO.add(individual)
    planDAO.add(silver)
    planDAO.add(gold)
    planDAO.add(platinum)
    planDAO.add(diamond)

    println(planDAO.getList())

    manager.close()
}