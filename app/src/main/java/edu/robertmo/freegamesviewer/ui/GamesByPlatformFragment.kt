package edu.robertmo.freegamesviewer.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import edu.robertmo.freegamesviewer.R
import edu.robertmo.freegamesviewer.databinding.FragmentGamesByPlatformBinding
import edu.robertmo.freegamesviewer.service.GameService
import edu.robertmo.freegamesviewer.ui.adapters.GameAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GamesByPlatformFragment : Fragment() {

    private var _binding: FragmentGamesByPlatformBinding?= null

    private val binding get() = _binding!!

    private lateinit var viewModel: GamesByPlatformViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(GamesByPlatformViewModel::class.java)
        val platform = requireArguments().getString("platform")
        viewModel.setGameService(GameService.create())
        if (platform != null) {
            viewModel.setChosenPlatform(platform)
        }



        viewModel.games.observe(viewLifecycleOwner) {
            val adapter = GameAdapter(it)
            binding.recyclerGeneral.adapter = adapter
            binding.recyclerGeneral.layoutManager = GridLayoutManager(context, 3)
        }

        _binding = FragmentGamesByPlatformBinding.inflate(inflater, container, false)
        return binding.root
    }







    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



}