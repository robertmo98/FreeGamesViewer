package edu.robertmo.freegamesviewer.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class GameResponse : ArrayList<Game>()

@Parcelize
data class Game(
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String?,
    @SerializedName("game_url")
    val gameUrl: String?,
    val genre: String,
    val id: Int,
    val platform: String,
    val publisher: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("short_description")
    val shortDescription: String,
    val thumbnail: String?,
    val title: String
): Parcelable

