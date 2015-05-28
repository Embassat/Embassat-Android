package com.embassat.domain.entity

/**
 * Created by Quique on 20/05/15.
 */
data class Artist (val id: Long,
                   val name: String,
                   val start_date: String,
                   val imageURL: String,
                   val end_date: String,
                   val scenario: String,
                   val description: String,
                   val shareURL: String)