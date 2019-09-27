package com.nilu.localechange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = getString(R.string.home_screen)

        btnSetting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }
}
