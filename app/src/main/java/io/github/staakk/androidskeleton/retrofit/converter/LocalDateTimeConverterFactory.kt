package io.github.staakk.androidskeleton.retrofit.converter

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

/**
 * Created by staakk on 22/02/18.
 */
class LocalDateTimeConverterFactory : Converter.Factory() {

    override fun stringConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<LocalDateTime, String>? {
        return if (LocalDateTime::class.java != type) null else LocalDateTimeConverter.INSTANCE
    }

    private class LocalDateTimeConverter : Converter<LocalDateTime, String> {

        @Throws(IOException::class)
        override fun convert(value: LocalDateTime): String {
            return value.format(DateTimeFormatter.ISO_DATE_TIME)
        }

        companion object {
            internal val INSTANCE = LocalDateTimeConverter()
        }
    }
}