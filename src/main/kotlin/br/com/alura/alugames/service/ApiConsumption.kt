package br.com.alura.alugames.service

import com.google.gson.Gson
import br.com.alura.alugames.model.GameInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsumption {
    fun getGame(id: String): GameInfo {
        val client = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())
        val stringJson = response.body()

        //::class.java indica que é uma classe
        val gson = Gson()
        val myGameInfo = gson.fromJson(stringJson, GameInfo::class.java)

        return myGameInfo
    }
}