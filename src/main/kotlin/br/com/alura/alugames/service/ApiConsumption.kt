package br.com.alura.alugames.service

import com.google.gson.Gson
import br.com.alura.alugames.model.GameInfo
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.GamerInfoJSON
import br.com.alura.alugames.utils.createGamer
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsumption {
    private fun consumesData(address: String): String {
        val client = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        return response.body()
    }

    fun getGame(id: String): GameInfo {
        val stringJson = consumesData("https://www.cheapshark.com/api/1.0/games?id=$id")

        //::class.java indica que é uma classe
        val gson = Gson()
        val myGameInfo = gson.fromJson(stringJson, GameInfo::class.java)

        return myGameInfo
    }

    fun getGamers(): List<Gamer> {
        val stringJson = consumesData("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json")

        val gson = Gson()
        val myTypeGamer = object : TypeToken<List<GamerInfoJSON>>() {}.type
        val gamersList: List<GamerInfoJSON> = gson.fromJson(stringJson, myTypeGamer)

        return gamersList.map {
            it.createGamer()
        }.toList()
    }
}