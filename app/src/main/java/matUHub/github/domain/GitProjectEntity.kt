package matUHub.github.domain

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView

data class GitProjectEntity(val id: Int, val name: String, val image: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GitProjectEntity> {
        override fun createFromParcel(parcel: Parcel): GitProjectEntity {
            return GitProjectEntity(parcel)
        }

        override fun newArray(size: Int): Array<GitProjectEntity?> {
            return arrayOfNulls(size)
        }
    }
}