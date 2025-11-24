package br.com.scenarioautomation.alugames.main

import br.com.scenarioautomation.alugames.model.Gamer

fun main() {
    var gamer1: Gamer? = null

    val result = runCatching {
        gamer1 = Gamer("Valéria", "valeriasartorio3@gmail.com")
    }

    result.onSuccess {
        println(gamer1)
    }

    result.onFailure {
        println("Invalid name or e-mail!")
    }

    val gamer2 = Gamer("Jurema", "jurema@gmail.com", "24/10/2000", "jurema.jurema")

    println(gamer2)

    gamer1.let {
        it?.dateOfBirth = "15/12/2005"
        it?.userName = "sartoriova"
    }.also {
        println(gamer1)
    }

    println(gamer1)
    gamer1?.userName = "valeriasartorio"
    println(gamer1)
}
