package com.trihashstudio.noortasbih.presentation


import android.content.Context
import android.content.SharedPreferences

object PrefsManager {
    private const val PREFS_NAME = "tasbih_prefs"
    private const val KEY_ONBOARDING_COMPLETED = "onboarding_completed"

    fun setOnboardingCompleted(context: Context, completed: Boolean) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_ONBOARDING_COMPLETED, completed).apply()
    }

    fun isOnboardingCompleted(context: Context): Boolean {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_ONBOARDING_COMPLETED, false)
    }
}
