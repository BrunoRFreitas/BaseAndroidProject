package com.brfdev.ui_components.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavController.safeNavigate(directions: NavDirections) = try {
    navigate(directions)
} catch (e: Exception) {
}

fun NavController.safeNavigate(directions: NavDirections, navOptions: NavOptions? = null) = try {
    navigate(directions, navOptions)
} catch (e: Exception) {
}

fun NavController.safeNavigate(directions: NavDirections, navigatorExtras: Navigator.Extras) = try {
    navigate(directions, navigatorExtras)
} catch (e: Exception) {
}

fun NavController.safeNavigate(@IdRes resId: Int, args: Bundle? = null, navOptions: NavOptions? = null) = try {
    navigate(resId, args, navOptions)
} catch (e: Exception) {
}
