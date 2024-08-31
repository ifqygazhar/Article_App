package com.example.submissiondicodingandroidpemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.submissiondicodingandroidpemula.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Article>()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.includeToolbar.toolbar)

        val rvArticle = binding.rvArticle
        rvArticle.setHasFixedSize(true)
        list.addAll(getListArticle())
        showRecycleList()


        val imageList = getImageList()
        binding.imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about_page -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
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

    private fun showRecycleList() {
        binding.rvArticle.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = ListAdapterArticle(list)
        binding.rvArticle.adapter = listArticleAdapter
    }

    private fun getImageList(): ArrayList<SlideModel> {
        val imageUrls = resources.getStringArray(R.array.article_image)
        val imageList = ArrayList<SlideModel>()
        
        val indices = imageUrls.indices.shuffled(Random)

        val randomIndices = indices.take(3)

        for (index in randomIndices) {
            imageList.add(SlideModel(imageUrls[index]))
        }

        return imageList
    }
}
