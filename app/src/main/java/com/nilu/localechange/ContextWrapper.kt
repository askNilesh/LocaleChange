package com.nilu.localechange

import android.content.Context
import android.os.Build
import android.os.LocaleList

import java.util.Locale

@Suppress("DEPRECATION")
class ContextWrapper(base: Context) : android.content.ContextWrapper(base) {
    companion object {
        fun wrap(context: Context, newLocale: Locale): ContextWrapper {
            var mContext = context

            val res = mContext.resources
            val configuration = res.configuration

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                    configuration.setLocale(newLocale)
                    val localeList = LocaleList(newLocale)
                    LocaleList.setDefault(localeList)
                    configuration.setLocales(localeList)
                    mContext = context.createConfigurationContext(configuration)
                }
                else -> {
                    configuration.locale = newLocale
                    res.updateConfiguration(configuration, res.displayMetrics)
                }
            }
            return ContextWrapper(mContext)
        }
    }
}
