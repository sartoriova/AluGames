package br.com.alura.alugames.model

//no construtor nao precisamos instanciar a variavel
//por isso temos que declarar o tipo da variavel
data class Game(val title: String, val thumb: String) {
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

    var description = ""
    var isFavorite = false

    override fun toString(): String {
        return String.format("""
            -----
            Title: %s
            Thumb: %s
            Description: %s
            -----
        """, title, thumb, description)
    }
}