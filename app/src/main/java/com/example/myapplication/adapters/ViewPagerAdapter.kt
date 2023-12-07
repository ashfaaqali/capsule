package com.example.myapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.fragments.NotesFragment
import com.example.myapplication.fragments.QuizFragment
import com.example.myapplication.fragments.QuizResultFragment
import com.example.myapplication.fragments.VideoFragment

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VideoFragment()
            1 -> NotesFragment()
            2 -> QuizFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}