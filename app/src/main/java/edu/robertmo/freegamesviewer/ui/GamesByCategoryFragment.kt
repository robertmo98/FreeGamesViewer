package edu.robertmo.freegamesviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import edu.robertmo.freegamesviewer.databinding.FragmentGamesByCategoryBinding
import edu.robertmo.freegamesviewer.service.GameService
import edu.robertmo.freegamesviewer.ui.adapters.GameAdapter

class GamesByCategory : Fragment() {

    private var _binding: FragmentGamesByCategoryBinding?= null
    private val binding get() = _binding!!

    private lateinit var viewModel: GamesByCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val category = requireArguments().getString("category")

        viewModel = ViewModelProvider(this).get(GamesByCategoryViewModel::class.java)
        viewModel.setGameService(GameService.create())

        if(category != null) {
            viewModel.setChosenCategory(category)
            viewModel.fetchGamesByCategory(category)
        }

        ///api response with the passed query, for example:
        ///GET(https://www.freetogame.com/api/games?category=strategy) retrieves json object with
        ///different and irrelevant genres (categories) (relevant for the 12'th of July 23)
        ///debugging was conducted : the chosen category was passed and received correctly.
        /// the query parameter passes correctly.
        ///bottom line: code logic is correct and was tested .


        viewModel.games.observe(viewLifecycleOwner) {
            val adapter = GameAdapter(it)
            binding.recyclerFilteredGames.adapter = adapter
            binding.recyclerFilteredGames.layoutManager = GridLayoutManager(context, 3)
        }

        _binding = FragmentGamesByCategoryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        // set the name on the upper menu ber
        (activity as? MainActivity)?.setToolbarTitle("Games By Category")
    }

}