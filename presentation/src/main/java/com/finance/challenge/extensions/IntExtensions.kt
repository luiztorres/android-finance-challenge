package com.finance.challenge.extensions

import android.content.res.Resources

/**
 * Created by LuizTorres on 15/08/18. #
 */

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()