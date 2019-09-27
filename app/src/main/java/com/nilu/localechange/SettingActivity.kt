package com.nilu.localechange

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.*

class SettingActivity : BaseActivity() {

    lateinit var langCode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar?.title = getString(R.string.setting_screen)
        btnEnglish.setOnClickListener {
            langCode = "en_US"
            removeSelection()
            makeSelection(langCode)
            tvSelectLanguage.text = getEnglishString(R.string.select_language)
            btnSubmit.text = getEnglishString(R.string.change_language)
            supportActionBar?.title =getEnglishString(R.string.setting_screen)
        }

        btnHindi.setOnClickListener {
            langCode = "hi"
            removeSelection()
            makeSelection(langCode)
            tvSelectLanguage.text = getHindiString(R.string.select_language)
            btnSubmit.text = getHindiString(R.string.change_language)
            supportActionBar?.title =getHindiString(R.string.setting_screen)
        }

        btnSpanish.setOnClickListener {
            langCode = "es"
            removeSelection()
            makeSelection(langCode)
            tvSelectLanguage.text = getSpanishString(R.string.select_language)
            btnSubmit.text = getSpanishString(R.string.change_language)
            supportActionBar?.title =getSpanishString(R.string.setting_screen)
        }

        btnSubmit.setOnClickListener {
            prefManager.language = langCode
            ActivityCompat.finishAffinity(this)
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun makeSelection(languageCode: String) {
        when (languageCode) {
            "en_US" -> {
                btnEnglish.setBackgroundColor(Color.BLACK)
                tvEnglish.setTextColor(Color.WHITE)
            }
            "hi" -> {
                btnHindi.setBackgroundColor(Color.BLACK)
                tvHindi.setTextColor(Color.WHITE)
            }
            "es" -> {
                btnSpanish.setBackgroundColor(Color.BLACK)
                tvSpanish.setTextColor(Color.WHITE)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        langCode = prefManager.language.toString()
        removeSelection()
        makeSelection(langCode)
    }

    private fun removeSelection() {
        btnEnglish.background = ContextCompat.getDrawable(this, R.drawable.white_rect_editext)
        btnHindi.background = ContextCompat.getDrawable(this, R.drawable.white_rect_editext)
        btnSpanish.background = ContextCompat.getDrawable(this, R.drawable.white_rect_editext)

        tvEnglish.setTextColor(Color.BLACK)
        tvHindi.setTextColor(Color.BLACK)
        tvSpanish.setTextColor(Color.BLACK)
    }

    private fun getHindiString(stringID : Int): String {
        val configuration = getEnglishConfiguration(Locale("hi"))
        return createConfigurationContext(configuration).resources.getString(stringID)
    }


    private fun getSpanishString(stringID : Int): String {
        val configuration = getEnglishConfiguration(Locale("es"))
        return createConfigurationContext(configuration).resources.getString(stringID)
    }

    private fun getEnglishString(stringID : Int): String {
        val configuration = getEnglishConfiguration(Locale("en"))
        return createConfigurationContext(configuration).resources.getString(stringID)
    }

    private fun getEnglishConfiguration(locale : Locale): Configuration {
        val configuration = Configuration(resources.configuration)
        configuration.setLocale(locale)
        return configuration
    }
}
