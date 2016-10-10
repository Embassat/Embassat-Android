package com.embassat.domain

import android.content.Context
import com.path.android.jobqueue.JobManager
import com.path.android.jobqueue.config.Configuration

/**
 * Created by Quique on 20/05/15.
 */
class CustomJobManager(context: Context) : JobManager(context, CustomJobManager.getJobManagerConfiguration(context)) {

    companion object {

        private val TAG = "JOBS"

        private fun getJobManagerConfiguration(context: Context): Configuration {
            return Configuration.Builder(context)
                    .minConsumerCount(1)    // always keep at least one consumer alive
                    .maxConsumerCount(3)    // up to 3 consumers at NextOnEditorActionListener time
                    .loadFactor(3)          // 3 jobs per consumer
                    .consumerKeepAlive(120) // wait 2 minutes
                    .build();

        }
    }
}