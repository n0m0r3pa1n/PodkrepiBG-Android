package bg.podkrepi.data.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.util.Date

object UnixTimestampMoshiAdapter {
    @FromJson
    fun fromJson(string: String): Date {
        val value = string.toLong()
        return Date(value * 1000)
    }

    @ToJson
    fun toJson(date: Date): String = date.toString()
}
