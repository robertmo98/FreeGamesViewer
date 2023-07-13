package edu.robertmo.freegamesviewer.ui.chooseplatformpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.robertmo.freegamesviewer.R
import edu.robertmo.freegamesviewer.databinding.FragmentChoosePlatformBinding
import edu.robertmo.freegamesviewer.ui.MainActivity

class ChoosePlatformFragment : Fragment() {

    private var _binding: FragmentChoosePlatformBinding?= null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChoosePlatformBinding.inflate(inflater, container, false)

        binding.imageComputer.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("platform","pc")
            findNavController().navigate(R.id.action_choosePlatformFragment_to_gamesByPlatformFragment, bundle)
        }
        binding.imageBrowser.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("platform","browser")
            findNavController().navigate(R.id.action_choosePlatformFragment_to_gamesByPlatformFragment, bundle)
        }

        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        // set the name on the upper menu ber
        (activity as? MainActivity)?.setToolbarTitle("Platform Choice Page")
    }

}