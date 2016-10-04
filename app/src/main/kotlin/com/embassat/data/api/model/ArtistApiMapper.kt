package com.embassat.data.api.model

import com.embassat.domain.entity.Artist

class ArtistApiMapper {
    fun transform(apis: List<ArtistApi>): List<Artist> {
        return apis.map { transform(it) }
    }

    fun transform(api: ArtistApi): Artist = Artist(
            api.id,
            api.name,
            api.start_date,
            api.image_url,
            api.end_date,
            api.stage,
            api.description,
            api.share_url,
            api.youtube_video_id)
}