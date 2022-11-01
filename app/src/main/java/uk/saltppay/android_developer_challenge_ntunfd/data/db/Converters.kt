package uk.saltppay.android_developer_challenge_ntunfd.data.db

import androidx.room.TypeConverter
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.IdAttributes
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.ItunesId
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.NestedLabel

class Converters {

    @TypeConverter
    fun stringToNestedLabel(label: String?): NestedLabel? {
        return label?.let { NestedLabel(it) }
    }

    @TypeConverter
    fun fromNestedLabel(nestedLabel: NestedLabel?): String? {
        return nestedLabel?.label
    }

    @TypeConverter
    fun stringToItunesId(id: String?): ItunesId? {
        return id?.let { ItunesId(null, IdAttributes(it)) }
    }

    @TypeConverter
    fun fromItunesId(itunesId: ItunesId?): String? {
        return itunesId?.attributes?.id
    }
}