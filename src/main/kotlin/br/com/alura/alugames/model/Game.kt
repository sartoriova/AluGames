package br.com.alura.alugames.model

import com.google.gson.annotations.Expose

//no construtor nao precisamos instanciar a variavel
//por isso temos que declarar o tipo da variavel
data class Game(@Expose val title: String, @Expose val thumb: String) : Recommendation {
    //diferenca entre var e val:
    //var permite alteração no valor
    //val não permite alteração no valor uma vez
    //que é passado o valor inicial

    //no kotlin, as variaveis precisam ser iniciadas
    //val title: String = "" - isso é reduntante
    //ele já infere o tipo de acordo com a inicialização

    //boa pratica usar data class
    //nas classes que nao precisamos
    //ficar alterando

    var id = 0
    var description = ""
    var price = 0.0
    val scores = mutableListOf<Int>()
    var isFavorite = false

    constructor(title: String, thumb: String, price: Double, description: String, id: Int = 0):
            this(title, thumb) {
        this.id = id
        this.price = price
        this.description = description
    }

    override val average: Double
        get() = scores.average()

    override fun recommend(score: Int) {
        if (score < 1 || score > 10) throw IllegalArgumentException("Invalid score!")
        scores.add(score)
    }

    override fun toString(): String {
        return String.format("""
            -----
            Id: %d
            Title: %s
            Thumb: %s
            Description: %s
            Price: %.2f
            Reputation: %.2f
            -----
        """, id, title, thumb, description, price, average)
    }
}