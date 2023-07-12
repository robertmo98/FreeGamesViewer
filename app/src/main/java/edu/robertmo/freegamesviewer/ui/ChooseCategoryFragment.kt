package edu.robertmo.freegamesviewer.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import edu.dummy.finalprojectbeta1.ui.adapters.CategoryAdapter
import edu.robertmo.freegamesviewer.R
import edu.robertmo.freegamesviewer.databinding.FragmentChooseCategoryBinding

private const val CATEGORY = "category"
class ChooseCategoryFragment : Fragment() {

    private var _binding: FragmentChooseCategoryBinding?= null

    private val binding get() = _binding!!

    private lateinit var viewModel: ChooseCategoryViewModel


    private var choice = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(ChooseCategoryViewModel::class.java)
        _binding = FragmentChooseCategoryBinding.inflate(inflater, container, false)

        viewModel.categories.observe(viewLifecycleOwner) {
            val adapter = CategoryAdapter(it){ category ->
                choice = category
                val bundle = Bundle()
                bundle.putString(CATEGORY, choice)
                findNavController().navigate(R.id.action_chooseCategoryFragment_to_gamesByCategory, bundle)
            }
            binding.recyclerCategories.adapter = adapter
            binding.recyclerCategories.layoutManager = GridLayoutManager(context, 3)

        }

        return binding.root
    }



}