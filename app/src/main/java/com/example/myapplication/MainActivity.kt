package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.adapters.ViewPagerAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragments.VideoFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.util.Locale
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countdown()

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Video"
                1 -> tab.text = "Notes"
                2 -> tab.text = "Quiz"
            }
        }.attach()
    }

    private fun countdown() {
        val duration: Long = TimeUnit.MINUTES.toMillis(10)
        object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                val sDuration: String = String.format(
                    Locale.ENGLISH,
                    "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    )
                )
                binding.timer.text = sDuration

            }
            override fun onFinish() {
                Toast.makeText(
                    applicationContext,
                    "Time up",
                    Toast.LENGTH_LONG
                ).show()
            }
        }.start()
    }

}