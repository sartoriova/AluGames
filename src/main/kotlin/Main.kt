package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val input = Scanner(System.`in`)

    println("Enter a game code to search:")
    val gameCode = input.nextLine()

    val client = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$gameCode"))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val stringJson = response.body()

    println(stringJson)

    //podemos tratar também com try catch, como no Java, por exemplo
    //mas no kotlin utilizamos o runCatching
//    if (response.statusCode() != 200) {
//        println("Game code not found!")
//        return
//    }

    val gson = Gson()
    //::class.java indica que é uma classe

    val result = runCatching {
        val myGameInfo = gson.fromJson(stringJson, GameInfo::class.java)
        val myGame = Game(myGameInfo.info.title, thumb = myGameInfo.info.thumb)

        println(myGame)
    }

    result.onFailure {
        println("Game code not found!")
    }

    result.onSuccess {
        print("Do you want to enter a custom description? Y/N")
        val option = input.nextLine()

        if (option.equals("Y", true)) {
            print("Enter a custom description for the game:")
            val description = input.nextLine()
        }
    }
}