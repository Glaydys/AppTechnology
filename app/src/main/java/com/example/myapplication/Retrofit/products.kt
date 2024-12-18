package com.example.myapplication.Retrofit
import android.os.Parcel
import android.os.Parcelable

data class products(
    val _id: String,
    val name_product: String,
    val price: String,
    val description: String,
    val image_product: String,
    val category_id: Int,
    val quantity: Int,
    val rate: Float,
    val totalComments: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt() ,
        parcel.readFloat(),
        parcel.readInt()
        )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(name_product)
        parcel.writeString(price)
        parcel.writeString(description)
        parcel.writeString(image_product)
        parcel.writeInt(category_id)
        parcel.writeInt(quantity)
        parcel.writeFloat(rate)
        parcel.writeInt(totalComments)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<products> {
        override fun createFromParcel(parcel: Parcel): products {
            return products(parcel)
        }

        override fun newArray(size: Int): Array<products?> {
            return arrayOfNulls(size)
        }
    }
}

