package edu.robertmo.freegamesviewer.ui.gamedetails

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
import edu.robertmo.freegamesviewer.ui.MainActivity

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
        binding.txtPlatform.text = game.platform
        binding.txtCategoryDetails.text = game.genre
        binding.txtDescription.text = game.shortDescription
        binding.txtReleaseDate.text = game.releaseDate
        Picasso.get().load(game.thumbnail).into(binding.imgGame)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onResume() {
        super.onResume()
        // set the name on the upper menu ber
        (activity as? MainActivity)?.setToolbarTitle("Game Info")
    }

}