package edu.robertmo.freegamesviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import edu.robertmo.freegamesviewer.databinding.FragmentDiscoverGamesBinding
import edu.robertmo.freegamesviewer.ui.adapters.GameAdapter

class DiscoverGamesFragment : Fragment() {

    private var _binding: FragmentDiscoverGamesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DiscoverGamesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(DiscoverGamesViewModel::class.java)
        val platformChosen = arguments?.getString("platform")

        _binding = FragmentDiscoverGamesBinding.inflate(inflater, container, false)
        viewModel.games.observe(viewLifecycleOwner){
            val adapter = GameAdapter(it)
            binding.recyclerDiscover.adapter = adapter
            binding.recyclerDiscover.layoutManager = GridLayoutManager(context, 3)
        }
        return binding.root
    }



}