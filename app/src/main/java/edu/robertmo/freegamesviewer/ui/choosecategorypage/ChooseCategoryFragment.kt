package edu.robertmo.freegamesviewer.ui.choosecategorypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import edu.robertmo.freegamesviewer.ui.adapters.CategoryAdapter
import edu.robertmo.freegamesviewer.R
import edu.robertmo.freegamesviewer.databinding.FragmentChooseCategoryBinding
import edu.robertmo.freegamesviewer.ui.MainActivity

private const val CATEGORY = "category"
class ChooseCategoryFragment : Fragment() {

    private var _binding: FragmentChooseCategoryBinding?= null

    private val binding get() = _binding!!

    private lateinit var viewModel: ChooseCategoryViewModel

    //the "choice" will be replaced with the users response. choice=category chosen
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
                // Clicking on any category will pass the category to the next fragment
                findNavController().navigate(
                    R.id.action_chooseCategoryFragment_to_gamesByCategory,
                    bundle
                )
            }
            binding.recyclerCategories.adapter = adapter
            binding.recyclerCategories.layoutManager = GridLayoutManager(context, 3)

        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        // set the name on the upper menu ber
        (activity as? MainActivity)?.setToolbarTitle("Choose Category")
    }



}