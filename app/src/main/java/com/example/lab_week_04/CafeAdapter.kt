package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// Judul tab
val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title
)

// Konten per tab (pakai resource id deskripsi)
private val CONTENTS = listOf(
    R.string.starbucks_desc,
    R.string.janjijiwa_desc,
    R.string.kopikenangan_desc
)

/**
 * Konstruktor paling simpel: pass Fragment host ke FragmentStateAdapter(host)
 * sehingga kita bisa pakai host.getString() untuk resolve teks.
 */
class CafeAdapter(private val host: Fragment) : FragmentStateAdapter(host) {

    override fun getItemCount(): Int = TABS_FIXED.size

    override fun createFragment(position: Int): Fragment {
        val contentText = host.getString(CONTENTS[position])
        return CafeDetailFragment.newInstance(contentText)
    }
}
