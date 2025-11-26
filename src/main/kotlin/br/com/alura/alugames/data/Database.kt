package br.com.alura.alugames.data

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {
    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}