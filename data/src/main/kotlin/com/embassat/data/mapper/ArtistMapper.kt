package com.embassat.data.mapper

import com.embassat.data.embassat.model.EmbassatArtist
import com.embassat.domain.entity.Artist

/**
 * Created by Quique on 20/05/15.
 */

class ArtistMapper {

    fun transform(artists: List<EmbassatArtist>): List<Artist> {
        return artists map { transform(it) }
    }

    fun transform(artist: EmbassatArtist): Artist = Artist(
            artist.ID,
            artist.title,
            artist.date,
            artist.featured_image.guid)

}