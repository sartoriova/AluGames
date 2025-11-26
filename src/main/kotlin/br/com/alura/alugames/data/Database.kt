package br.com.alura.alugames.data

import javax.persistence.EntityManager
import javax.persistence.Persistence

object Database {
//    fun getConnection(): Connection? {
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager(): EntityManager {
        return Persistence.createEntityManagerFactory("alugames").createEntityManager()
    }
}