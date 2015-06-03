package com.embassat.presentation.entity

import java.io.Serializable

/**
 * Created by Quique on 25/5/15.
 */

data class ArtistDetail(val id: Long, val name: String, val description: String, val day: String, val time: String, val stage: String, val imageURL: String, val real_start_date: String) : Serializable