package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val items: MutableLiveData<List<ItemModel>> = MutableLiveData()
    private var isLoginState = false;

    fun login(job:IFinishedListener<Boolean>) {
        isLoginState = true
        job.finished(isLoginState)
    }

    fun isLogin(): Boolean {
        return isLoginState;
    }

    fun load() {

    }

    fun getItem(index: Int): ItemModel {
        return items.value!![index];
    }
}

interface IFinishedListener<T> {
    fun finished(result:T)
}

class ItemModel() : Parcelable {
    var context: String? = ""

    constructor(parcel: Parcel) : this() {
        context = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(context)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemModel> {
        override fun createFromParcel(parcel: Parcel): ItemModel {
            return ItemModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemModel?> {
            return arrayOfNulls(size)
        }
    }
}