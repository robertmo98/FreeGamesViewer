package edu.robertmo.freegamesviewer.ui.discovergamespage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.robertmo.freegamesviewer.models.Game
import edu.robertmo.freegamesviewer.service.GameService
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "DiscoverGamesViewModel"
class DiscoverGamesViewModel : ViewModel() {
    private val _games=MutableLiveData<List<Game>>()
    //expose the MutableLiveData as Immutable:
    val games: LiveData<List<Game>> = _games

    init {
        viewModelScope.launch {////we receive the result on the Main Thread
            try {
                //the games are fetched on an IO Thread due to the fact that the functions
                //are 'suspend' annotated (retrofit features)
                val allGames = GameService.create().discoverGamesDesc()

                //we are on the Main Thread, so we can directly update the UI
                _games.postValue(allGames)
            }catch (e: Exception){
                Log.d(TAG, "${e.message}")
            }
        }
    }

}