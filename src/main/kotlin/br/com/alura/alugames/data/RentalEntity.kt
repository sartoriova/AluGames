package br.com.alura.alugames.data

import br.com.alura.alugames.model.MyPeriod
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "aluguel")
class RentalEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val period: MyPeriod = MyPeriod()
) {
    var rentalPrice = 0.0
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}