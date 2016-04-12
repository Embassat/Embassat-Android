package com.embassat.presentation.entity

import java.io.Serializable

/**
 * Created by Quique on 1/6/15.
 */
data class ArtistSchedule(val id: Long, val name: String, val start_time: String, val end_time: String, val stage: String, val day: String, val real_start_date: String) : Serializable