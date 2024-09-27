package com.example.instagramlikeapp

data class Post(
    val userName: String,
    val userPhotoUrl: String,
    val postImageUrl: String,
    val likesCount: Int,
    val commentsCount: Int,
    val postDescription: String
)