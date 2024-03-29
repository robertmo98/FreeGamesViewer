package edu.robertmo.freegamesviewer.ui.firstpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.robertmo.freegamesviewer.R
import edu.robertmo.freegamesviewer.databinding.FragmentFirstBinding
import edu.robertmo.freegamesviewer.ui.MainActivity


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

        setupListeners()

        return binding.root
    }

    //clicking on any item will lead to the relevant fragment
    private fun setupListeners() {
        binding.btnPlatforms.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_choosePlatformFragment)
        }

        binding.btnCategories.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_chooseCategoryFragment)
        }

        binding.btnLatestReleaseDate.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_discoverGamesFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        // set the name on the upper menu ber
        (activity as? MainActivity)?.setToolbarTitle("Main Page")
    }
}
