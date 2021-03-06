package com.whereisdarran.homelesshelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.whereisdarran.homelesshelper.ui.main.ResourceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ResourceFragment.newInstance())
                .commitNow()
        }
    }
}
