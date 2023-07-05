package github.mik0war.betmatchapp.core

import android.content.Context
import android.support.annotation.ColorRes
import github.mik0war.betmatchapp.R

interface ColorProvider {
    fun provideColor(@ColorRes resId: Int): Int
}

class ContextColorProvider(
    private val context: Context
) : ColorProvider {
    override fun provideColor(resId: Int) = context.getColor(resId)
}

class ColorGetter(
    private val context: ColorProvider
) {

    fun getColor(position: Int) =
        if (position == 0)
            context.provideColor(R.color.main_color)
        else
            when (position % 2) {
                0 -> context.provideColor(R.color.white)
                else -> context.provideColor(R.color.gray)
            }

}