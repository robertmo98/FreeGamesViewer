package edu.robertmo.freegamesviewer.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.robertmo.freegamesviewer.models.Game
import edu.robertmo.freegamesviewer.service.GameService
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "GamesByCategoryViewModel"
class GamesByCategoryViewModel : ViewModel() {
    private lateinit var gameService: GameService

    private var chosenCategory: String = ""


    private val _games = MutableLiveData<List<Game>>()
    val games: LiveData<List<Game>> = _games

    fun setGameService(service: GameService) {
        gameService = service
    }

    fun setChosenCategory(category: String) {
        chosenCategory = category
    }

    fun fetchGamesByCategory(category: String) {
        viewModelScope.launch {
            try {
                val response = gameService.getGamesByCategory(category)
                _games.postValue(response)
            } catch (e: Exception){
                Log.e(TAG, "Failed to fetch games", e)
            }
        }
    }
}