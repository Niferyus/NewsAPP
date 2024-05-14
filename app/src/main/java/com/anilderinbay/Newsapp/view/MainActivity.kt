package com.anilderinbay.Newsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.anilderinbay.Newsapp.R
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        Hawk.init(this).build()

        bottomNavigationView.setupWithNavController(nav_host_fragment.findNavController())

    }
}