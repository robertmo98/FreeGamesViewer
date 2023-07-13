package edu.robertmo.freegamesviewer.service

import edu.robertmo.freegamesviewer.models.GameResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {

    @GET("games?sort-by=release-date")
    suspend fun discoverGamesDesc(): GameResponse

    @GET("games?platform=pc")
    suspend fun getPcGames(): GameResponse

    @GET("games")
    suspend fun getGamesByPlatform(@Query("platform") platform: String): GameResponse

    @GET("games")
    suspend fun getGamesByCategory(@Query("category") category: String): GameResponse


    companion object {
        private const val BASE_URL = "https://www.freetogame.com/api/"
        fun create(): GameService {
            return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GameService::class.java)
        }
    }
}