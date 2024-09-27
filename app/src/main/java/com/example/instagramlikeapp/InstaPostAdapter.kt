package com.example.instagramlikeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class InstaPostAdapter(private val postList: List<Post>) : RecyclerView.Adapter<InstaPostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val userPhoto: ImageView = itemView.findViewById(R.id.user_photo)
        val postImage: ImageView = itemView.findViewById(R.id.posted_picture)
        val likesCount: TextView = itemView.findViewById(R.id.likes_count)
        val commentsCount: TextView = itemView.findViewById(R.id.comments_count)
        val postDescription: TextView = itemView.findViewById(R.id.post_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.insta_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]

        holder.userName.text = post.userName
        Glide.with(holder.itemView.context)
            .load(post.userPhotoUrl)
            .into(holder.userPhoto)
        Glide.with(holder.itemView.context)
            .load(post.postImageUrl)
            .into(holder.postImage)
        holder.likesCount.text = post.likesCount.toString()
        holder.commentsCount.text = post.commentsCount.toString()
        holder.postDescription.text = post.postDescription
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}