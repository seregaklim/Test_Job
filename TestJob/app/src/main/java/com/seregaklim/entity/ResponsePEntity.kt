package com.seregaklim.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.seregaklim.data.ResponseX

@Entity
    (tableName = "Response")
data class ResponsePEntity(
    @ColumnInfo(name="amount")
    val amount: String,
    @ColumnInfo(name="created")
    val created: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name="title")
    val title: String,
) {
    fun toDto() = ResponseX(amount, created, id, title)


    companion object {
        fun fromDto(dto: ResponseX) =
            ResponsePEntity(dto.amount, dto.created, dto.id, dto.title)

    }
}

fun List<ResponsePEntity>.toDto(): List<ResponseX> = map(ResponsePEntity::toDto)
fun List<ResponseX>.toEntity(): List<ResponsePEntity> = map(ResponsePEntity::fromDto)