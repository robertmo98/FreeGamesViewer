package edu.robertmo.freegamesviewer.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.robertmo.freegamesviewer.models.Game
import edu.robertmo.freegamesviewer.models.GameResponse
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




    init {
        viewModelScope.launch {////we receive the result on the Main Thread
            try {
                //the games are fetched on an IO Thread due to the fact that the functions
                //are 'suspend' annotated (retrofit features)
                val gamesByPlatform = GameService.create().getGamesByPlatform(chosenPlatform)

                //we are on the Main Thread, so we can directly update the UI
                _games.postValue(gamesByPlatform)
            }catch (e: Exception){
                Log.d(TAG, "${e.message}")
            }
        }
    }
}