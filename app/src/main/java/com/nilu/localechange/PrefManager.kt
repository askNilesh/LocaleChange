package com.nilu.localechange

import android.content.Context
import android.content.SharedPreferences

class PrefManager(private val mContext: Context) {

    private var editor: SharedPreferences.Editor? = null
    private var prefs: SharedPreferences? = null

    private val LANGUAGE = "language"
    private val PREF = "user_info"

    var language: String?
        get() {
            this.prefs = this.mContext.getSharedPreferences(PREF, 0)
            return this.prefs!!.getString(LANGUAGE, "en_US")
        }
        set(language) {
            this.editor = this.mContext.getSharedPreferences(PREF, 0).edit()
            this.editor!!.putString(LANGUAGE, language)
            this.editor!!.apply()
        }

}
