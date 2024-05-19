package com.example.safeargsnavigation.navigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// these are my screens
@Serializable
sealed class Screens {
    @Serializable
    data object ScreenA:Screens()

    @Serializable
    data class ScreenB(
        val userName:String?,
        val age:Int
    ):Screens()

    @Serializable
    data class ScreenC(
        val userData: UserData
    ):Screens()
}


@Serializable
@Parcelize
class UserData(
    val name:String?,
    val age:Int,
    val phone:String?
) : Parcelable



// add this nav type for passing custom objects
val CustomNavType = object : NavType<UserData>(
    isNullableAllowed = false
) {
    override fun put(bundle: Bundle, key: String, value: UserData) {
        bundle.putParcelable(key, value)
    }
    override fun get(bundle: Bundle, key: String): UserData {
        return if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU){
            bundle.getParcelable(key,UserData::class.java) as UserData
        }else{
            bundle.getParcelable<UserData>(key) as UserData
        }
    }

    override fun parseValue(value: String): UserData {
        return Json.decodeFromString<UserData>(value)
    }
    override fun serializeAsValue(value: UserData): String {
        return Json.encodeToString(value) // this function will convert your custom object to nav destination string
    }

    //hope you understand this:) Thank you

}