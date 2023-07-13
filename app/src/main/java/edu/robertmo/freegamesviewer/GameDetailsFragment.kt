package edu.robertmo.freegamesviewer

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import edu.robertmo.freegamesviewer.databinding.FragmentGameDetailsBinding
import edu.robertmo.freegamesviewer.models.Game

private val ARG_GAME = "game"

class GameDetailsFragment : Fragment() {


    private lateinit var viewModel: GameDetailsViewModel
    private var _binding: FragmentGameDetailsBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(GameDetailsViewModel::class.java)
        _binding = FragmentGameDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val game = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(ARG_GAME, Game::class.java)
        } else {
            requireArguments().getParcelable(ARG_GAME)
        } ?: return

        binding.txtGameName.text = game.title
        binding.txtCategoryDetails.text = game.releaseDate
        binding.txtDescription.text = game.shortDescription
        Picasso.get().load(game.freetogameProfileUrl).into(binding.imgGame)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}