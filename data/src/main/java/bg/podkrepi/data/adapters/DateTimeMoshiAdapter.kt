package bg.podkrepi.data.adapters

import androidx.core.text.isDigitsOnly
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.Instant
import timber.log.Timber

object DateTimeMoshiAdapter {
    @FromJson
    fun fromJson(dateString: String): Instant? {
        val date = try {
            if (dateString.isDigitsOnly()) {
                Instant.ofEpochMilli(dateString.toLong().times(1000))
            } else {
                Instant.parse(dateString)
            }
        } catch (ex: Exception) {
            Timber.d(ex, "Failed parsing instant!")
            null
        }

        return date
    }

    @ToJson
    fun toJson(instant: Instant): String = instant.toString()
}
