package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// Judul-judul tab (pakai string resources)
val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = TABS_FIXED.size

    override fun createFragment(position: Int): Fragment {
        // Untuk latihan, semua tab pakai fragment yang sama
        return CafeDetailFragment()
    }
}
