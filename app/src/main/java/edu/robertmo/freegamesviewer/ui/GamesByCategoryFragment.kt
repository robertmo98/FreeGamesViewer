package edu.robertmo.freegamesviewer.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.get
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import edu.robertmo.freegamesviewer.R
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
    ): View? {
        val category = requireArguments().getString("category")

        viewModel = ViewModelProvider(this).get(GamesByCategoryViewModel::class.java)
        viewModel.setGameService(GameService.create())

        if(category != null) {
            viewModel.setChosenCategory(category)
            viewModel.fetchGamesByCategory(category)
        }

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