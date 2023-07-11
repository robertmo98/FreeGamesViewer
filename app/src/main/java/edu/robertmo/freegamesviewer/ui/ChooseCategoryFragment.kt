package edu.robertmo.freegamesviewer.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.robertmo.freegamesviewer.R

class ChooseCategoryFragment : Fragment() {

    companion object {
        fun newInstance() = ChooseCategoryFragment()
    }

    private lateinit var viewModel: ChooseCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChooseCategoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}