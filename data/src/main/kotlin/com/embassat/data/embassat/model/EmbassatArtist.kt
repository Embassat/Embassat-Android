package com.embassat.data.embassat.model

import com.embassat.data.embassat.model.EmbassatArtistFeaturedImage

/**
 * Created by Quique on 14/04/15.
 */
data class EmbassatArtist (
        val ID: Long,
        val title: String,
        val date: String,
        val featured_image: EmbassatArtistFeaturedImage)