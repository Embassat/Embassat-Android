package com.embassat.domain.interactor.event

import com.embassat.domain.entity.Artist
import com.embassat.domain.interactor.base.Event

/**
 * Created by Quique on 20/05/15.
 */

class ArtistsEvent(val artists: List<Artist>) : Event