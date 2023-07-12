package edu.robertmo.freegamesviewer.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import edu.robertmo.freegamesviewer.databinding.GameItemBinding
import edu.robertmo.freegamesviewer.models.Game

class GameAdapter(val games : List<Game>): Adapter<GameAdapter.VH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            GameItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val game = games[position]
        holder.binding.gameTitle.text = game.title
        holder.binding.gameDescription.text = game.shortDescription
        holder.binding.gameCategory.text = game.genre
        Picasso.get().load(game.thumbnail).into(holder.binding.gameImage)
    }

    class VH(val binding: GameItemBinding): ViewHolder(binding.root)
}