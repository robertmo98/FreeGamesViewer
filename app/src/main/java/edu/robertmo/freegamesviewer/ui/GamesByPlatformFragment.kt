package edu.robertmo.freegamesviewer.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import edu.robertmo.freegamesviewer.databinding.FragmentGamesByPlatformBinding
import edu.robertmo.freegamesviewer.service.GameService
import edu.robertmo.freegamesviewer.ui.adapters.GameAdapter

class GamesByPlatformFragment : Fragment() {

    private var _binding: FragmentGamesByPlatformBinding?= null

    private val binding get() = _binding!!

    private lateinit var viewModel: GamesByPlatformViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val platform = requireArguments().getString("platform")

        viewModel = ViewModelProvider(this).get(GamesByPlatformViewModel::class.java)
        viewModel.setGameService(GameService.create())

        if (platform != null) {
            viewModel.setChosenPlatform(platform)
            viewModel.fetchGamesByPlatform(platform)
        }


        viewModel.games.observe(viewLifecycleOwner) {
            val adapter = GameAdapter(it)
            binding.recyclerFilteredGames.adapter = adapter
            binding.recyclerFilteredGames.layoutManager = GridLayoutManager(context, 3)
        }

        _binding = FragmentGamesByPlatformBinding.inflate(inflater, container, false)
        return binding.root
    }







    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}