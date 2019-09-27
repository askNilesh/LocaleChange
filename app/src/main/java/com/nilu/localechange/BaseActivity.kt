package com.nilu.localechange

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.util.*

open class BaseActivity : AppCompatActivity() {

    lateinit var prefManager: PrefManager

    override fun attachBaseContext(newBase: Context) {
        val newLocale: Locale
        prefManager = PrefManager(newBase)
        val lang = prefManager.language

        newLocale = when {
            lang.equals("es") -> Locale("es")
            lang.equals("hi_IN") -> Locale("hi", "IN")
            else -> Locale(lang)
        }
        super.attachBaseContext(ContextWrapper.wrap(newBase, newLocale))
    }
    
}