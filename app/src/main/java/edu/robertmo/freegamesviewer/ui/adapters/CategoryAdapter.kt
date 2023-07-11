package edu.dummy.finalprojectbeta1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import edu.robertmo.freegamesviewer.databinding.CategoryItemBinding

class CategoryAdapter(private val categories: List<String>, private val callback: (category: String)->Unit):
    Adapter<CategoryAdapter.VH>() {

    override fun onBindViewHolder(holder: CategoryAdapter.VH, position: Int) {
        val category = categories[position]
        holder.binding.categoryText.text = category
        holder.binding.root.setOnClickListener{
            callback(category)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.VH {
        return CategoryAdapter.VH(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = categories.size



    class VH(val binding: CategoryItemBinding): ViewHolder(binding.root)
}