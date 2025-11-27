package br.com.alura.alugames.data

import br.com.alura.alugames.model.Game
import br.com.alura.alugames.utils.toEntity
import br.com.alura.alugames.utils.toModel
import javax.persistence.EntityManager

class GameDAO(manager: EntityManager) : DAO<Game, GameEntity>(manager, GameEntity::class.java) {
    override fun toEntity(element: Game): GameEntity {
        return element.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }
//    fun getGames(): List<Game> {
//        val games = mutableListOf<Game>()
//        val connection = Database.getConnection()
//
//        if (connection != null) {
//            try {
//                val statement = connection.createStatement()
//                val result = statement.executeQuery("SELECT * FROM JOGOS")
//
//                while(result.next()) {
//                    val id = result.getInt("id")
//                    val title = result.getString("titulo")
//                    val thumb = result.getString("capa")
//                    val description = result.getString("descricao")
//                    val price = result.getDouble("preco")
//
//                    val game = Game(title, thumb, price, description, id)
//                    games.add(game)
//                }
//                statement.close()
//            } finally {
//                connection.close()
//            }
//        }
//
//        return games
//    }
//
//    fun addGame(game: Game) {
//        val connection = Database.getConnection()
//
//        if (connection != null) {
//            try {
//                val statement = connection.prepareStatement("INSERT INTO JOGOS (TITULO, CAPA, DESCRICAO, PRECO) VALUES (?, ?, ?, ?)")
//
//                statement.setString(1, game.title)
//                statement.setString(2, game.thumb)
//                statement.setString(3, game.description)
//                statement.setDouble(4, game.price)
//
//                statement.executeUpdate()
//
//                statement.close()
//            } finally {
//                connection.close()
//            }
//        }
//    }
}