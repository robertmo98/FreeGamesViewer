package edu.robertmo.freegamesviewer.ui.firstpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.robertmo.freegamesviewer.R
import edu.robertmo.freegamesviewer.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.btnPlatforms.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_choosePlatformFragment)
        }

        binding.btnCategories.setOnClickListener {
            findNavController().navigate(R.id.action_chooseCategoryFragment_to_gamesByCategory)
        }

        binding.btnDiscoverGames.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_discoverGamesFragment)
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
