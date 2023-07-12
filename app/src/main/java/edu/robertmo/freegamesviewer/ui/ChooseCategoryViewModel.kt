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

private const val TAG = "ChooseCategoryViewModel"
class ChooseCategoryViewModel : ViewModel() {
    private val _categories = MutableLiveData<List<String>>()
    //expose the MutableLiveData ad Immutable:
    val categories: LiveData<List<String>> = _categories

    init {
        viewModelScope.launch {
            try {
                val games = GameService.create().getPcGames()
                val extractedCategories = extractCategories(games)

                _categories.postValue(extractedCategories)
            }catch (e: Exception){
                Log.e(TAG, "Failed to fetch Categories", e)
            }
        }
    }

    private fun extractCategories(games: List<Game>): List<String> {
        val categories = HashSet<String>()
        for(game in games){
            val category = game.genre
            if(category.isNotEmpty()){
                categories.add(category)
            }
        }
        return categories.toList()
    }
}