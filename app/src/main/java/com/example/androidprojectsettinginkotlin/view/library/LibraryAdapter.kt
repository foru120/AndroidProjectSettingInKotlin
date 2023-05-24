package com.example.androidprojectsettinginkotlin.view.library

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojectsettinginkotlin.data.vo.Library
import com.example.androidprojectsettinginkotlin.databinding.LibraryItemBinding

class LibraryAdapter(
    private val context: Context,
    private val itemList: ArrayList<Library>
) : RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = LibraryItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    inner class ViewHolder(val binding: LibraryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Library) {
            binding.library = item
        }
    }
}