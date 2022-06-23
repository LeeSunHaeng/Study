package com.example.sample34intent

import android.os.Parcel
import android.os.Parcelable

//Parcel : 꾸러미, 소포
class student(var name:String?, var count:Int, var level:String?) :Parcelable {
    constructor(parcel:Parcel):this(parcel.readString(),parcel.readInt(),parcel.readString())

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(name)
        parcel?.writeInt(count)
        parcel?.writeString(level)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<student> {
        override fun createFromParcel(parcel: Parcel): student {
            return student(parcel)
        }

        override fun newArray(size: Int): Array<student?> {
            return arrayOfNulls(size)
        }
    }
}