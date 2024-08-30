package com.example.submissiondicodingandroidpemula

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissiondicodingandroidpemula.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Article>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listImage = getImageArticle()
        showImageCarousel(listImage)


        val rvArticle = binding.rvArticle
        rvArticle.setHasFixedSize(true)
        list.addAll(getListArticle())
        showRecycleList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getListArticle(): ArrayList<Article> {
        val dataTitle = resources.getStringArray(R.array.article_title)
        val dataDescription = resources.getStringArray(R.array.article_description)
        val dataImage = resources.getStringArray(R.array.article_image)

        val listArticle = ArrayList<Article>()
        for (i in dataTitle.indices) {
            val article = Article(dataTitle[i], dataDescription[i], dataImage[i])
            listArticle.add(article)
        }

        return listArticle
    }

    private fun getImageArticle(): ArrayList<String> {
        val dataImage = resources.getStringArray(R.array.article_image)
        return ArrayList(dataImage.toList())
    }

    private fun showImageCarousel(listImage: ArrayList<String>) {
        val rvImage = binding.rvImage
        rvImage.setHasFixedSize(true)
        rvImage.adapter = ListAdapterImageArticle(listImage)
    }

    private fun showRecycleList() {
        binding.rvArticle.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = ListAdapterArticle(list)
        binding.rvArticle.adapter = listArticleAdapter
    }


}
