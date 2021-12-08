package com.brfdev.ui_components.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

fun Fragment.navigate(@NonNull directions: NavDirections) {
    findNavController().safeNavigate(directions)
}

fun Fragment.navigate(@IdRes redId: Int) {
    findNavController().safeNavigate(redId)
}

fun Fragment.navigate(@IdRes resId: Int, args: Bundle? = null, navOptions: NavOptions? = null) =
    findNavController().safeNavigate(resId, args, navOptions)

inline fun <F : Fragment, reified V : Any> F.navDirections() = inject<V> {
    parametersOf(this)
}

fun Fragment.getNavigatorGraphId() = findNavController().currentDestination?.parent?.id ?: 0

fun Fragment.getResourceName(id: Int): String = resources.getResourceEntryName(id)