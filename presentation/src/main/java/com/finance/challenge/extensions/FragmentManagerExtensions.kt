package com.finance.challenge.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by LuizTorres on 01/08/18. #
 */

fun FragmentManager.getLastFragmentAtBackStack(): Fragment? {
    val lastIndex = this.backStackEntryCount - 1
    if (lastIndex < 0) {
        return null
    }

    val lastBackStackEntry = this.getBackStackEntryAt(lastIndex)
    return findFragmentByTag(lastBackStackEntry.name)
}