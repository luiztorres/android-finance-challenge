package com.finance.challenge.extensions

import android.content.SharedPreferences
import com.google.gson.Gson

/**
 * Created by LuizTorres on 02/08/18. #
 */

inline fun <reified T> SharedPreferences.getJson(name: String, default: String = ""): T? {
    return try {
        Gson().fromJson(getString(name, default) ?: default, T::class.java)
    } catch (ignored: Exception) {
        null
    }
}

fun <T> SharedPreferences.Editor.putJson(name: String, value: T): SharedPreferences.Editor {
    putString(name, Gson().toJson(value))
    return this
}
