package com.example.submissiondicodingandroidpemula

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiondicodingandroidpemula.databinding.ItemArticleBinding

class ListAdapterArticle(private val listArticle: ArrayList<Article>) :
    RecyclerView.Adapter<ListAdapterArticle.ListViewHolder>() {

    class ListViewHolder(val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (title, description, image) = listArticle[position]
        Util.loadImage(holder.itemView.context,holder.binding.imgArticle, image, R.color.placeholder)
        holder.binding.tvItemTitle.text = title
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, Detail::class.java)
            intent.putExtra(Detail.EXTRA_TITLE, title)
            intent.putExtra(Detail.EXTRA_DESCRIPTION, description)
            intent.putExtra(Detail.EXTRA_IMAGE, image)

            context.startActivity(intent)
        }


    }
}