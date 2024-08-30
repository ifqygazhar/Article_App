package com.example.submissiondicodingandroidpemula

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiondicodingandroidpemula.databinding.ItemImageBinding

class ListAdapterImageArticle(private val listImage: ArrayList<String>) :
    RecyclerView.Adapter<ListAdapterImageArticle.ListViewHolder>() {

    private var onItemClickListener: ((ImageView, String) -> Unit)? = null

    class ListViewHolder(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val image = listImage[position]
        Util.loadImage(holder.binding.imgCrsl, image, R.drawable.ic_launcher_foreground)


        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(holder.binding.imgCrsl, image)
        }
    }
}
