package edu.robertmo.freegamesviewer.ui.gamesbyplatformpage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.robertmo.freegamesviewer.models.Game
import edu.robertmo.freegamesviewer.service.GameService
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "GamesByPlatformViewModel"
class GamesByPlatformViewModel : ViewModel() {
    private lateinit var gameService: GameService
    private var chosenPlatform: String = ""

    private val _games = MutableLiveData<List<Game>>()
    //expose the MutableLiveData ad Immutable:
    val games: LiveData<List<Game>> = _games

    fun setGameService(service: GameService) {
        gameService = service
    }

    fun setChosenPlatform(platform: String) {
        chosenPlatform = platform
    }

    fun fetchGamesByPlatform(platform: String) {
        viewModelScope.launch {
            try {
                val response = gameService.getGamesByPlatform(chosenPlatform)
                _games.postValue(response)
            } catch (e: Exception){
                Log.e(TAG, "Failed to fetch games", e)
            }
        }
    }


}