package com.embassat.data.api.model

data class ArtistApi(
        val id: Long,
        val name: String,
        val description: String,
        val image_url: String,
        val share_url: String,
        val stage: String,
        val start_date: String,
        val end_date: String,
        val youtube_video_id: String)