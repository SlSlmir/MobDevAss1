package com.example.instagramlikeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val userNames = listOf(
        "john_doe", "jane_smith", "charlie_brown", "emily_rivers", "mike_jones",
        "lisa_white", "oliver_twist", "sarah_connor", "jack_sparrow", "elena_gilbert",
        "clark_kent", "bruce_wayne", "harry_potter", "hermione_granger", "peter_parker",
        "tony_stark", "steve_rogers", "natasha_romanoff", "wanda_maximoff", "vision_thebot",
        "barry_allen", "diana_prince", "arthur_curry", "loki_odinson", "thor_godofthunder",
        "t'challa_blackpanther", "shuri_wakanda", "gamora_zenwhoberi", "nebula_thanos", "rocket_raccoon"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val posts = generatePosts()
        val recyclerView: RecyclerView = findViewById(R.id.post_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = InstaPostAdapter(posts)
    }

    private fun generatePosts(): List<Post> {
        return (0 until 30).map { i ->
            Post(
                userName = userNames[i % userNames.size],
                userPhotoUrl = generateUserPhotoUrl(i + 1),
                postImageUrl = generatePostImageUrl(i + 1),
                likesCount = (100..1000).random(),
                commentsCount = (1..100).random(),
                postDescription = "${userNames[i % userNames.size]}: This is an amazing post #$i!"
            )
        }
    }

    private fun generateUserPhotoUrl(index: Int): String {
        return "https://loremflickr.com/150/150/person?random=$index"
    }

    private fun generatePostImageUrl(index: Int): String {
        return "https://loremflickr.com/500/500/nature?random=$index"
    }
}