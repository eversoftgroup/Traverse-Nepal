@file:JvmName("ViewUtil")

package io.github.traverse_nepal.utilities

import android.view.View

inline fun View.gone() { this.visibility = View.GONE }
inline fun View.visible() { this.visibility = View.VISIBLE }
inline fun View.invisible() { this.visibility = View.INVISIBLE }