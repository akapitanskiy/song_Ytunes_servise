package uk.saltppay.android_developer_challenge_ntunfd.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import uk.saltppay.android_developer_challenge_ntunfd.R
import uk.saltppay.android_developer_challenge_ntunfd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}